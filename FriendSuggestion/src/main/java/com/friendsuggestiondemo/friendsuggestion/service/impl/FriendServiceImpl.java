package com.friendsuggestiondemo.friendsuggestion.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.friendsuggestiondemo.friendsuggestion.dto.AddFriendsRequestDTO;
import com.friendsuggestiondemo.friendsuggestion.dto.FriendSuggestionDTO;
import com.friendsuggestiondemo.friendsuggestion.dto.MemberDTO;
import com.friendsuggestiondemo.friendsuggestion.dto.SuccessDTO;
import com.friendsuggestiondemo.friendsuggestion.dto.UserNameDTO;
import com.friendsuggestiondemo.friendsuggestion.entity.Friend;
import com.friendsuggestiondemo.friendsuggestion.entity.Member;
import com.friendsuggestiondemo.friendsuggestion.exception.MemberNotFoundException;
import com.friendsuggestiondemo.friendsuggestion.repository.FriendRepository;
import com.friendsuggestiondemo.friendsuggestion.repository.MemberRepository;
import com.friendsuggestiondemo.friendsuggestion.service.api.FriendService;

@Service
public class FriendServiceImpl implements FriendService {

	@Autowired
	MemberRepository memberRepository;

	@Autowired
	FriendRepository friendRepository;

	Logger log = LoggerFactory.getLogger(FriendServiceImpl.class);

	@Value("${com.friendsuggestiondemo.friendsuggestion.exception.usernotfound.message}")
	private String memberNotFoundMessage;

	@Value("${com.friendsuggestiondemo.friendsuggestion.exception.usernotfound.errorCode}")
	private Integer memberNotFoundCode;

	@Value("${com.friendsuggestiondemo.friendsuggestion.friend.successmessage}")
	private String successMessage;

	@Value("${com.friendsuggestiondemo.friendsuggestion.friend.successcode}")
	private Integer successCode;

	@Override
	public SuccessDTO addFriends(AddFriendsRequestDTO addFriendsRequestDTO) throws MemberNotFoundException {

		String memberName = addFriendsRequestDTO.getUserName().getUserName();
		Member member = getMember(memberName);
		List<Member> friends = new ArrayList<>();
		if (!CollectionUtils.isEmpty(addFriendsRequestDTO.getFriends())) {

			for (UserNameDTO userName : addFriendsRequestDTO.getFriends()) {
				friends.add(getMember(userName.getUserName()));

			}
		}

		if (!CollectionUtils.isEmpty(friends)) {

			for (Member friend : friends) {
				Friend membersFriend = new Friend();
				membersFriend.setFriend(friend);
				membersFriend.setMember(member);
				friendRepository.save(membersFriend);

			}
			log.info("friends added successfully");
		}

		SuccessDTO successDTO = new SuccessDTO(successMessage, successCode);

		return successDTO;
	}

	private Member getMember(String userName) throws MemberNotFoundException {
		Optional<Member> member = memberRepository.findByUserName(userName);
		if (!member.isPresent()) {
			log.warn("Member with username :" + userName + "not found.");
			throw new MemberNotFoundException(new StringBuffer(memberNotFoundMessage).append(userName).toString(),
					memberNotFoundCode);
		}
		log.info("member found with user name:" + userName);
		return member.get();
	}

	@Override
	public FriendSuggestionDTO suggestFriends(UserNameDTO userNameDTO) throws MemberNotFoundException {
		Member member = getMember(userNameDTO.getUserName());

		List<Long> friendIds = friendRepository.findFriendsByMemberId(member.getId());
		List<Long> commonFriends = new ArrayList<>();
		if (!CollectionUtils.isEmpty(friendIds)) {
			for (Long friendId : friendIds) {
				commonFriends.addAll(friendRepository.findFriendsByMemberId(friendId));
			}
		}

		commonFriends.remove(member.getId());

		Map<Long, Integer> suggestedFriend = new HashMap<Long, Integer>();
		for (Long friend : commonFriends) {
			if (suggestedFriend.containsKey(friend)) {
				suggestedFriend.put(friend, suggestedFriend.get(friend) + 1);
			} else {
				suggestedFriend.put(friend, 1);
			}
		}
		Integer max=suggestedFriend.values().stream().max(Integer::compare).get();
		Long friend=null;
		for(Long key:suggestedFriend.keySet())
		{
			if(max.equals(suggestedFriend.get(key)))
			{
				friend=key;
				break;
				
			}
		}
		FriendSuggestionDTO friendSuggestionDTO= new FriendSuggestionDTO();
		List<Member> friendsugg= new ArrayList<>();
		friendsugg.add(memberRepository.findById(friend).get());
		friendSuggestionDTO.setSuggestions(friendsugg);
		
		return friendSuggestionDTO;
		
	}

}
