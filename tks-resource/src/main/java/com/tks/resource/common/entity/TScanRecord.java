package com.tks.resource.common.entity;

import java.util.Date;

public class TScanRecord {
    private String id;

    private String docId;

    private String patOpenid;

    private String adviceId;

    private Date createTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getDocId() {
        return docId;
    }

    public void setDocId(String docId) {
        this.docId = docId == null ? null : docId.trim();
    }

    public String getPatOpenid() {
        return patOpenid;
    }

    public void setPatOpenid(String patOpenid) {
        this.patOpenid = patOpenid == null ? null : patOpenid.trim();
    }

    public String getAdviceId() {
        return adviceId;
    }

    public void setAdviceId(String adviceId) {
        this.adviceId = adviceId == null ? null : adviceId.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}