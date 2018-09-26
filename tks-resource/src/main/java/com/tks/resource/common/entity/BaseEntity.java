package com.tks.resource.common.entity;

import java.util.Date;

import lombok.Data;

@Data
public class BaseEntity {
	private String id;
	
	private Date createTime;
}
