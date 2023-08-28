package com.kdjd.entity;

import java.util.List;

/**
 * 人脸名单库按区域布控
 *
 * @author HeHuan
 */
public class PersonLibRegionControl {
    /**
     * 布控任务ID（最大长度为64)。可通过【分页查询人脸布控信息】获取
     */
    private String taskId;
    /**
     * 布控名称（最大长度60）
     */
    private String name;
    /**
     * 布控名单库ID（多个以英文逗号分隔，最多100个）
     */
    private String personlibIds;
    /**
     * 需要布控的区域编号，支持传多个，用逗号分隔（所选区域下需要存在监控点），可通过可调用【资源目录服务】中获取监控点相关API获取，如【分页获取区域列表】。
     */
    private String regionIndexCodes;
    /**
     * 布控任务自定义开始时间（ISO8601格式yyyy-MM-dd’T’HH:mm:ss.SSSXXX）
     */
    private String beginTime;
    /**
     * 布控任务自定义结束时间（ISO8601格式yyyy-MM-dd’T’HH:mm:ss.SSSXXX）
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
