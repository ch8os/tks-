package com.tks.sn.common;

import lombok.Data;

@Data
public class BaseSNHead {
	private String signature;
	
	private String timestamp;
	
	private String randomnumber;
}
