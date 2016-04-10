package com.chandan.labs.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.chandan.labs.entity.Answers;

@Repository
public interface AnswersRepo extends JpaRepository<Answers, Long> {
	

	@Query("Select answer from Answers a where a.id=?1")
	public String getAnswer(long answerId);
}
