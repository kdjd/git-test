package com.kdjd.test;

import java.io.*;
import java.util.zip.*;

public class ZipInMemoryExample {
    public static void main(String[] args) throws IOException {
        // 创建内存流
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        try (ZipOutputStream zos = new ZipOutputStream(baos)) {
            // 添加文本文件到ZIP
            addTextFileToZip(zos, "file1.txt", "这是文件1的内容");
            addTextFileToZip(zos, "file2.txt", "这是文件2的内容");

            // 添加二进制文件到ZIP（模拟）
            addBinaryFileToZip(zos, "image.png", new byte[]{0x1, 0x2, 0x3, 0x4});
        }

        // 获取ZIP文件的字节数组
        byte[] zipBytes = baos.toByteArray();

        // 将字节数组转换为输入流
        InputStream zipStream = new ByteArrayInputStream(zipBytes);

        // 使用zipStream进行后续处理
        processZipStream(zipStream);
    }

    private static void addTextFileToZip(ZipOutputStream zos,
                                         String filename,
                                         String content) throws IOException {
        ZipEntry entry = new ZipEntry(filename);
        zos.putNextEntry(entry);
        zos.write(content.getBytes());
        zos.closeEntry();
    }

    private static void addBinaryFileToZip(ZipOutputStream zos,
                                           String filename,
                                           byte[] data) throws IOException {
        ZipEntry entry = new ZipEntry(filename);
        zos.putNextEntry(entry);
        zos.write(data);
        zos.closeEntry();
    }

    private static void processZipStream(InputStream zipStream) throws IOException {
        // 使用ZipInputStream读取压缩文件内容
        try (ZipInputStream zis = new ZipInputStream(zipStream)) {
            ZipEntry entry;
            while ((entry = zis.getNextEntry()) != null) {
                System.out.println("文件: " + entry.getName());
                // 读取文件内容
                byte[] buffer = new byte[1024];
                int len;
                while ((len = zis.read(buffer)) > 0) {
                    // 处理文件内容
                    System.out.write(buffer, 0, len);
                }
                System.out.println();
                zis.closeEntry();
            }
        }
    }
}
