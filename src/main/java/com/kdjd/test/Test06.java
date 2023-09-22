package com.kdjd.test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class Test06 {
    protected String Driver = "com.kingbase8.Driver";
    protected static String Url = "jdbc:kingbase8://192.168.0.157:54321/bk_cd";
    protected Connection connection = null;
    protected Statement statement = null;
    protected String source = "Welcome to Kingbase!123123 = " + new Date();

    protected void Driver() throws ClassNotFoundException {
        Class.forName(Driver);
    }

    protected void connection(String url) throws SQLException {
        connection = DriverManager.getConnection(url, "system", "123456");
        if (connection != null) {
            System.out.println("connection sucessful!");
        } else {
            System.out.println("connection fail!");
        }
    }

    protected void statement() throws SQLException {
        statement = connection.createStatement();
    }

    /* 创建表 */
    protected void table() throws SQLException {
        statement.executeUpdate("create table blob_table (id integer, col1 Blob)");
    }

    /* 插入数据 */
    protected void insertBlob() throws SQLException {
        PreparedStatement pstmt = connection.prepareStatement(
                "insert into bk.t_face_feature (person_pk, feature) values ( ? , ? )");
        InputStream read = new ByteArrayInputStream(source.getBytes());
        pstmt.setInt(1, 1);
        pstmt.setBlob(2, read);
        pstmt.executeUpdate();
        pstmt.close();
    }

    /* 查询数据 */
    protected void queryBlob() throws SQLException, IOException {
        String sql_select = "select pk_id,person_pk,feature from bk.t_face_feature";
        ResultSet resultSet = statement.executeQuery(sql_select);
        int count = 1;
        while (resultSet.next()) {
            System.out.println(" 第" + count + " 条记录");
            /* 获取 Blob 对象的内容 */
            int id = resultSet.getInt(1);
            int personPk = resultSet.getInt(2);
            byte[] bytes = resultSet.getBytes(3);
            String blob2 = null;
            if (bytes != null) {
                blob2 = new String(bytes);
            }
            System.out.println("id : " + id);
            System.out.println("personPk : " + personPk);
            System.out.println("blob : " + blob2);
            count++;
        }
        resultSet.close();
    }

    protected void updateBlob() throws SQLException, IOException {
        String sql_select = "select * from blob_table where id = 1 for update ";
        ResultSet resultSet = statement.executeQuery(sql_select);
        if (resultSet.next()) {
            Blob blob = resultSet.getBlob(2);
            ///* 获取可用于写入此 blob 对象所代表的 BLOB 值的流 */
            //OutputStream output = blob.setBinaryStream(blob.length()
            //        + 1);
            //String temp = "Welcome to Kingbase!";
            //byte[] tempByte = temp.getBytes();
            //output.write(tempByte);
            //output.close();
            blob = resultSet.getBlob(2);
            String temp = "Hello, Kingbase! = " + new Date();
            /* 将给定的字节数组从位置 (blob.length() + 1) 开始写入 Blob 对象 */
            blob.setBytes(blob.length() + 1, temp.getBytes());
            //resultSet = statement.executeQuery(sql_select);
            //if (resultSet.next()) {
            //    System.out.println(" 更新后的记录");
            //    System.out.println(new String(resultSet.getBytes(1)));
            //    System.out.println(new String(resultSet.getBytes(2)));
            //    System.out.println(new String(resultSet.getBytes(3)));
            //}
        }
        resultSet.close();
    }

    public static void main(String[] args) throws ClassNotFoundException,
            SQLException, InterruptedException, IOException {
        Test06 test = new Test06();
        test.Driver();
        test.connection(Url);
        test.statement();
        //test.table();
        test.insertBlob();
        test.queryBlob();
        //test.updateBlob();
        //test.queryBlob();

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
