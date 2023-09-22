package com.kdjd.test;

import org.apache.commons.lang3.StringUtils;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Base64;

public class Test05 {

    public static void main(String[] args) {

        //System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));

        String a = "330922100";
        System.out.println(a.substring(0, 6));

        System.out.println(System.currentTimeMillis());
        System.out.println(System.nanoTime());
        
        String url = "a/b/c/d.png";
        String minioUrl = getMinioUrl(url);
        System.out.println(minioUrl);
        String decodeUrl = decodeUrl(minioUrl);
        System.out.println(decodeUrl);


    }

    public static String decodeUrl(String url) {
        if (url.contains("/cc/com/upload/minio/imgFile")) {
            if (url.contains("&type")) {
                url = url.substring(url.lastIndexOf("url=") + 4, url.lastIndexOf("&type"));
            } else {
                url = url.substring(url.lastIndexOf("url=") + 4);
            }
        } else {
            if (url.contains("&type")) {
                url = url.substring(0, url.lastIndexOf("&type"));
            }
        }
        try {
            url = new String(Base64.getDecoder().decode(URLDecoder.decode(url, "UTF-8")));
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
        return url;
    }

    /**
     * （minio改造后）minio地址
     *
     * @param oldUrl
     * @return
     */
    public static String getMinioUrl(String oldUrl) {
        try {
            return new StringBuffer().append("/cc/com/upload/minio/imgFile")
                    .append("?url=")
                    .append(URLEncoder.encode(Base64.getEncoder().encodeToString(StringUtils.trimToEmpty(oldUrl).getBytes()), "UTF-8"))
                    .append("&type=")
                    .append(URLEncoder.encode((StringUtils.trimToEmpty(oldUrl.substring(oldUrl.lastIndexOf(".") + 1))), "UTF-8"))
                    .toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
