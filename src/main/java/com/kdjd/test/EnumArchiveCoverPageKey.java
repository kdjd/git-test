package com.kdjd.test;

import org.apache.commons.lang3.StringUtils; /**
 * 档案封面页面对应pageKey
 * @author yawen.zhu
 *
 */
public enum EnumArchiveCoverPageKey {

    // 标准版 河北版
    ZXDA_FM("1","ZXDA_FM", "执行档案封面"),
    GZDA_FM("2","GZDA_FM", "工作档案封面"),
    DCDA_FM("3","DCDA_FM", "调查档案封面"),
    PZGJDA_FM("4","PZGJDA_FM", "派驻干警签署档案封面"),

    // 天津版
    ZXDA_FM_TJ("6","ZXDA_FM_TJ", "执行档案封面"),
    GZDA_FM_TJ("7","GZDA_FM_TJ", "工作档案封面"),
    DCDA_FM_TJ("8","DCDA_FM_TJ", "调查档案封面"),

    // 新疆版
    ZXDA_FM_XJ("22","ZXDA_FM_XJ","执行档案封面"),
    GZDA_FM_XJ("23","GZDA_FM_XJ","工作档案封面"),
    DCDA_FM_XJ("24","DCDA_FM_XJ","调查档案封面"),

    // 湖北版
    ZXDA_FM_HUB("11","ZXDA_FM_HUB", "执行档案封面"),
    GZDA_FM_HUB("12","GZDA_FM_HUB", "工作档案封面"),
    DCDA_FM_HUB("13","DCDA_FM_HUB", "调查档案封面"),

    // 浙江版
    ZJ_FM("14","ZJ_FM", "整卷封面"),
    ZJ2_FM("15","ZJ2_FM", "正卷封面"),
    FJ_FM("16","FJ_FM", "副卷封面"),
    DCPGJ_FM("17","DCPGJ_FM", "调查评估卷封面"),
    ;

    /**
     * 判断是否是档案封面
     * @param pageKey
     * @return
     */
    public static boolean coverPage(String pageKey) {
        boolean flag = false;
        pageKey = StringUtils.isNotBlank(StringUtils.trimToEmpty(pageKey)) ? StringUtils.trimToEmpty(pageKey) : "";
        switch (pageKey) {
            case "ZXDA_FM":
            case "GZDA_FM":
            case "DCDA_FM":
            case "PZGJDA_FM":
            case "ZXDA_FM_TJ":
            case "GZDA_FM_TJ":
            case "DCDA_FM_TJ":
            case "ZXDA_FM_XJ":
            case "GZDA_FM_XJ":
            case "DCDA_FM_XJ":
            case "CXHXJZFM":
            case "CXJSJZFM":
            case "SJZXJZFM":
            case "ZXDA_FM_HUB":
            case "GZDA_FM_HUB":
            case "DCDA_FM_HUB":
            case "ZJ_FM":
            case "ZJ2_FM":
            case "FJ_FM":
            case "DCPGJ_FM":
                flag = true;
                break;
            default:
                break;
        }
        return flag;
    }

