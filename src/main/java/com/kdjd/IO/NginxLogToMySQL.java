package com.kdjd.IO;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NginxLogToMySQL {

    private static final Pattern LOG_PATTERN = Pattern.compile(
            "^(\\S+) - (\\S+) \\[([^\\]]+)\\] \"([^\"]*)\" (\\d{3}) (\\d+) \"([^\"]*)\" \"([^\"]*)\""
    );

    private static final DateTimeFormatter DATE_FORMATTER =
            DateTimeFormatter.ofPattern("dd/MMM/yyyy:HH:mm:ss Z")
                    .withLocale(Locale.ENGLISH);

    private static final int BATCH_SIZE = 1000;

    public static void main(String[] args) {

        String logFilePath = "D:\\Document\\Download\\nginxlog2\\bk.access.log";
        String jdbcUrl = "jdbc:mysql://192.168.0.149:3336/test_huan?useSSL=false&serverTimezone=UTC";
        String username = "root";
        String password = "111111";

        try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
             BufferedReader reader = new BufferedReader(
                     new InputStreamReader(Files.newInputStream(Paths.get(logFilePath)), StandardCharsets.UTF_8),
                     1024 * 1024)) {

            conn.setAutoCommit(false);
            String insertSql = "INSERT INTO nginx_logs " +
                    "(remote_addr, remote_user, time_local, request, method, uri, path, query_string, protocol, " +
                    "status, body_bytes_sent, http_referer, http_user_agent) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            Calendar cal = Calendar.getInstance();
            cal.set(Calendar.HOUR_OF_DAY,8);
            cal.set(Calendar.MINUTE,0);
            cal.set(Calendar.SECOND,0);
            cal.set(Calendar.MILLISECOND,0);
            Date startDate =  cal.getTime();
            try (PreparedStatement pstmt = conn.prepareStatement(insertSql)) {
                String line;
                long lineNumber = 0;
                int batchCount = 0;
                int totalInserted = 0;

                while ((line = reader.readLine()) != null) {
                    lineNumber++;
                    NginxLogEntry entry = parseLogLine(line, lineNumber);
                    if (entry != null) {
                        pstmt.setString(1, entry.remoteAddr);
                        pstmt.setString(2, entry.remoteUser);
                        Timestamp timestamp = Timestamp.valueOf(entry.timeLocal);
                        if (timestamp.before(startDate))
                            continue;
                        pstmt.setTimestamp(3, timestamp);
                        pstmt.setString(4, entry.rawRequest);
                        pstmt.setString(5, entry.method);
                        pstmt.setString(6, entry.uri);
                        pstmt.setString(7, entry.path);
                        pstmt.setString(8, entry.queryString);
                        pstmt.setString(9, entry.protocol);
                        pstmt.setInt(10, entry.status);
                        pstmt.setLong(11, entry.bodyBytesSent);
                        pstmt.setString(12, entry.httpReferer);
                        pstmt.setString(13, entry.httpUserAgent);
                        pstmt.addBatch();
                        batchCount++;

                        if (batchCount >= BATCH_SIZE) {
                            pstmt.executeBatch();
                            conn.commit();
                            totalInserted += batchCount;
                            System.err.println("已提交 " + totalInserted + " 行");
                            batchCount = 0;
                        }
                    } else {
                        System.err.println("跳过无法解析的行 " + lineNumber + ": " + line);
                    }
                }

                if (batchCount > 0) {
                    pstmt.executeBatch();
                    conn.commit();
                    totalInserted += batchCount;
                    System.err.println("已提交最后 " + batchCount + " 行，总计插入 " + totalInserted + " 行");
                }
            } catch (SQLException e) {
                conn.rollback();
                System.err.println("数据库操作失败，已回滚: " + e.getMessage());
                throw e;
            }
        } catch (IOException e) {
            System.err.println("读取文件失败: " + e.getMessage());
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("数据库连接失败: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static NginxLogEntry parseLogLine(String line, long lineNumber) {
        Matcher matcher = LOG_PATTERN.matcher(line);
        if (!matcher.matches()) {
            return null;
        }

        try {
            String remoteAddr = matcher.group(1);
            String remoteUser = matcher.group(2).equals("-") ? null : matcher.group(2);
            String timeStr = matcher.group(3);
            LocalDateTime timeLocal = LocalDateTime.parse(timeStr, DATE_FORMATTER);
            String rawRequest = matcher.group(4);
            int status = Integer.parseInt(matcher.group(5));
            long bodyBytesSent = Long.parseLong(matcher.group(6));
            String httpReferer = matcher.group(7).equals("-") ? null : matcher.group(7);
            String httpUserAgent = matcher.group(8).equals("-") ? null : matcher.group(8);

            // 拆分 request -> method, uri, protocol
            String method = null;
            String uri = null;
            String protocol = null;
            if (rawRequest != null && !rawRequest.isEmpty()) {
                String[] parts = rawRequest.split(" ", 3);
                if (parts.length == 3) {
                    method = parts[0];
                    uri = parts[1];
                    protocol = parts[2];
                } else {
                    method = rawRequest;
                }
            }

            // 拆分 uri -> path + queryString
            String path = null;
            String queryString = null;
            if (uri != null && !uri.isEmpty()) {
                int qmarkIdx = uri.indexOf('?');
                if (qmarkIdx >= 0) {
                    path = uri.substring(0, qmarkIdx);
                    // 避免 queryString 为 "?" 或空字符串
                    if (qmarkIdx + 1 < uri.length()) {
                        queryString = uri.substring(qmarkIdx + 1);
                    } else {
                        queryString = null;
                    }
                } else {
                    path = uri;
                    queryString = null;
                }
            }

            return new NginxLogEntry(remoteAddr, remoteUser, timeLocal, rawRequest,
                    method, uri, path, queryString, protocol,
                    status, bodyBytesSent, httpReferer, httpUserAgent);
        } catch (Exception e) {
            System.err.println("解析行 " + lineNumber + " 时发生异常: " + e.getMessage());
            return null;
        }
    }

    private static class NginxLogEntry {
        final String remoteAddr;
        final String remoteUser;
        final LocalDateTime timeLocal;
        final String rawRequest;
        final String method;
        final String uri;
        final String path;
        final String queryString;
        final String protocol;
        final int status;
        final long bodyBytesSent;
        final String httpReferer;
        final String httpUserAgent;

        NginxLogEntry(String remoteAddr, String remoteUser, LocalDateTime timeLocal,
                      String rawRequest, String method, String uri, String path, String queryString,
                      String protocol, int status, long bodyBytesSent,
                      String httpReferer, String httpUserAgent) {
            this.remoteAddr = remoteAddr;
            this.remoteUser = remoteUser;
            this.timeLocal = timeLocal;
            this.rawRequest = rawRequest;
            this.method = method;
            this.uri = uri;
            this.path = path;
            this.queryString = queryString;
            this.protocol = protocol;
            this.status = status;
            this.bodyBytesSent = bodyBytesSent;
            this.httpReferer = httpReferer;
            this.httpUserAgent = httpUserAgent;
        }
    }
}
