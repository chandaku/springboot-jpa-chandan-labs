package com.chandan.labs.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.chandan.labs.entity.Questions;

@Repository
public interface QuestionsRepo extends JpaRepository<Questions, Long> {
	
	@Query("Select question from Questions q where q.id=?1")
	public String getQuestion(long questionId);
	
}
