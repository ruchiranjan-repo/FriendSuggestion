package com.friendsuggestiondemo.friendsuggestion.dto;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class AddFriendsRequestDTO {

	@NotNull
	private UserNameDTO userName;

    @NotEmpty
	private List<UserNameDTO> friends = new ArrayList<UserNameDTO>();

	public UserNameDTO getUserName() {
		return userName;
	}

	public void setUserName(UserNameDTO userName) {
		this.userName = userName;
	}

	public List<UserNameDTO> getFriends() {
		return friends;
	}

	public void setFriends(List<UserNameDTO> friends) {
		this.friends = friends;
	}

}
