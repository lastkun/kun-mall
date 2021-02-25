package com.kunmall.common.utils;

import org.apache.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

/**
 * 返回数据
 *
 * @author Mark sunlightcs@gmail.com
 */
public class CommonResult extends HashMap<String, Object> {
	private static final long serialVersionUID = 1L;
	
	public CommonResult() {
		put("code", 0);
		put("msg", "success");
	}
	
	public static CommonResult error() {
		return error(HttpStatus.SC_INTERNAL_SERVER_ERROR, "未知异常，请联系管理员");
	}
	
	public static CommonResult error(String msg) {
		return error(HttpStatus.SC_INTERNAL_SERVER_ERROR, msg);
	}
	
	public static CommonResult error(int code, String msg) {
		CommonResult commonResult = new CommonResult();
		commonResult.put("code", code);
		commonResult.put("msg", msg);
		return commonResult;
	}

	public static CommonResult ok(String msg) {
		CommonResult commonResult = new CommonResult();
		commonResult.put("msg", msg);
		return commonResult;
	}
	
	public static CommonResult ok(Map<String, Object> map) {
		CommonResult commonResult = new CommonResult();
		commonResult.putAll(map);
		return commonResult;
	}
	
	public static CommonResult ok() {
		return new CommonResult();
	}

	public CommonResult put(String key, Object value) {
		super.put(key, value);
		return this;
	}
	public  Integer getCode() {

		return (Integer) this.get("code");
	}

}
