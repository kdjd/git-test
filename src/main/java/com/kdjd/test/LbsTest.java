package com.kdjd.test;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.StringUtils;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class LbsTest {


    // 数据库连接参数（请根据实际情况修改）
    private static final String URL = "jdbc:mysql://192.168.0.45:8066/dnCd?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=true&serverTimezone=GMT%2B8";
    private static final String USER = "root";
    private static final String PASSWORD = "cdkj56077609";

    private static final String ID = "ID";
    private static final String MCC = "MCC";
    private static final String MNC = "MNC";
    private static final String AC = "AC";
    private static final String CI = "CI";
    private static final String ADDRESS = "ADDRESS";

    private static Map<String, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        int count = 0;

        // 0 {"errcode": 0, "lat": "39.563888", "lon": "116.461311", "radius": "677", "address": "北京市大兴区安定镇杜庄屯三条"}

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // 1. 加载 MySQL 驱动（JDK 1.8 中可省略，但建议保留）
            Class.forName("com.mysql.jdbc.Driver");
            // 2. 建立连接
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            //System.out.println("数据库连接成功！");
            // 3. 创建 Statement 对象
            stmt = conn.createStatement();
            // 4. 执行查询 SQL
            String sql = "SELECT * FROM T_LOCATION_BASE_460 WHERE old IS NULL AND address = ''";
            rs = stmt.executeQuery(sql);

            // 5. 处理结果集
            while (rs.next()) {
                count++;
                String id = rs.getString(ID);
                int mcc = rs.getInt(MCC);
                int mnc = rs.getInt(MNC);
                int ac = rs.getInt(AC);
                int ci = rs.getInt(CI);
                String address = rs.getString(ADDRESS);
                if (StringUtils.isNotBlank(address)) {
                    continue;
                }
                //System.out.println(id + "_" + mcc + "_" + mnc + "_" + ac + "_" + ci);

                while (!todo()) {
                    System.out.println(currentTIme() + "开始休眠");
                    Thread.sleep(1000 * 60 * 10);
                }

                LocationInfo result = tryTogGtResult(mcc, mnc, ac, ci);
                if (result != null) {
                    updateData(conn, id, result);
                }
                Thread.sleep(10 * 1000);
            }
        } catch (ClassNotFoundException e) {
            System.err.println(currentTIme() + "MySQL 驱动未找到，请检查驱动 JAR 是否已添加到类路径中。");
        } catch (SQLException e) {
            System.err.println(currentTIme() + "数据库操作失败！");
        } catch (Exception e) {
            System.err.println(currentTIme() + "获取基站信息失败！:" + e.getLocalizedMessage());
        } finally {
            // 6. 关闭资源（按倒序关闭）
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private static String currentTIme() {
        return new SimpleDateFormat("yyyyMMdd HH:mm:ss").format(new Date()) + " : ";
    }

    private static boolean todo() {
        String formatStr = "yyyyMMddHHm";
        SimpleDateFormat format = new SimpleDateFormat(formatStr);

        String cacheKey = format.format(new Date()).substring(0, 11);

        Integer cnt = map.get(cacheKey);
        if (cnt == null) {
            cnt = 1;
        } else {
            cnt++;
        }
        map.put(cacheKey, cnt);
        return cnt < 200;
    }

    private static void updateData(Connection conn, String id, LocationInfo info) throws SQLException {
        String sql = "UPDATE T_LOCATION_BASE_460 SET LAT = ?, LNG = ?, ADDRESS = ? WHERE ID = ? LIMIT 1";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, info.getLat());
            pstmt.setString(2, info.getLon());
            pstmt.setString(3, info.getAddress());
            pstmt.setString(4, id);
            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                System.out.println(currentTIme() + "更新成功，影响了 " + affectedRows + " 行。ID:" + id);
            } else {
                System.out.println(currentTIme() + "未找到 id = " + id + " 的记录，更新失败。");
            }
        }
    }

    private static LocationInfo tryTogGtResult(int mcc, int mnc, int lac, int ci) {
        LocationInfo result = null;
        for (int i = 0; i < 3; i++) {
            try {
                result = getResult(mcc, mnc, lac, ci);
            } catch (Exception e) {
                System.out.println(currentTIme() + "HTTP请求异常：" + e.getMessage());
                e.printStackTrace();
            }
            if (result != null) {
                break;
            } else {
                try {
                    Thread.sleep(10 * 1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return result;
    }

    private static LocationInfo getResult(int mcc, int mnc, int lac, int ci) throws IOException {
        DataInputStream in;
        HttpURLConnection connection;
        String output = "json";

        String urlStr = "http://api.cellocation.com:84/cell"
                + "?mcc=" + mcc + "&mnc=" + mnc + "&lac=" + lac + "&ci=" + ci + "&output=" + output;

        URL url = new URL(urlStr);
        connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setUseCaches(false);
        connection.setDefaultUseCaches(false);
        connection.setDoInput(true);
        connection.setDoOutput(true);
        connection.setConnectTimeout(60000);
        connection.setReadTimeout(60000);
        in = new DataInputStream(connection.getInputStream());
        int all = in.available();
        int code = connection.getResponseCode();
        if (code == HttpURLConnection.HTTP_OK) {
            byte[] b = new byte[all];
            int read = in.read(b);
            String result = new String(b, StandardCharsets.UTF_8);
            //System.out.println(result);
            return JSONObject.parseObject(result, LocationInfo.class);
        }
        return null;
    }
}

class LocationInfo {

    @JsonProperty("errcode")
    private int errcode;

    @JsonProperty("lat")
    private String lat;

    @JsonProperty("lon")
    private String lon;

    @JsonProperty("radius")
    private String radius;

    @JsonProperty("address")
    private String address;

    public int getErrcode() {
        return errcode;
    }

    public void setErrcode(int errcode) {
        this.errcode = errcode;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public String getRadius() {
        return radius;
    }

    public void setRadius(String radius) {
        this.radius = radius;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
