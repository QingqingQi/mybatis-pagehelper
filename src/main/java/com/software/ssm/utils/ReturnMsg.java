package com.software.ssm.utils;

import java.util.HashMap;
import java.util.Map;

public class ReturnMsg {
	
	private Integer code;//success:100  faile:200
	
	private String msg;
	
	private Map<String, Object> extend = new HashMap<>();
	
	public ReturnMsg add(String key, Object value) {
		this.extend.put(key, value);
		return this;
	}
	
	public static ReturnMsg faile() {
		ReturnMsg rm = new ReturnMsg();
		rm.setCode(200);
		rm.setMsg("操作失败!");
		return rm;
	}
	
	public static ReturnMsg success() {
		ReturnMsg rm = new ReturnMsg();
		rm.setCode(100);
		rm.setMsg("操作成功!");
		return rm;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Map<String, Object> getExtend() {
		return extend;
	}

	public void setExtend(Map<String, Object> extend) {
		this.extend = extend;
	}
	
}
