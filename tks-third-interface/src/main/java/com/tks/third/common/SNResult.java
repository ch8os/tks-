package com.tks.third.common;

public class SNResult {
    public static enum SNResultCode{
    	SUCCESS("00","成功"),REPEAT("01","重复"),DATAERROR("02","数据错误"),SERVERERROR("03","服务器异常");
    	private String code;
    	private String desc;
    	private SNResultCode(String code, String desc) {
    		this.code = code;
    		this.desc = desc;
    	}
    	
    	public String getCode() {
    		return this.code;
    	}
    	
    	public String getDesc() {
    		return this.desc;
    	}
    }

    private String statusCode;
    private String desc;

    public static SNResult ret(SNResultCode resultCode) {
        SNResult result = new SNResult();
        result.setStatusCode(resultCode.getCode());
        result.setDesc(resultCode.getDesc());
        return result;
    }

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

}
