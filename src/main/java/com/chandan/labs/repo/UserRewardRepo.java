package com.chandan.labs.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chandan.labs.entity.UserReward;

@Repository
public interface UserRewardRepo extends JpaRepository<UserReward, Long> {
	
}
