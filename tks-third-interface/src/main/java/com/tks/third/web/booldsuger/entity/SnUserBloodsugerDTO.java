package com.tks.third.web.booldsuger.entity;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class SnUserBloodsugerDTO{
    private String code;

    private String devicesn;

    private String usercode;

    private String openid;

    private BigDecimal result;

    private String unit;

    private String testtime;

    private String foodstatus;
}