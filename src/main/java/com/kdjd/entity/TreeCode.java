package com.kdjd.entity;

/**
 * 树编码
 *
 * @author HeHuan
 */
public class TreeCode {
    /**
     * 树编码（长度1-255位）
     */
    private String treeCode;
    /**
     * 树名称（长度1-255位）
     */
    private String treeName;
    /**
     * 能力集（该树下的监控点的能力集的集合，详见【数据字典】）,取值参考【数据字典】，typeCode为xresmgr.capability_set
     */
    private String capabilitySet;
    /**
     * 智能能力集（该树下的监控点的智能能力集的集合，详见【数据字典】）,取值参考【数据字典】，typeCode为xresmgr.intelligent_set
     */
    private String intelligentSet;

    public String getTreeCode() {
        return treeCode;
    }

    public void setTreeCode(String treeCode) {
        this.treeCode = treeCode;
    }

    public String getTreeName() {
        return treeName;
    }

    public void setTreeName(String treeName) {
        this.treeName = treeName;
    }

    public String getCapabilitySet() {
        return capabilitySet;
    }

    public void setCapabilitySet(String capabilitySet) {
        this.capabilitySet = capabilitySet;
    }

    public String getIntelligentSet() {
        return intelligentSet;
    }

    public void setIntelligentSet(String intelligentSet) {
        this.intelligentSet = intelligentSet;
    }
}
