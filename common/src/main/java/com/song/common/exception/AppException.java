package com.song.common.exception;

import com.alibaba.fastjson.JSONObject;

import java.text.MessageFormat;


public class AppException extends Exception {
	private static final long serialVersionUID = 6070192332898974631L;

	private Integer errorCode;
	private String errorMessage;

	public AppException(Integer errorCode) {
		super(ExceptionMessage.getErrorMessage(errorCode));
		this.errorCode = errorCode;
		this.errorMessage = ExceptionMessage.getErrorMessage(errorCode);
	}

	public AppException(Integer errorCode, Throwable cause) {
		super(ExceptionMessage.getErrorMessage(errorCode), cause);
		this.errorCode = errorCode;
		this.errorMessage = ExceptionMessage.getErrorMessage(errorCode);
	}

	public AppException(Integer errorCode, Object... args) {
		super(ExceptionMessage.getErrorMessage(errorCode));
		this.errorCode = errorCode;
		String errorMessage = ExceptionMessage.getErrorMessage(errorCode);
		this.errorMessage = MessageFormat.format(errorMessage, args);
	}

	public Integer getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	@Override
	public String getMessage() {
		return this.errorMessage;
	}

	/**
	 * 将异常转成JSON格式
	 * 
	 * @return JSON格式字符串
	 */
	public String toJson() {
		JSONObject object = new JSONObject();
		object.put("code", errorCode);
		object.put("msg", errorMessage);
		return object.toJSONString();
	}
}
