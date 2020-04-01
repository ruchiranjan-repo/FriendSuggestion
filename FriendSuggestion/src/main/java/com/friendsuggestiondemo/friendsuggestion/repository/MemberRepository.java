package com.friendsuggestiondemo.friendsuggestion.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.friendsuggestiondemo.friendsuggestion.entity.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

	Optional<Member> findByUserName(String userName);
	
	Optional<Member> findById(Long id);

}
