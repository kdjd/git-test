package com.kdjd.test;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map; /**
 * 档案目录页面对应pageKey
 *
 * @author yawen.zhu
 *
 */
public enum EnumArchiveCatalogPageKey {

    // 标准版 天津版 湖北版 新疆版 河北版
    /**
     * 执行档案目录
     */
    ZXDA_ML("1", "ZXDA_ML", "卷内目录（执行档案目录）"),

    /**
     * 工作档案目录
     */
    GZDA_ML("2", "GZDA_ML", "卷内目录（工作档案目录）"),

    /**
     * 调查档案目录
     */
    DCDA_ML("3", "DCDA_ML", "卷内目录（调查档案目录）"),

    /**
     * 派驻干警签署档案目录
     */
    PZGJDA_ML("4", "PZGJDA_ML", "卷内目录（派驻干警档案目录）"),

    /**
     * 必须文书目录
     */
    BXWS_ML("5", "BXWS_ML", "卷内目录（必须文书目录）"),

    // 浙江版
    /**
     * 整卷目录
     */
    ZJ_ML("6", "ZJ_ML", "整卷目录"),

    /**
     * 正卷目录
     */
    ZJ2_ML("7", "ZJ2_ML", "正卷目录"),

    /**
     * 副卷目录
     */
    FJ_ML("8", "FJ_ML", "副卷目录"),

    /**
     * 副卷目录
     */
    DCPGJ_ML("9", "DCPGJ_ML", "调查评估卷目录");

