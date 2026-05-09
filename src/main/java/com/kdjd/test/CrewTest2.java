package com.kdjd.test;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CrewTest2 {

    public static void main(String[] args) throws IOException {

        String codes = "A6020:alioth:alphaplus:apollon:caihong:cancro:capri:caprip:casuarina:cebu:cherry:clark:davinci:diting:earth:erhai:espresso3g:espressowifi:f62:fajita:find7:fogos:foster:foster_tab:FP3:garnet:gauguin:ginkgo:guacamole:guam:guamp:haydn:hotdogb:ido:instantnoodle:joan:judyln:kane:kebab:kiev:larry:lemonade:lemonadep:liber:lisa:lmi:marble:mh2lm:Mi439:Mi8917:Mi8937:miatoll:mondrian:munch:nairo:nash:nicole:nio:nx:nx_tab:nx651j:nx659j:onclite:oneplus3:oscar:porg:porg_tab:pyxis:quill:quill_tab:r5:r8q:rosemary:rtwo:spyder:sweet:tomato:tucana:umts_spyder:vegetalte:vermeer:xpeng:Z00T:zl1";

        String[] codesList = codes.split(":");

        for (String codeName : codesList) {

            String url = "https://wiki.lineageos.org/devices/" + codeName + "/";

            Document detail = null;
            while (detail == null) {
                try {
                    detail = Jsoup.connect(url).get();
                } catch (Exception ignored) {
                }
                sleep();
            }

            Elements items = detail.select("div.variant-item"); // 选择所有符合条件的 div

            // 正则表达式匹配 location.href 后的单引号/双引号内容
            Pattern pattern = Pattern.compile("location\\.href\\s*=\\s*['\"]([^'\"]+)['\"]");

            for (Element item : items) {
                String onclick = item.attr("onclick"); // 获取 onclick 属性值
                if (!onclick.isEmpty()) {
                    Matcher matcher = pattern.matcher(onclick);
                    if (matcher.find()) {
                        String href = "https://wiki.lineageos.org" + matcher.group(1); // 提取括号内捕获的 URL

                        Document variant = null;
                        while (variant == null) {
                            try {
                                variant = Jsoup.connect(href).get();
                            } catch (Exception ignored) {
                            }
                            sleep();
                        }

                        Elements device = variant.getElementsByClass("post-title-main");
                        Element soc = variant.select("th:containsOwn(SoC)").first();

                        String deviceName = device.text();

                        Element next = null;
                        if (soc != null) {
                            next = soc.nextElementSibling();
                        }
                        if (next != null) {
                            System.out.println(deviceName + "\t" + codeName + "\t" + next.text());
                        }
                    }
                }

                sleep();
            }

            sleep();

        }
    }

    private static void sleep() {
        try {
            Thread.sleep(1000);
        } catch (Exception ignored) {
        }
    }
}
