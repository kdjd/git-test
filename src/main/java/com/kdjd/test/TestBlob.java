package com.kdjd.test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.StringWriter;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestBlob {
    protected String Driver = "com.kingbase8.Driver";
    protected static String Url = "jdbc:kingbase8://192.168.0.157:54321/test";
    protected Connection connection = null;
    protected Statement statement = null;
    protected String source = "Welcome to Kingbase!";

    protected void Driver() throws ClassNotFoundException {
        Class.forName(Driver);
    }

    protected void connection(String url) throws SQLException,
            InterruptedException {
        connection = DriverManager.getConnection(url, "system", "123456");
        if (connection != null) {
            System.out.println("connection successful!");
        } else {
            System.out.println("connection fail!");
        }
    }

    protected void statement() throws SQLException {
        statement = connection.createStatement();
    }

    /* 创建表 */
    protected void table() throws SQLException {
        statement.executeUpdate("create table blob_table (col1 Blob, " +
                "col2 Blob, col3 Blob)");
    }

    /* 插入数据 */
    protected void insertBlob() throws SQLException {
        PreparedStatement pstmt = connection.prepareStatement(
                "insert into blob_table values (?,?,?)");
        InputStream read = new ByteArrayInputStream(source.getBytes());
        InputStream read1 = new ByteArrayInputStream(source.getBytes());
        InputStream read2 = new ByteArrayInputStream(source.getBytes());
        pstmt.setBlob(1, read);
        pstmt.setBlob(2, read1);
        pstmt.setBlob(3, read2);
        pstmt.executeUpdate();
        pstmt.close();
    }

    /* 查询数据 */
    protected void queryBlob() throws SQLException, IOException {
        String sql_select = "select * from blob_table";
        ResultSet resultSet = statement.executeQuery(sql_select);
        int count = 1;
        while (resultSet.next()) {
            System.out.println(" 第" + count + " 条记录");
            /* 获取 Blob 对象的内容 */
            String blob1 = new String(resultSet.getBytes(1));
            String blob2 = new String(resultSet.getBytes(2));
            String blob3 = new String(resultSet.getBytes(3));
            System.out.println("blob1:" + blob1);
            System.out.println("blob2:" + blob2);
            System.out.println("blob3:" + blob3);
            count++;
        }
        resultSet.close();
        count = 1;
        resultSet = statement.executeQuery(sql_select);
        while (resultSet.next()) {
            System.out.println(" 第" + count + " 条记录");
            for (int i = 0; i < 3; i++) {
                /* 获取 Blob 对象 */
                Blob blob = resultSet.getBlob(i + 1);
                /* 将此 blob 实例的值作为流 */
                InputStream input = blob.getBinaryStream();
                StringWriter sWriter = new StringWriter();
                int j = -1;
                while ((j = input.read()) != -1) {
                    sWriter.write(j);
                }
                String finalBlob = new String(sWriter.getBuffer());
                System.out.println(finalBlob);
            }
            count++;
        }
        resultSet.close();
    }

    protected void updateBlob() throws SQLException, IOException {
        String sql_select = "select * from blob_table for update";
        ResultSet resultSet = statement.executeQuery(sql_select);
        if (resultSet.next()) {
            Blob blob = resultSet.getBlob(1);
            /* 获取可用于写入此 blob 对象所代表的 BLOB 值的流 */
            OutputStream output = blob.setBinaryStream(blob.length()
                    + 1);
            String temp = "Welcome to Kingbase!";
            byte[] tempByte = temp.getBytes();
            output.write(tempByte);
            output.close();
            blob = resultSet.getBlob(2);
            temp = "Hello, Kingbase!";
            /* 将给定的字节数组从位置 (blob.length() + 1) 开始写入 Blob 对象 */
            blob.setBytes(blob.length() + 1, temp.getBytes());
            resultSet = statement.executeQuery(sql_select);
            if (resultSet.next()) {
                System.out.println(" 更新后的记录");
                System.out.println(new String(resultSet.getBytes(1)));
                System.out.println(new String(resultSet.getBytes(2)));
                System.out.println(new String(resultSet.getBytes(3)));
            }
        }
        resultSet.close();
    }

    public static void main(String[] args) throws ClassNotFoundException,
            SQLException, InterruptedException, IOException {
        TestBlob test = new TestBlob();
        test.Driver();
        test.connection(Url);
        test.statement();
        //test.table();
        test.insertBlob();
        test.queryBlob();
        //test.updateBlob();
        //test.close();
    }

    protected void close() throws SQLException {
        statement.executeUpdate("drop table blob_table");
        if (statement != null) {
            statement.close();
        }
        if (connection != null) {
            connection.close();
        }
    }
}