    /**
     * 获取页面标识
     *
     * @param archivePk 档案类别PK（表T_PRINT_ARCHIVE的PK_ID）
     * @return
     */
    public static String getPageKey(String archivePk) {
        String name = "";
        switch (archivePk) {
            case "1":
                name = EnumArchiveCatalogPageKey.ZXDA_ML.getPageKey();
                break;
            case "2":
                name = EnumArchiveCatalogPageKey.GZDA_ML.getPageKey();
                break;
            case "3":
                name = EnumArchiveCatalogPageKey.DCDA_ML.getPageKey();
                break;
            case "4":
                name = EnumArchiveCatalogPageKey.PZGJDA_ML.getPageKey();
                break;
            case "5":
                name = EnumArchiveCatalogPageKey.BXWS_ML.getPageKey();
                break;
            case "6":
                name = EnumArchiveCatalogPageKey.ZXDA_ML.getPageKey();
                break;
            case "7":
                name = EnumArchiveCatalogPageKey.GZDA_ML.getPageKey();
                break;
            case "8":
            case "63":
            case "64":
            case "65":
                name = EnumArchiveCatalogPageKey.DCDA_ML.getPageKey();
                break;
            case "9":
                name = EnumArchiveCatalogPageKey.PZGJDA_ML.getPageKey();
                break;
            case "10":
                name = EnumArchiveCatalogPageKey.BXWS_ML.getPageKey();
                break;
            case "11":
                name = EnumArchiveCatalogPageKey.ZXDA_ML.getPageKey();
                break;
            case "12":
                name = EnumArchiveCatalogPageKey.GZDA_ML.getPageKey();
                break;
            case "13":
                name = EnumArchiveCatalogPageKey.DCDA_ML.getPageKey();
                break;
            case "14":
                name = EnumArchiveCatalogPageKey.PZGJDA_ML.getPageKey();
                break;
            case "15":
                name = EnumArchiveCatalogPageKey.BXWS_ML.getPageKey();
                break;
            case "16":
                name = EnumArchiveCatalogPageKey.ZXDA_ML.getPageKey();
                break;
            case "17":
                name = EnumArchiveCatalogPageKey.GZDA_ML.getPageKey();
                break;
            case "18":
                name = EnumArchiveCatalogPageKey.DCDA_ML.getPageKey();
                break;
            case "19":
                name = EnumArchiveCatalogPageKey.ZXDA_ML.getPageKey();
                break;
            case "20":
                name = EnumArchiveCatalogPageKey.GZDA_ML.getPageKey();
                break;
            case "21":
                name = EnumArchiveCatalogPageKey.DCDA_ML.getPageKey();
                break;
            case "22":
                name = EnumArchiveCatalogPageKey.ZXDA_ML.getPageKey();
                break;
            case "23":
                name = EnumArchiveCatalogPageKey.GZDA_ML.getPageKey();
                break;
            case "24":
                name = EnumArchiveCatalogPageKey.DCDA_ML.getPageKey();
                break;
            case "25":
                name = EnumArchiveCatalogPageKey.BXWS_ML.getPageKey();
                break;
            case "26":
                name = EnumArchiveCatalogPageKey.ZXDA_ML.getPageKey();
                break;
            case "27":
                name = EnumArchiveCatalogPageKey.GZDA_ML.getPageKey();
                break;
            case "28":
                name = EnumArchiveCatalogPageKey.DCDA_ML.getPageKey();
                break;
            case "29":
                name = EnumArchiveCatalogPageKey.BXWS_ML.getPageKey();
                break;
            case "30":
                name = EnumArchiveCatalogPageKey.ZXDA_ML.getPageKey();
                break;
            case "31":
                name = EnumArchiveCatalogPageKey.GZDA_ML.getPageKey();
                break;
            case "32":
                name = EnumArchiveCatalogPageKey.DCDA_ML.getPageKey();
                break;
            case "33":
                name = EnumArchiveCatalogPageKey.ZXDA_ML.getPageKey();
                break;
            case "34":
                name = EnumArchiveCatalogPageKey.GZDA_ML.getPageKey();
                break;
            case "35":
                name = EnumArchiveCatalogPageKey.DCDA_ML.getPageKey();
                break;
            case "36":
                name = EnumArchiveCatalogPageKey.ZXDA_ML.getPageKey();
                break;
            case "37":
                name = EnumArchiveCatalogPageKey.GZDA_ML.getPageKey();
                break;
            case "38":
                name = EnumArchiveCatalogPageKey.DCDA_ML.getPageKey();
                break;
            case "39":
                name = EnumArchiveCatalogPageKey.BXWS_ML.getPageKey();
                break;
            // 河北版执行档案目录
            case "40":
            case "43":
            case "46":
                name = EnumArchiveCatalogPageKey.ZXDA_ML.getPageKey();
                break;
            // 河北版工作档案目录
            case "41":
            case "44":
            case "47":
            case "72":
            case "73":
            case "74":
            case "75":
            case "76":
            case "77":
                name = EnumArchiveCatalogPageKey.GZDA_ML.getPageKey();
                break;
            // 河北版调查评估目录
            case "42":
            case "45":
            case "48":
            case "66":
            case "67":
            case "68":
                name = EnumArchiveCatalogPageKey.DCDA_ML.getPageKey();
                break;
            case "50":
            case "55":
            case "59":
                name = EnumArchiveCatalogPageKey.ZJ_ML.getPageKey();
                break;
            case "51":
            case "56":
            case "60":
                name = EnumArchiveCatalogPageKey.ZJ2_ML.getPageKey();
                break;
            case "52":
            case "57":
            case "61":
                name = EnumArchiveCatalogPageKey.FJ_ML.getPageKey();
                break;
            case "53":
            case "58":
            case "62":
                name = EnumArchiveCatalogPageKey.DCPGJ_ML.getPageKey();
            default:
                break;
        }
        return name;
    }

    /**
     * 判断是否是档案目录
     *
     * @param pageKey
     * @return
     */
    public static boolean catalogPage(String pageKey) {
        boolean flag = false;
        pageKey = StringUtils.isNotBlank(StringUtils.trimToEmpty(pageKey)) ? StringUtils.trimToEmpty(pageKey) : "";
        switch (pageKey) {
            case "ZXDA_ML":
                flag = true;
                break;
            case "GZDA_ML":
                flag = true;
                break;
            case "DCDA_ML":
                flag = true;
                break;
            case "PZGJDA_ML":
                flag = true;
                break;
            case "BXWS_ML":
                flag = true;
                break;
            case "CXHXJZML":
                flag = true;
                break;
            case "CXJSJZML":
                flag = true;
                break;
            case "SJZXJZML":
                flag = true;
                break;
            case "ZJ_ML":
            case "ZJ2_ML":
            case "FJ_ML":
            case "DCPGJ_ML":
                flag = true;
                break;
            default:
                break;
        }
        return flag;
    }


