package com.friendsuggestiondemo.friendsuggestion.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import com.friendsuggestiondemo.friendsuggestion.dto.AddMemberRequestDTO;
import com.friendsuggestiondemo.friendsuggestion.dto.SuccessDTO;
import com.friendsuggestiondemo.friendsuggestion.entity.Member;
import com.friendsuggestiondemo.friendsuggestion.repository.MemberRepository;
import com.friendsuggestiondemo.friendsuggestion.service.api.MemberService;

@Service
@PropertySource("classpath:messages.properties")
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberRepository memberRepository;

	@Value("${com.friendsuggestiondemo.friendsuggestion.successmessage}")
	private String successMessage;

	@Value("${com.friendsuggestiondemo.friendsuggestion.successcode}")
	private Integer successCode;

	Logger log = LoggerFactory.getLogger(MemberServiceImpl.class);

	@Override
	public SuccessDTO addMember(AddMemberRequestDTO addMemberRequestDTO) {
		Member member = new Member();
		member.setUserName(addMemberRequestDTO.getUserName());
		member.setFullName(addMemberRequestDTO.getFullName());
		member.setGender(addMemberRequestDTO.getGender());
		

		memberRepository.save(member);

		SuccessDTO successMessageDTO = new SuccessDTO(successMessage,successCode);
		log.info("Member added successfully.");
		return successMessageDTO;
	}

}
