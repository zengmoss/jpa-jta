package com.biostime.jpa.jta.response;

public class BaseRes{
	//序列号
    private String seqNo;
    //返回编码
    private String code;
    //返回描述
    private String desc = "成功";
    
	public String getSeqNo() {
		return seqNo;
	}
	public void setSeqNo(String seqNo) {
		this.seqNo = seqNo;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
}
