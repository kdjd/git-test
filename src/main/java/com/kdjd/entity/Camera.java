package com.kdjd.entity;

/**
 * 监控点资源
 *
 * @author HeHuan
 */
public class Camera {

    /**
     * String	监控点编号（通用唯一识别码UUID）
     */
    private String cameraIndexCode;
    /**
     * String	监控点国标编号
     */
    private String gbIndexCode;
    /**
     * String	监控点名称
     */
    private String name;
    /**
     * String	所属设备编号（通用唯一识别码UUID）
     */
    private String deviceIndexCode;
    /**
     * String	经度（WGS84坐标系）
     */
    private String longitude;
    /**
     * String	纬度（WGS84坐标系）
     */
    private String latitude;
    /**
     * String	海拔高度（WGS84坐标系，单位：米）
     */
    private String altitude;
    /**
     * Number	摄像机像素（1-普通像素，2-130万高清，3-200万高清，4-300万高清，取值参考【数据字典】，typeCode为xresmgr.piexl）
     */
    private Number pixel;
    /**
     * Number	监控点类型（0-枪机,1-半球,2-快球,3-带云台枪机,取值参考【数据字典】，typeCode为xresmgr.camera_type）
     */
    private Number cameraType;
    /**
     * String	监控点类型说明
     */
    private String cameraTypeName;
    /**
     * String	安装位置
     */
    private String installPlace;
    /**
     * String	矩阵编号
     */
    private String matrixCode;
    /**
     * Number	通道号
     */
    private Number chanNum;
    /**
     * String	可视域相关（JSON格式），该字段具体使用方式参考【监控点可视域字段说明】
     */
    private String viewshed;
    /**
     * String	能力集（详见【数据字典】，typeCode为xresmgr.capability_set）
     */
    private String capabilitySet;
    /**
     * String	能力集说明
     */
    private String capabilitySetName;
    /**
     * String	智能分析能力集（详见【数据字典】，typeCode为xresmgr.intelligent_set）
     */
    private String intelligentSet;
    /**
     * String	智能分析能力集说明
     */
    private String intelligentSetName;
    /**
     * String	录像存储位置（0-中心存储，1-设备存储，取值参考【数据字典】，typeCode为xresmgr.record_location）
     */
    private String recordLocation;
    /**
     * String	录像存储位置说明
     */
    private String recordLocationName;
    /**
     * Number	扩展字段，暂不使用
     */
    private Number ptzController;
    /**
     * String	扩展字段，暂不使用
     */
    private String ptzControllerName;
    /**
     * String	所属设备类型（详见【数据字典】，typeCode为xresmgr.resource_type）
     */
    private String deviceResourceType;
    /**
     * String	所属设备类型说明
     */
    private String deviceResourceTypeName;
    /**
     * String	通道子类型（详见【数据字典】，typeCode为xresmgr.device_type_code.camera）
     */
    private String channelType;
    /**
     * String	通道子类型说明
     */
    private String channelTypeName;
    /**
     * Number	传输协议（0-UDP，1-TCP，取值参考【数据字典】，typeCode为xresmgr.transType）
     */
    private Number transType;
    /**
     * String	传输协议类型说明
     */
    private String transTypeName;
    /**
     * String	监控点更新时间（IOS8601格式yyyy-MM-dd’T’HH:mm:ss.SSSXXX）
     */
    private String updateTime;
    /**
     * String	所属区域编号（通用唯一识别码UUID）
     */
    private String unitIndexCode;
    /**
     * String	接入协议（详见【数据字典】，typeCode为xresmgr.protocol_type）
     */
    private String treatyType;
    /**
     * String	接入协议类型说明
     */
    private String treatyTypeName;
    /**
     * String	监控点创建时间（IOS8601格式yyyy-MM-dd’T’HH:mm:ss.SSSXXX）
     */
    private String createTime;
    /**
     * String	在线状态（0-不在线，1-在线，取值参考【数据字典】，typeCode为xresmgr.status）
     */
    private String status;
    /**
     * String	状态说明
     */
    private String statusName;

}
