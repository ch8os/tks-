package com.tks.resource.common.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class SnUserBloodsuger {
    private String id;

    private String code;

    private String devicesn;

    private String usercode;

    private String openid;

    private BigDecimal result;

    private String unit;

    private Date testtime;

    private  Date endDate;

    private String foodstatus;

    private String source;

    private Date createTime;


}