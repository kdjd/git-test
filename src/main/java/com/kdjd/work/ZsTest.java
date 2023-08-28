package com.kdjd.work;

import net.coobird.thumbnailator.Thumbnails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.bind.DatatypeConverter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;

public class ZsTest {

    public static final Logger log = LoggerFactory.getLogger(ZsTest.class);

    public static void main(String[] args) {
        String fileDir = "D:\\home\\mini.txt";
        String buffer = "INSERT INTO `h_zs_person` ( pk_id, " +
                //"a_pk, " +
                "person_lib_id, `name`, image_data, update_flag ) VALUES \n";
        try {
            File file = new File(fileDir);
            InputStreamReader reader = new InputStreamReader(Files.newInputStream(file.toPath()));
            BufferedReader br = new BufferedReader(reader);
            String line;
            int count = 0;

            File out;
            FileWriter fw;
            BufferedWriter bw = null;

            while ((line = br.readLine()) != null) {
                if (count % 50 == 0) {
                    String fileName = "D:\\home\\mini-" + (count / 50 + 1) + ".sql";
                    out = new File(fileName);
                    fw = new FileWriter(out.getAbsoluteFile());
                    bw = new BufferedWriter(fw);
                    bw.write(buffer);
                }
                count++;
                if (line.length() == 0) {
                    continue;
                }
                String[] split = line.replace("'", "").split(",");
                int pk_id = count;
                int a_pk = Integer.parseInt(split[0]);
                String person_lib_id = "23040710423984102";
                String name = split[1];
                //String image_date = "";
                String image_date = imageToBase64("https://zs.sifa365.cn/minio/bkserver" + split[2]);
                int update_flag = 1;

                String val = "(" + pk_id +
                        //"," + a_pk +
                        ",'" + person_lib_id + "','" + name + "','" + image_date + "'," + update_flag + "),\n";
                if ((count) % 50 == 0) {
                    val = "(" + pk_id +
                            //"," + a_pk +
                            ",'" + person_lib_id + "','" + name + "','" + image_date + "'," + update_flag + ");\n";
                }
                bw.write(val);
                System.out.println(count);
                if ((count) % 50 == 0) {
                    bw.close();
                }
            }
            if (bw != null) {
                bw.close();
            }
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }

    }

    public static String imageToBase64(String s) throws IOException {
        int size;
        URL u = new URL(s);
        URLConnection conn = u.openConnection();
        size = conn.getContentLength();

        if (size < 0) {
            log.info("无法获取文件大小。");
        } else if (size > 1999999) {
            InputStream in = conn.getInputStream();
            byte[] data = readInputStream(in);
            double d = (double) 999999 / size;
            System.out.println(d);
            System.out.println(size);
            byte[] bytes = compressPicForScale(data, String.valueOf(size), d);


            //File f = new File(s.substring(s.lastIndexOf("/") + 1));
            //FileOutputStream out = new FileOutputStream(f);
            //out.write(bytes);
            //out.close();
            return DatatypeConverter.printBase64Binary(bytes);
        } else {
            return Base64Utils.ImageToBase64ByOnline(s);
        }
        return null;
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

    public static byte[] compressPicForScale(
            byte[] imageBytes, String imageId, Double f) {
        long srcSize = imageBytes.length;
        try {
            ByteArrayInputStream inputStream = new ByteArrayInputStream(imageBytes);
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream(imageBytes.length);
            Thumbnails.of(inputStream).scale(f).outputQuality(1.0D).toOutputStream(outputStream);
            imageBytes = outputStream.toByteArray();
            log.info(
                    "【图片压缩】imageId={} | 图片原大小={}kb | 压缩后大小={}kb",
                    imageId,
                    srcSize / 1024,
                    imageBytes.length / 1024);
        } catch (Exception e) {
            log.error("【图片压缩】msg=图片压缩失败!", e);
        }
        return imageBytes;
    }
}
