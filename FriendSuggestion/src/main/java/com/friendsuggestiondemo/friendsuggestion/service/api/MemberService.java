package com.friendsuggestiondemo.friendsuggestion.service.api;

import com.friendsuggestiondemo.friendsuggestion.dto.AddMemberRequestDTO;
import com.friendsuggestiondemo.friendsuggestion.dto.SuccessDTO;

public interface MemberService {
	
	SuccessDTO addMember(AddMemberRequestDTO addMemberRequestDTO);

}
