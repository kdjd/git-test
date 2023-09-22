package com.kdjd.entity;

import java.util.List;

/**
 * 人脸名单库布控任务
 *
 * @author HeHuan
 */
public class PersonLibControl {
    /**
     * 布控任务ID（最大长度为64）。可通过【分页查询人脸布控信息】获取
     */
    private String taskId;
    /**
     * 布控名称（最大长度60）
     */
    private String name;
    /**
     * 布控名单库ID（多个以英文逗号隔开，最多100个）。可通过【人脸名单库查询】获取或【人脸名单库添加】新建。
     */
    private String personlibIds;
    /**
     * 需要分析的监控点id（多个id以逗号分隔,最多传2000个）可调用【资源目录服务】中获取监控点相关API获取，如【分页获取监控点资源】
     */
    private String cameraIndexCodes;
    /**
     * 布控任务自定义开始时间（IOS8601格式yyyy-MM-dd’T’HH:mm:ss.SSSXXX）
     */
    private String beginTime;
    /**
     * 布控任务自定义结束时间（IOS8601格式yyyy-MM-dd’T’HH:mm:ss.SSSXXX）
     */
    private String endTime;
    /**
     * 布控描述（最大长度200）
     */
    private String remark;
    /**
     * 报警接收的手机号码（多个号码以逗号分割，最多传20个）
     */
    private String phoneNos;
    /**
     * 分时段报警阈值设置（让预警更精确，最多可设置5个时间段）
     */
    private List<Detail> details;

}
