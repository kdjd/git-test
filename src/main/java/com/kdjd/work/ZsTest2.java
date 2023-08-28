package com.kdjd.work;

import net.coobird.thumbnailator.Thumbnails;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;

public class ZsTest2 {

    public static void main(String[] args) {
        String url = "https://zs.sifa365.cn/minio/bkserver/dnZhoushan/330902/archive/profile/uploadPath/upload/2022/03/22/2415e9eeb417fcc9b379247be97d8639.jpg";

        //try {
        //    ZsTest.imageToBase64(url);
        //} catch (IOException e) {
        //    throw new RuntimeException(e);
        //}

        URL u;
        try (ByteArrayOutputStream fos = new ByteArrayOutputStream()) {
            u = new URL(url);
            URLConnection conn = u.openConnection();
            InputStream in = conn.getInputStream();
            byte[] data = readInputStream(in);

            Thumbnails.of(new ByteArrayInputStream(data)).useExifOrientation(true).scale(1.0).toOutputStream(fos);

            System.out.println(new Date());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    private static byte[] readInputStream(InputStream ins) throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len;
        while ((len = ins.read(buffer)) != -1) {
            out.write(buffer, 0, len);
        }
        ins.close();
        return out.toByteArray();
    }
}

