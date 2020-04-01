package com.friendsuggestiondemo.friendsuggestion.dto;

public class SuccessDTO {

	private String message;
	private Integer successCode;
	
	public SuccessDTO() {
		
	}

	public SuccessDTO(String message, Integer successCode) {
		super();
		this.message = message;
		this.successCode = successCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Integer getSuccessCode() {
		return successCode;
	}

	public void setSuccessCode(Integer successCode) {
		this.successCode = successCode;
	}

}
