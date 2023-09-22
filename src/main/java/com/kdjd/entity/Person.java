package com.kdjd.entity;

/**
 * 人脸名单
 *
 * @author HeHuan
 */
public class Person {


    /**
     * 所属名单库ID（最大长度32）可调用【人脸名单库添加】新建名单库或调用【人脸名单库查询】获取已有名单库
     */
    private String personLibId;
    /**
     * 姓名（最大长度32位，只支持中文或英文和.）
     */
    private String name;
    /**
     * 注册性别（male-男， female-女，unknown-未知，最大长度为10，默认为unknown）
     */
    private String registerGender;
    /**
     * 出生年月日（格式如2011-06-01）
     */
    private String bornTime;
    /**
     * 证件类型（111-居民身份证，113-户口簿，114-中国人民解放军军官证，131-工作证，123警官证，133-学生证，
     * 335-机动车驾驶证，337-机动车行驶证，414-护照，782-市民卡，990-其他证件）
     */
    private Number certificateType;
    /**
     * 证件号
     */
    private String certificateNumber;
    /**
     * 籍贯区县编号
     */
    private String nativeCountyCode;
    /**
     * 居住地区县编号
     */
    private String residenceCountyCode;
    /**
     * 人员住址信息
     */
    private String address;
    /**
     * 图片访问地址（imageUrl与imageData二选一必填，但当两者都存在的时候,默认使用imageUrl(Url需要进行encode编码，防止出现特殊字符)。
     * 图片像素在48*48-1600w内，文件大小在128字节-4M内。图片类型限制为：png、jpg/jpeg、bmp）
     */
    private String imageUrl;
    /**
     * 图片数据通过Base64编码后的字符串（imageUrl与imageData二选一必填,但当两者都存在的时候,默认使用imageUrl。
     * 图片像素在48*48-1600w内，文件大小在128字节-4M内。图片类型限制为：png、jpg/jpeg、bmp）
     */
    private String imageData;

}
