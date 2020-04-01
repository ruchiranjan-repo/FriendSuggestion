package com.friendsuggestiondemo.friendsuggestion.service.api;

import com.friendsuggestiondemo.friendsuggestion.dto.AddFriendsRequestDTO;
import com.friendsuggestiondemo.friendsuggestion.dto.FriendSuggestionDTO;
import com.friendsuggestiondemo.friendsuggestion.dto.SuccessDTO;
import com.friendsuggestiondemo.friendsuggestion.dto.UserNameDTO;
import com.friendsuggestiondemo.friendsuggestion.exception.MemberNotFoundException;

public interface FriendService {
	
	SuccessDTO addFriends(AddFriendsRequestDTO addFriendsRequestDTO)throws MemberNotFoundException;
	
	 FriendSuggestionDTO suggestFriends(UserNameDTO userNameDTO)throws MemberNotFoundException; 

}
