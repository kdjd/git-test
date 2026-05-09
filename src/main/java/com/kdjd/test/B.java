package com.kdjd.test;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

public class B {

    public static void main(String[] args) throws IOException, NoSuchAlgorithmException, InvalidKeyException {
        String secretKey = "O8OeKj4RidGhHbmmmcCMlx0NkZRLKo4r";

        String location = "中国浙江省金华市义乌市福田街道S310";
        String platformUserId = "177916277e7b40c385de98f274c1881d";
        String idCard = "341221200103146837";

        long timestamp = new Date().getTime();
        System.out.println(timestamp);


        location = "浙江省金华市义乌市廿三里街道商城大道辅路";
        platformUserId = "89c4af7cb95b4d82ad2eb429a1329575";
        idCard = "33072519720304354X";
        timestamp = 1769690150091L;

        String data = "idCard=" + idCard
                + "&location=" + location
                + "&platformUserId=" + platformUserId
                + "&timestamp=" + timestamp
                + "&" + secretKey;

        System.out.println(data);
        System.out.println(secretKey);

        System.out.println(hmacSHA256Hex(data, secretKey));


    }


    public static String hmacSHA256Hex(String data, String key) {
        try {
            Mac mac = Mac.getInstance("HmacSHA256");
            SecretKeySpec secretKeySpec = new SecretKeySpec(
                    key.getBytes(StandardCharsets.UTF_8),
                    "HmacSHA256"
            );
            mac.init(secretKeySpec);
            byte[] bytes = mac.doFinal(data.getBytes(StandardCharsets.UTF_8));

            // 转换为十六进制
            return bytesToHex(bytes);
        } catch (NoSuchAlgorithmException | InvalidKeyException e) {
            throw new RuntimeException("HmacSHA256加密失败", e);
        }
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : bytes) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }


}
