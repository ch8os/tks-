package com.tks.resource.common.entity;

import java.util.Date;

public class TAdviceInfo {
    private String id;

    private String scanId;

    private String type;

    private Date adviceDate;

    private Date createTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getScanId() {
        return scanId;
    }

    public void setScanId(String scanId) {
        this.scanId = scanId == null ? null : scanId.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Date getAdviceDate() {
        return adviceDate;
    }

    public void setAdviceDate(Date adviceDate) {
        this.adviceDate = adviceDate;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}