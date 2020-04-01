package com.friendsuggestiondemo.friendsuggestion.exception;

public class MemberNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	private final Integer errorCode;

	public MemberNotFoundException(String message, Integer errorCode) {
		super(message);
		this.errorCode = errorCode;
	}

	public Integer getErrorCode() {
		return errorCode;
	}

}
