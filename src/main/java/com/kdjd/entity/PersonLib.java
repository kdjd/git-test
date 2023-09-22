package com.kdjd.entity;

/**
 * 人脸名单库
 *
 * @author HeHuan
 */
public class PersonLib {

    /**
     * 名单库唯一标识（最大长度32）
     */
    private String personLibId;
    /**
     * 名单库名称（最大长度32，只支持中文、英文、数字、_、- ）
     */
    private String personLibName;
    /**
     * 备注（最大长度64）
     */
    private String describe;

    public String getPersonLibId() {
        return personLibId;
    }

    public void setPersonLibId(String personLibId) {
        this.personLibId = personLibId;
    }

    public String getPersonLibName() {
        return personLibName;
    }

    public void setPersonLibName(String personLibName) {
        this.personLibName = personLibName;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }
}
