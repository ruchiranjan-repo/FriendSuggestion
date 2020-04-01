package com.friendsuggestiondemo.friendsuggestion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.friendsuggestiondemo.friendsuggestion.entity.Friend;

@Repository
public interface FriendRepository extends JpaRepository<Friend,Long>{
	
	

}
