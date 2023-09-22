package com.kdjd.test;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class IPTest {

    public static void main(String[] args) throws UnknownHostException {
        String ip = "120.55.96.147";
        System.out.println(INETATON(ip));

        long ipL = 2016895123;
        System.out.println(INETNTOA(ipL));

    }


    public static long INETATON(String ipAddress) throws UnknownHostException {
        InetAddress address = InetAddress.getByName(ipAddress);
        byte[] bytes = address.getAddress();
        long result = 0;
        for (byte b : bytes) {
            result = result << 8 | (b & 0xFF);
        }
        return result;
    }

    public static String INETNTOA(long address) {
        return (address >> 24 & 0xFF) + "." +
                (address >> 16 & 0xFF) + "." +
                (address >> 8 & 0xFF) + "." +
                (address & 0xFF);
    }
}
