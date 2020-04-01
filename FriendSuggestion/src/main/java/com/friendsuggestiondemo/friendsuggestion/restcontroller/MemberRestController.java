package com.friendsuggestiondemo.friendsuggestion.restcontroller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.friendsuggestiondemo.friendsuggestion.dto.AddMemberRequestDTO;
import com.friendsuggestiondemo.friendsuggestion.dto.SuccessDTO;
import com.friendsuggestiondemo.friendsuggestion.service.api.MemberService;

@RestController
@RequestMapping(value="/members")
public class MemberRestController {
	
	@Autowired
	MemberService memberService;
	

	@PostMapping
	public ResponseEntity<SuccessDTO> addMember(@Valid @RequestBody AddMemberRequestDTO addMemberRequestDTO)
	{
		SuccessDTO successDTO = memberService.addMember(addMemberRequestDTO);
		return new ResponseEntity<>(successDTO,HttpStatus.CREATED);
	}
}
