package com.chandan.labs.service;

import java.util.List;

import com.chandan.labs.entity.Questions;
import com.chandan.labs.entity.UserSurvey;

public interface SurveyService {
	
	public List<Questions> questionaire();
	
	public void recordUserSurvey(List<UserSurvey> survey);
	
	public List<UserSurvey> getUserSurvey(String userId);
	
	public List<UserSurvey> getAllUserSurvey(String flightNo,String date);
	
	public String getQuestion(long questionId);
	
	public String getAnswer(long answerId);
	
}