    /**
     * 获取页面名称
     *
     * @param archivePk 档案类别PK（表T_PRINT_ARCHIVE的PK_ID）
     * @return
     */
    public static String getPageName(String archivePk) {
        String name = "";
        switch (archivePk) {
            case "1":
                name = EnumArchiveCatalogPageKey.ZXDA_ML.getPageName();
                break;
            case "2":
                name = EnumArchiveCatalogPageKey.GZDA_ML.getPageName();
                break;
            case "3":
                name = EnumArchiveCatalogPageKey.DCDA_ML.getPageName();
                break;
            case "4":
                name = EnumArchiveCatalogPageKey.PZGJDA_ML.getPageName();
                break;
            case "5":
                name = EnumArchiveCatalogPageKey.BXWS_ML.getPageName();
                break;
            case "6":
                name = EnumArchiveCatalogPageKey.ZXDA_ML.getPageName();
                break;
            case "7":
                name = EnumArchiveCatalogPageKey.GZDA_ML.getPageName();
                break;
            case "8":
            case "63":
            case "64":
            case "65":
                name = EnumArchiveCatalogPageKey.DCDA_ML.getPageName();
                break;
            case "9":
                name = EnumArchiveCatalogPageKey.PZGJDA_ML.getPageName();
                break;
            case "10":
                name = EnumArchiveCatalogPageKey.BXWS_ML.getPageName();
                break;
            case "11":
                name = EnumArchiveCatalogPageKey.ZXDA_ML.getPageName();
                break;
            case "12":
                name = EnumArchiveCatalogPageKey.GZDA_ML.getPageName();
                break;
            case "13":
                name = EnumArchiveCatalogPageKey.DCDA_ML.getPageName();
                break;
            case "14":
                name = EnumArchiveCatalogPageKey.PZGJDA_ML.getPageName();
                break;
            case "15":
                name = EnumArchiveCatalogPageKey.BXWS_ML.getPageName();
                break;
            case "16":
                name = EnumArchiveCatalogPageKey.ZXDA_ML.getPageName();
                break;
            case "17":
                name = EnumArchiveCatalogPageKey.GZDA_ML.getPageName();
                break;
            case "18":
                name = EnumArchiveCatalogPageKey.DCDA_ML.getPageName();
                break;
            case "19":
                name = EnumArchiveCatalogPageKey.ZXDA_ML.getPageName();
                break;
            case "20":
                name = EnumArchiveCatalogPageKey.GZDA_ML.getPageName();
                break;
            case "21":
                name = EnumArchiveCatalogPageKey.DCDA_ML.getPageName();
                break;
            case "22":
                name = EnumArchiveCatalogPageKey.ZXDA_ML.getPageName();
                break;
            case "23":
                name = EnumArchiveCatalogPageKey.GZDA_ML.getPageName();
                break;
            case "24":
                name = EnumArchiveCatalogPageKey.DCDA_ML.getPageName();
                break;
            case "25":
                name = EnumArchiveCatalogPageKey.BXWS_ML.getPageName();
                break;
            case "26":
                name = EnumArchiveCatalogPageKey.ZXDA_ML.getPageName();
                break;
            case "27":
                name = EnumArchiveCatalogPageKey.GZDA_ML.getPageName();
                break;
            case "28":
                name = EnumArchiveCatalogPageKey.DCDA_ML.getPageName();
                break;
            case "29":
                name = EnumArchiveCatalogPageKey.BXWS_ML.getPageName();
                break;
            case "30":
                name = EnumArchiveCatalogPageKey.ZXDA_ML.getPageName();
                break;
            case "31":
                name = EnumArchiveCatalogPageKey.GZDA_ML.getPageName();
                break;
            case "32":
                name = EnumArchiveCatalogPageKey.DCDA_ML.getPageName();
                break;
            case "33":
                name = EnumArchiveCatalogPageKey.ZXDA_ML.getPageName();
                break;
            case "34":
                name = EnumArchiveCatalogPageKey.GZDA_ML.getPageName();
                break;
            case "35":
                name = EnumArchiveCatalogPageKey.DCDA_ML.getPageName();
                break;
            case "36":
                name = EnumArchiveCatalogPageKey.ZXDA_ML.getPageName();
                break;
            case "37":
                name = EnumArchiveCatalogPageKey.GZDA_ML.getPageName();
                break;
            case "38":
                name = EnumArchiveCatalogPageKey.DCDA_ML.getPageName();
                break;
            case "39":
                name = EnumArchiveCatalogPageKey.BXWS_ML.getPageName();
                break;
            // 河北版执行档案目录
            case "40":
            case "43":
            case "46":
                name = EnumArchiveCatalogPageKey.ZXDA_ML.getPageName();
                break;
            // 河北版工作档案目录
            case "41":
            case "44":
            case "47":
            case "72":
            case "73":
            case "74":
            case "75":
            case "76":
            case "77":
                name = EnumArchiveCatalogPageKey.GZDA_ML.getPageName();
                break;
            // 河北版调查评估目录
            case "42":
            case "45":
            case "48":
            case "66":
            case "67":
            case "68":
                name = EnumArchiveCatalogPageKey.DCDA_ML.getPageName();
                break;
            case "50":
            case "55":
            case "59":
                name = EnumArchiveCatalogPageKey.ZJ_ML.getPageName();
                break;
            case "51":
            case "56":
            case "60":
                name = EnumArchiveCatalogPageKey.ZJ2_ML.getPageName();
                break;
            case "52":
            case "57":
            case "61":
                name = EnumArchiveCatalogPageKey.FJ_ML.getPageName();
                break;
            case "53":
            case "58":
            case "62":
                name = EnumArchiveCatalogPageKey.DCPGJ_ML.getPageName();
            default:
                break;
        }
        return name;
    }