    /**
     * 获取页面标识
     * @param archivePk  档案类别PK（表T_PRINT_ARCHIVE的PK_ID）
     * @return
     */
    public static String getPageKey(String archivePk){
        String name = "";
        switch (archivePk) {
            case "1":
                name = EnumArchiveCoverPageKey.ZXDA_FM.getPageKey();
                break;
            case "2":
                name = EnumArchiveCoverPageKey.GZDA_FM.getPageKey();
                break;
            case "3":
                name = EnumArchiveCoverPageKey.DCDA_FM.getPageKey();
                break;
            case "4":
                name = EnumArchiveCoverPageKey.PZGJDA_FM.getPageKey();
                break;
            case "6":
                name = EnumArchiveCoverPageKey.ZXDA_FM_TJ.getPageKey();
                break;
            case "7":
                name = EnumArchiveCoverPageKey.GZDA_FM_TJ.getPageKey();
                break;
            case "8":
                name = EnumArchiveCoverPageKey.DCDA_FM_TJ.getPageKey();
                break;
            case "11":
                name = EnumArchiveCoverPageKey.ZXDA_FM_HUB.getPageKey();
                break;
            case "12":
                name = EnumArchiveCoverPageKey.GZDA_FM_HUB.getPageKey();
                break;
            case "13":
                name = EnumArchiveCoverPageKey.DCDA_FM.getPageKey();
                break;
            case "16":
                name = EnumArchiveCoverPageKey.ZXDA_FM_TJ.getPageKey();
                break;
            case "17":
                name = EnumArchiveCoverPageKey.GZDA_FM_TJ.getPageKey();
                break;
            case "18":
                name = EnumArchiveCoverPageKey.DCDA_FM_TJ.getPageKey();
                break;
            case "19":
                name = EnumArchiveCoverPageKey.ZXDA_FM_TJ.getPageKey();
                break;
            case "20":
                name = EnumArchiveCoverPageKey.GZDA_FM_TJ.getPageKey();
                break;
            case "21":
                name = EnumArchiveCoverPageKey.DCDA_FM_TJ.getPageKey();
                break;
            case "22":
                name = EnumArchiveCoverPageKey.ZXDA_FM_XJ.getPageKey();
                break;
            case "23":
                name = EnumArchiveCoverPageKey.GZDA_FM_XJ.getPageKey();
                break;
            case "24":
                name = EnumArchiveCoverPageKey.DCDA_FM_XJ.getPageKey();
                break;
            case "26":
                name = EnumArchiveCoverPageKey.ZXDA_FM.getPageKey();
                break;
            case "27":
                name = EnumArchiveCoverPageKey.GZDA_FM.getPageKey();
                break;
            case "28":
                name = EnumArchiveCoverPageKey.DCDA_FM.getPageKey();
                break;
            case "30":
                name = EnumArchiveCoverPageKey.ZXDA_FM_HUB.getPageKey();
                break;
            case "31":
                name = EnumArchiveCoverPageKey.GZDA_FM_HUB.getPageKey();
                break;
            case "32":
                name = EnumArchiveCoverPageKey.DCDA_FM_HUB.getPageKey();
                break;
            case "33":
                name = EnumArchiveCoverPageKey.ZXDA_FM_HUB.getPageKey();
                break;
            case "34":
                name = EnumArchiveCoverPageKey.GZDA_FM_HUB.getPageKey();
                break;
            case "35":
                name = EnumArchiveCoverPageKey.DCDA_FM_HUB.getPageKey();
                break;
            case "36":
                name = EnumArchiveCoverPageKey.ZXDA_FM_HUB.getPageKey();
                break;
            case "37":
                name = EnumArchiveCoverPageKey.GZDA_FM_HUB.getPageKey();
                break;
            case "38":
                name = EnumArchiveCoverPageKey.DCDA_FM_HUB.getPageKey();
                break;
            case "40":
                name = EnumArchiveCoverPageKey.ZXDA_FM.getPageKey();
                break;
            case "41":
            case "44":
            case "47":
            case "72":
            case "73":
            case "74":
                name = EnumArchiveCoverPageKey.GZDA_FM.getPageKey();
                break;
            case "42":
                name = EnumArchiveCoverPageKey.DCDA_FM.getPageKey();
                break;
            case "43":
                name = EnumArchiveCoverPageKey.ZXDA_FM.getPageKey();
                break;
            case "45":
                name = EnumArchiveCoverPageKey.DCDA_FM.getPageKey();
                break;
            case "46":
                name = EnumArchiveCoverPageKey.ZXDA_FM.getPageKey();
                break;
            case "48":
                name = EnumArchiveCoverPageKey.DCDA_FM.getPageKey();
                break;
            case "50":
            case "55":
            case "59":
                name = EnumArchiveCoverPageKey.ZJ_FM.getPageKey();
                break;
            case "51":
            case "56":
            case "60":
                name = EnumArchiveCoverPageKey.ZJ2_FM.getPageKey();
                break;
            case "52":
            case "57":
            case "61":
                name = EnumArchiveCoverPageKey.FJ_FM.getPageKey();
                break;
            case "53":
            case "58":
            case "62":
            case "69":
            case "70":
            case "71":
                name = EnumArchiveCoverPageKey.DCPGJ_FM.getPageKey();
                break;
            case "66":
            case "67":
            case "68":
                name = EnumArchiveCoverPageKey.DCDA_FM.getPageKey();
                break;
            default:
                break;
        }
        return name;
    }

