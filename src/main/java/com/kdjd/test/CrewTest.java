package com.kdjd.test;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class CrewTest {

    public static void main(String[] args) throws IOException {

        String ignores = "";

        String[] split = ignores.split(":");
        List<String> ignoreList = Arrays.asList(split);

        //String url = "https://wiki.lineageos.org/devices/";
        //Document doc = Jsoup.connect(url).get();

        File input = new File("D:\\Document\\workspace\\test\\src\\main\\resources\\lineageOS.html");
        Document doc = Jsoup.parse(input, "UTF-8");

        // 选择所有设备厂商的部分
        Elements vendorSections = doc.getElementsByClass("name");

        for (Element section : vendorSections) {
            Elements devicenameE = section.getElementsByClass("devicename");
            Elements codenameE = section.getElementsByClass("codename");

            String deviceName = devicenameE.text();
            String codeName = codenameE.text().replace("codename:", "").trim();
            if (ignoreList.contains(codeName)) {
                continue;
            } else {
                try {
                    Thread.sleep(1000);
                } catch (Exception ignored) {
                }
            }

            String url = "https://wiki.lineageos.org/devices/" + codeName + "/";
            Document detail = Jsoup.connect(url).get();

            Element soc = detail.select("th:containsOwn(SoC)").first();

            Element next = null;
            if (soc != null) {
                next = soc.nextElementSibling();
            }
            if (next != null) {
                System.out.println(deviceName + "\t" + codeName + "\t" + next.text());
            }
        }
    }
}
