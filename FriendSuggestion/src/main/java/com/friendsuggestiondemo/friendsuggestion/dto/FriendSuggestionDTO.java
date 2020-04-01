package com.friendsuggestiondemo.friendsuggestion.dto;

import java.util.ArrayList;
import java.util.List;

import com.friendsuggestiondemo.friendsuggestion.entity.Member;

public class FriendSuggestionDTO {
	List<Member> suggestions = new ArrayList<>();

	public List<Member> getSuggestions() {
		return suggestions;
	}

	public void setSuggestions(List<Member> suggestions) {
		this.suggestions = suggestions;
	}

}
