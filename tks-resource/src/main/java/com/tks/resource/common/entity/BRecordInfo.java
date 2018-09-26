package com.tks.resource.common.entity;

import java.util.Date;

public class BRecordInfo {
    private String id;

    private String hosCode;

    private String patientId;

    private String inpNo;

    private String inpTimes;

    private String age;

    private String sex;

    private String deptCode;

    private String deptName;

    private String wardCode;

    private String wardName;

    private String bedNo;

    private String diagNo;

    private String diagName;

    private String talkType;

    private String narcoticId;

    private String operation;

    private String recordName;

    private String foldPath;

    private Date uploadTime;

    private String userId;

    private Integer talkTime;

    private String isfinished;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getHosCode() {
        return hosCode;
    }

    public void setHosCode(String hosCode) {
        this.hosCode = hosCode == null ? null : hosCode.trim();
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId == null ? null : patientId.trim();
    }

    public String getInpNo() {
        return inpNo;
    }

    public void setInpNo(String inpNo) {
        this.inpNo = inpNo == null ? null : inpNo.trim();
    }

    public String getInpTimes() {
        return inpTimes;
    }

    public void setInpTimes(String inpTimes) {
        this.inpTimes = inpTimes == null ? null : inpTimes.trim();
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age == null ? null : age.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode == null ? null : deptCode.trim();
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName == null ? null : deptName.trim();
    }

    public String getWardCode() {
        return wardCode;
    }

    public void setWardCode(String wardCode) {
        this.wardCode = wardCode == null ? null : wardCode.trim();
    }

    public String getWardName() {
        return wardName;
    }

    public void setWardName(String wardName) {
        this.wardName = wardName == null ? null : wardName.trim();
    }

    public String getBedNo() {
        return bedNo;
    }

    public void setBedNo(String bedNo) {
        this.bedNo = bedNo == null ? null : bedNo.trim();
    }

    public String getDiagNo() {
        return diagNo;
    }

    public void setDiagNo(String diagNo) {
        this.diagNo = diagNo == null ? null : diagNo.trim();
    }

    public String getDiagName() {
        return diagName;
    }

    public void setDiagName(String diagName) {
        this.diagName = diagName == null ? null : diagName.trim();
    }

    public String getTalkType() {
        return talkType;
    }

    public void setTalkType(String talkType) {
        this.talkType = talkType == null ? null : talkType.trim();
    }

    public String getNarcoticId() {
        return narcoticId;
    }

    public void setNarcoticId(String narcoticId) {
        this.narcoticId = narcoticId == null ? null : narcoticId.trim();
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation == null ? null : operation.trim();
    }

    public String getRecordName() {
        return recordName;
    }

    public void setRecordName(String recordName) {
        this.recordName = recordName == null ? null : recordName.trim();
    }

    public String getFoldPath() {
        return foldPath;
    }

    public void setFoldPath(String foldPath) {
        this.foldPath = foldPath == null ? null : foldPath.trim();
    }

    public Date getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(Date uploadTime) {
        this.uploadTime = uploadTime;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public Integer getTalkTime() {
        return talkTime;
    }

    public void setTalkTime(Integer talkTime) {
        this.talkTime = talkTime;
    }

    public String getIsfinished() {
        return isfinished;
    }

    public void setIsfinished(String isfinished) {
        this.isfinished = isfinished == null ? null : isfinished.trim();
    }
}