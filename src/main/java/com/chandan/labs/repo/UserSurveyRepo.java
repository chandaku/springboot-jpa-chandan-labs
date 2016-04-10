package com.chandan.labs.repo;

import java.util.List;

import org.joda.time.LocalDate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chandan.labs.entity.UserSurvey;

@Repository
public interface UserSurveyRepo extends JpaRepository<UserSurvey, Long> {
	
	public List<UserSurvey> findByFlightNoAndSurveyDate(String flightNo,LocalDate date);
	
}
