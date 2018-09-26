package com.tks.wx.common.entity;

import lombok.Data;

@Data
public class TemplateParam {

    //传入参数名称
    private String name;
    //传入参数值
    private String value;
    //用于设置字体颜色
    private String color;

    public TemplateParam(String name, String value, String color) {
        this.name = name;
        this.value = value;
        this.color = color;

    }
}