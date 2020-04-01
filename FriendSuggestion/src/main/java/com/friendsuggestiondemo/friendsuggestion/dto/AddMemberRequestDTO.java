package com.friendsuggestiondemo.friendsuggestion.dto;

import javax.validation.constraints.NotNull;

public class AddMemberRequestDTO {

	@NotNull
	private String userName;

	@NotNull
	private String fullName;

	@NotNull
	private String gender;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

}