    private EnumArchiveCatalogPageKey(String value, String pageKey, String pageName) {
        this.value = value;
        this.pageKey = pageKey;
        this.pageName = pageName;
    }

    private static Map<String, EnumArchiveCatalogPageKey> lookup = new HashMap<>();

    static {
        lookup.put("1", EnumArchiveCatalogPageKey.ZXDA_ML);
        lookup.put("2", EnumArchiveCatalogPageKey.GZDA_ML);
        lookup.put("3", EnumArchiveCatalogPageKey.DCDA_ML);
        lookup.put("5", EnumArchiveCatalogPageKey.BXWS_ML);
        lookup.put("6", EnumArchiveCatalogPageKey.ZXDA_ML);
        lookup.put("7", EnumArchiveCatalogPageKey.GZDA_ML);
        lookup.put("8", EnumArchiveCatalogPageKey.DCDA_ML);
        lookup.put("10", EnumArchiveCatalogPageKey.BXWS_ML);
        lookup.put("11", EnumArchiveCatalogPageKey.ZXDA_ML);
        lookup.put("12", EnumArchiveCatalogPageKey.GZDA_ML);
        lookup.put("13", EnumArchiveCatalogPageKey.DCDA_ML);
        lookup.put("15", EnumArchiveCatalogPageKey.BXWS_ML);
        lookup.put("16", EnumArchiveCatalogPageKey.ZXDA_ML);
        lookup.put("17", EnumArchiveCatalogPageKey.GZDA_ML);
        lookup.put("18", EnumArchiveCatalogPageKey.DCDA_ML);
        lookup.put("19", EnumArchiveCatalogPageKey.ZXDA_ML);
        lookup.put("20", EnumArchiveCatalogPageKey.GZDA_ML);
        lookup.put("21", EnumArchiveCatalogPageKey.DCDA_ML);
        lookup.put("22", EnumArchiveCatalogPageKey.ZXDA_ML);
        lookup.put("23", EnumArchiveCatalogPageKey.GZDA_ML);
        lookup.put("24", EnumArchiveCatalogPageKey.DCDA_ML);
        lookup.put("25", EnumArchiveCatalogPageKey.BXWS_ML);
        lookup.put("30", EnumArchiveCatalogPageKey.ZXDA_ML);
        lookup.put("31", EnumArchiveCatalogPageKey.GZDA_ML);
        lookup.put("32", EnumArchiveCatalogPageKey.DCDA_ML);
        lookup.put("33", EnumArchiveCatalogPageKey.ZXDA_ML);
        lookup.put("34", EnumArchiveCatalogPageKey.GZDA_ML);
        lookup.put("35", EnumArchiveCatalogPageKey.DCDA_ML);
        lookup.put("36", EnumArchiveCatalogPageKey.ZXDA_ML);
        lookup.put("37", EnumArchiveCatalogPageKey.GZDA_ML);
        lookup.put("38", EnumArchiveCatalogPageKey.DCDA_ML);
        lookup.put("40", EnumArchiveCatalogPageKey.ZXDA_ML);
        lookup.put("41", EnumArchiveCatalogPageKey.GZDA_ML);
        lookup.put("42", EnumArchiveCatalogPageKey.DCDA_ML);
        lookup.put("43", EnumArchiveCatalogPageKey.ZXDA_ML);
        lookup.put("44", EnumArchiveCatalogPageKey.GZDA_ML);
        lookup.put("45", EnumArchiveCatalogPageKey.DCDA_ML);
        lookup.put("46", EnumArchiveCatalogPageKey.ZXDA_ML);
        lookup.put("47", EnumArchiveCatalogPageKey.GZDA_ML);
        lookup.put("48", EnumArchiveCatalogPageKey.DCDA_ML);
        lookup.put("49", EnumArchiveCatalogPageKey.BXWS_ML);
        lookup.put("50", EnumArchiveCatalogPageKey.ZJ_ML);
        lookup.put("51", EnumArchiveCatalogPageKey.ZJ2_ML);
        lookup.put("52", EnumArchiveCatalogPageKey.FJ_ML);
        lookup.put("53", EnumArchiveCatalogPageKey.DCPGJ_ML);
        lookup.put("54", EnumArchiveCatalogPageKey.BXWS_ML);
        lookup.put("55", EnumArchiveCatalogPageKey.ZJ_ML);
        lookup.put("56", EnumArchiveCatalogPageKey.ZJ2_ML);
        lookup.put("57", EnumArchiveCatalogPageKey.FJ_ML);
        lookup.put("58", EnumArchiveCatalogPageKey.DCPGJ_ML);
        lookup.put("59", EnumArchiveCatalogPageKey.ZJ_ML);
        lookup.put("60", EnumArchiveCatalogPageKey.ZJ2_ML);
        lookup.put("61", EnumArchiveCatalogPageKey.FJ_ML);
        lookup.put("62", EnumArchiveCatalogPageKey.DCPGJ_ML);
        lookup.put("63", EnumArchiveCatalogPageKey.DCDA_ML);
        lookup.put("64", EnumArchiveCatalogPageKey.DCDA_ML);
        lookup.put("65", EnumArchiveCatalogPageKey.DCDA_ML);
        lookup.put("66", EnumArchiveCatalogPageKey.DCDA_ML);
        lookup.put("67", EnumArchiveCatalogPageKey.DCDA_ML);
        lookup.put("68", EnumArchiveCatalogPageKey.DCDA_ML);
        lookup.put("69", EnumArchiveCatalogPageKey.DCPGJ_ML);
        lookup.put("70", EnumArchiveCatalogPageKey.DCPGJ_ML);
        lookup.put("71", EnumArchiveCatalogPageKey.DCPGJ_ML);
        lookup.put("72", EnumArchiveCatalogPageKey.GZDA_ML);
        lookup.put("73", EnumArchiveCatalogPageKey.GZDA_ML);
        lookup.put("74", EnumArchiveCatalogPageKey.GZDA_ML);
        lookup.put("75", EnumArchiveCatalogPageKey.GZDA_ML);
        lookup.put("76", EnumArchiveCatalogPageKey.GZDA_ML);
        lookup.put("77", EnumArchiveCatalogPageKey.GZDA_ML);
    }


    private String value;
    private String pageKey;
    private String pageName;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getPageKey() {
        return pageKey;
    }

    public void setPageKey(String pageKey) {
        this.pageKey = pageKey;
    }

    public String getPageName() {
        return pageName;
    }

    public void setPageName(String pageName) {
        this.pageName = pageName;
    }

}
