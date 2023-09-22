package com.kdjd.test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileTest {

    public static void main(String[] args) {
        //try {
        //    String url = "http://cdn.itstra.cn/bkserver/dnCd/cdkj/xjjydjb/2022/12/27/0D6A9E458A63EFDA237EAD2BD127D9A7.pdf";
        //    InputStream inputStream = new URL(url).openStream();
        //    System.out.println(inputStream.toString());
        //} catch (Exception e) {
        //    throw new RuntimeException(e);
        //}

        //File temp;
        //try {
        //    temp = File.createTempFile("myTempFile", ".txt");
        //
        //    BufferedWriter bw = new BufferedWriter(new FileWriter(temp));
        //    bw.write("This is the temporary data written to temp file");
        //    bw.close();
        //
        //    System.out.println("Written to Temp file : " + temp.getAbsolutePath());
        //
        //
        //    temp.deleteOnExit();
        //} catch (IOException e) {
        //    e.printStackTrace();
        //}
        //System.out.println(new Date());

        //try {
        //    final Path path = Files.createTempFile("myTempFile", ".txt");
        //    System.out.println("Temp file : " + path);
        //
        //    byte[] buf = "some data".getBytes();
        //    Files.write(path, buf);
        //
        //    Files.deleteIfExists(path);
        //
        //} catch (IOException e) {
        //    throw new RuntimeException(e);
        //}
        //
        //System.out.println(new Date());

        try {
            String url = "C:\\Users\\kdjdl\\Desktop\\qwert.png";
            Path path = Paths.get(url);
            System.out.println(Files.probeContentType(path));
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }
}
