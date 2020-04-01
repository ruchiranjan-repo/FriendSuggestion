package com.friendsuggestiondemo.friendsuggestion.restcontroller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.friendsuggestiondemo.friendsuggestion.dto.AddFriendsRequestDTO;
import com.friendsuggestiondemo.friendsuggestion.dto.SuccessDTO;
import com.friendsuggestiondemo.friendsuggestion.exception.MemberNotFoundException;
import com.friendsuggestiondemo.friendsuggestion.service.api.FriendService;

@RestController
@RequestMapping("/friends")
public class FriendRestController {
	
	@Autowired
	FriendService friendService;

	@PostMapping
	public ResponseEntity<SuccessDTO> addFriends(@Valid @RequestBody AddFriendsRequestDTO addFriendsRequestDTO)
			throws MemberNotFoundException {
		SuccessDTO successDTO = friendService.addFriends(addFriendsRequestDTO);
		return new ResponseEntity<>(successDTO, HttpStatus.CREATED);
	}

}