    /**
     * 获取页面名称
     * @param archivePk  档案类别PK（表T_PRINT_ARCHIVE的PK_ID）
     * @return
     */
    public static String getPageName(String archivePk){
        String name = "";
        switch (archivePk) {
            case "1":
                name = EnumArchiveCoverPageKey.ZXDA_FM.getPageName();
                break;
            case "2":
                name = EnumArchiveCoverPageKey.GZDA_FM.getPageName();
                break;
            case "3":
                name = EnumArchiveCoverPageKey.DCDA_FM.getPageName();
                break;
            case "4":
                name = EnumArchiveCoverPageKey.PZGJDA_FM.getPageName();
                break;
            case "6":
                name = EnumArchiveCoverPageKey.ZXDA_FM_TJ.getPageName();
                break;
            case "7":
                name = EnumArchiveCoverPageKey.GZDA_FM_TJ.getPageName();
                break;
            case "8":
                name = EnumArchiveCoverPageKey.DCDA_FM_TJ.getPageName();
                break;
            case "11":
                name = EnumArchiveCoverPageKey.ZXDA_FM_HUB.getPageName();
                break;
            case "12":
                name = EnumArchiveCoverPageKey.GZDA_FM_HUB.getPageName();
                break;
            case "13":
                name = EnumArchiveCoverPageKey.DCDA_FM.getPageName();
                break;
            case "16":
                name = EnumArchiveCoverPageKey.ZXDA_FM_TJ.getPageName();
                break;
            case "17":
                name = EnumArchiveCoverPageKey.GZDA_FM_TJ.getPageName();
                break;
            case "18":
                name = EnumArchiveCoverPageKey.DCDA_FM_TJ.getPageName();
                break;
            case "19":
                name = EnumArchiveCoverPageKey.ZXDA_FM_TJ.getPageName();
                break;
            case "20":
                name = EnumArchiveCoverPageKey.GZDA_FM_TJ.getPageName();
                break;
            case "21":
                name = EnumArchiveCoverPageKey.DCDA_FM_TJ.getPageName();
                break;
            case "22":
                name = EnumArchiveCoverPageKey.ZXDA_FM_XJ.getPageName();
                break;
            case "23":
                name = EnumArchiveCoverPageKey.GZDA_FM_XJ.getPageName();
                break;
            case "24":
                name = EnumArchiveCoverPageKey.DCDA_FM_XJ.getPageName();
                break;
            case "26":
                name = EnumArchiveCoverPageKey.ZXDA_FM.getPageName();
                break;
            case "27":
                name = EnumArchiveCoverPageKey.GZDA_FM.getPageName();
                break;
            case "28":
                name = EnumArchiveCoverPageKey.DCDA_FM.getPageName();
                break;
            case "30":
                name = EnumArchiveCoverPageKey.ZXDA_FM_HUB.getPageName();
                break;
            case "31":
                name = EnumArchiveCoverPageKey.GZDA_FM_HUB.getPageName();
                break;
            case "32":
                name = EnumArchiveCoverPageKey.DCDA_FM_HUB.getPageName();
                break;
            case "33":
                name = EnumArchiveCoverPageKey.ZXDA_FM_HUB.getPageName();
                break;
            case "34":
                name = EnumArchiveCoverPageKey.GZDA_FM_HUB.getPageName();
                break;
            case "35":
                name = EnumArchiveCoverPageKey.DCDA_FM_HUB.getPageName();
                break;
            case "36":
                name = EnumArchiveCoverPageKey.ZXDA_FM_HUB.getPageName();
                break;
            case "37":
                name = EnumArchiveCoverPageKey.GZDA_FM_HUB.getPageName();
                break;
            case "38":
                name = EnumArchiveCoverPageKey.DCDA_FM_HUB.getPageName();
                break;
            case "50":
            case "55":
            case "59":
                name = EnumArchiveCoverPageKey.ZJ_FM.getPageName();
                break;
            case "51":
            case "56":
            case "60":
                name = EnumArchiveCoverPageKey.ZJ2_FM.getPageName();
                break;
            case "52":
            case "57":
            case "61":
                name = EnumArchiveCoverPageKey.FJ_FM.getPageName();
                break;
            case "53":
            case "58":
            case "62":
            case "69":
            case "70":
            case "71":
                name = EnumArchiveCoverPageKey.DCPGJ_FM.getPageName();
                break;
            default:
                break;
        }
        return name;
    }

    private EnumArchiveCoverPageKey(String value, String pageKey, String pageName) {
        this.value = value;
        this.pageKey = pageKey;
        this.pageName = pageName;
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
