package com.kdjd.test;

import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Test {

    public static void main(String[] args) throws NoSuchAlgorithmException {
        //String str = "儿媳";
        //String md5 = generateMD5(str);
        //System.out.println(md5);
        //str = "妻子";
        //md5 = generateMD5(str);
        //System.out.println(md5);
        //str = "朋友";
        //md5 = generateMD5(str);
        //System.out.println(md5);

        HashFunction md5 = Hashing.hmacMd5("".getBytes(StandardCharsets.UTF_8));

        System.out.println(md5);

    }

    public static String generateMD5(String input) throws NoSuchAlgorithmException {
        //获取MD5机密实例
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        byte[] byteArr = md5.digest(input.getBytes(StandardCharsets.UTF_8));
        return byte2hex(byteArr);
    }

    public static String byte2hex(byte[] b) {
        StringBuilder hs = new StringBuilder();
        String stmp;
        for (byte value : b) {
            //为了保证二进制机器数不变，这里需要& 0XFF
            stmp = (Integer.toHexString(value & 0XFF));
            //如果只有一位，需要在前面补上0凑足两位
            if (stmp.length() == 1) {
                hs.append("0").append(stmp);
            } else {
                hs.append(stmp);
            }
        }
        return hs.toString();
    }

}
