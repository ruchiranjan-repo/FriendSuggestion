package com.friendsuggestiondemo.friendsuggestion.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.friendsuggestiondemo.friendsuggestion.entity.Friend;

@Repository
public interface FriendRepository extends JpaRepository<Friend,Long>{
	
	List<Friend> findByMemberId(Long memberId);
	@Query(value = " select friend_id from  FRIEND   where member_id=?1", nativeQuery = true)
	List<Long> findFriendsByMemberId(Long memberId);
	
	
	
	

}
