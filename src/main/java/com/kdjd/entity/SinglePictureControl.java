package com.kdjd.entity;

import java.util.List;

/**
 * 单张人脸图片布控
 *
 * @author HeHuan
 */
public class SinglePictureControl {

    /**
     * 布控任务ID（最大长度为64)。可通过[【分页查询人脸布控信息】]获取
     */
    private String taskId;
    /**
     * 布控名称（最大长度60）	嫌犯张三_布控
     */
    private String name;
    /**
     * 需要分析的监控点编号（通用唯一识别码UUID，多个id以逗号分隔，最多传2000个）可调用【资源目录服务】中获取监控点相关API获取，如【分页获取监控点资源】	90ad77d8057c43dab140b77361606927, ZPJ14883601705420002156
     */
    private String cameraIndexCodes;
    /**
     * 人员信息
     */
    private Person personInfo;
    /**
     * 布控任务自定义开始时间（IOS8601格式yyyy-MM-dd’T’HH:mm:ss.SSSXXX）	2017-06-15T00:00:00.000+08:00
     */
    private String beginTime;
    /**
     * 布控任务自定义结束时间（IOS8601格式yyyy-MM-dd’T’HH:mm:ss.SSSXXX）	2017-06-15T23:59:59.000+08:00
     */
    private String endTime;
    /**
     * 布控描述（最大长度200）	本次布控目的：逮捕嫌犯张三，相似度为0.6及以上的报警告知
     */
    private String remark;
    /**
     * 报警接收的手机号码（多个号码以逗号分割，最多传20个）	13805719999
     */
    private String phoneNos;
    /**
     * 分时段报警阈值设置（让预警更精确，最多可设置5个时间段）
     */
    private List<Detail> details;


}
