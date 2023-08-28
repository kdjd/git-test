package com.kdjd.entity;

/**
 * 分时段报警阈值设置（让预警更精确，最多可设置5个时间段）
 *
 * @author HeHuan
 */
public class Detail {

    /**
     * 报警阈值设置（取值范围：0-1）
     */
    private Double thresholdMin;
    /**
     * 报警时段开始时刻点（格式：HH:mm）
     */
    private String startPeriod;
    /**
     * 报警时段结束时刻点（格式：HH:mm）
     */
    private String endPeriod;
}
