package com.kdjd.work;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.cert.X509Certificate;

public class HikTest {


    private final static HostnameVerifier DO_NOT_VERIFY = (hostname, session) -> true;

    public static void main(String[] args) {
        String url = "http://60.163.193.18:9080/ctbt-web/v1/crew/cld";
        String param = "fileName=2irfjzjodtujzqtv2ss6gapekiu5ec8e.jpg";
        String s = doPostReq(url, param);
        System.out.println(s);
    }

    /**
     * 发送post请求
     *
     * @param urlStr
     * @param param
     * @return
     */
    public static String doPostReq(String urlStr, String param) {
        String result = "";
        BufferedReader bufferedReader = null;
        InputStream inputStream = null;
        try {
            trustAllHosts();
            URL url = new URL(urlStr);
            HttpURLConnection conn = null;
            // 通过请求地址判断请求类型(http或者是https)
            if (url.getProtocol().equalsIgnoreCase("https")) {
                HttpsURLConnection https = (HttpsURLConnection) url.openConnection();
                https.setHostnameVerifier(DO_NOT_VERIFY);
                conn = https;
            } else {
                conn = (HttpURLConnection) url.openConnection();
            }
            conn.setRequestMethod("POST");//设置请求方式
            conn.setConnectTimeout(15000);//设置连接超时时间
            conn.setReadTimeout(60000);//设置读取远程超时时间
            conn.setDoInput(true);
            conn.setDoOutput(true);
            conn.setRequestProperty("Content-type", "application/json; charset=utf-8");
            conn.setRequestProperty("Accept",
                    "text/xml,text/javascript,text/html,application/json");
            OutputStream outputStream = conn.getOutputStream();//通过连接对象获取输出流
            outputStream.write(param.getBytes());//通过输出流对象将参数传输出去，它是通过字节数组写出去的
            System.out.println("respCode:" + conn.getResponseCode());
            if (conn.getResponseCode() == 200) {
                inputStream = conn.getInputStream();
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                byte[] buf = new byte[1024];
                int len = 0;
                while ((len = inputStream.read(buf)) != -1) {
                    baos.write(buf, 0, len);
                }
                baos.flush();
                result = baos.toString();
            }
            //如果响应码是307则重新发起请求
            if (307 == conn.getResponseCode()) {
                String redirectUrl = conn.getHeaderField("Location");
                if (redirectUrl != null && !redirectUrl.isEmpty()) {
                    urlStr = redirectUrl;
                    return doPostReq(urlStr, param);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != inputStream) {
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    private static void trustAllHosts() {
        TrustManager[] trustAllCerts = new TrustManager[]{new X509TrustManager() {
            public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                return new java.security.cert.X509Certificate[]{};
            }

            public void checkClientTrusted(X509Certificate[] chain, String authType) {
            }

            public void checkServerTrusted(X509Certificate[] chain, String authType) {
            }
        }};
        try {
            SSLContext sc = SSLContext.getInstance("TLS");
            sc.init(null, trustAllCerts, new java.security.SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}