package com.tks.sn.common;

public class SNResult {
    public static enum ResultCode{
    	SUCCESS("00","成功"),REPEAT("01","重复"),DATAERROR("02","数据错误"),SERVERERROR("03","服务器异常");
    	private String code;
    	private String desc;
    	private ResultCode(String code, String desc) {
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

    private String staticCode;
    private String desc;

    public static SNResult ret(ResultCode resultCode) {
        SNResult result = new SNResult();
        result.setStaticCode(resultCode.getCode());
        result.setDesc(resultCode.getDesc());
        return result;
    }

	public String getStaticCode() {
		return staticCode;
	}

	public void setStaticCode(String staticCode) {
		this.staticCode = staticCode;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

}
