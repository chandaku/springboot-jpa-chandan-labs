package com.chandan.labs.service;

import java.util.List;

import javax.transaction.Transactional;

import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chandan.labs.entity.Questions;
import com.chandan.labs.entity.UserReward;
import com.chandan.labs.entity.UserSurvey;
import com.chandan.labs.repo.AnswersRepo;
import com.chandan.labs.repo.QuestionsRepo;
import com.chandan.labs.repo.UserRewardRepo;
import com.chandan.labs.repo.UserSurveyRepo;

@Service
public class SurveyServiceImpl implements SurveyService{
	
	@Autowired
	private QuestionsRepo questionRepo;
	
	@Autowired
	private AnswersRepo answerRepo;
	
	@Autowired
	private UserSurveyRepo userSurveyRepo;
	
	@Autowired
	private UserRewardRepo userRewardRepo;
	
	
	
	@Override
	public List<Questions> questionaire() {
		return questionRepo.findAll();
	}
	
	@Transactional
	@Override
	public void recordUserSurvey(List<UserSurvey> survey) {
		UserReward reward=null;
		if(!survey.isEmpty()){
		reward=new UserReward();
		reward.setUserId((survey.get(0).getUserId()));
		reward.setRewards(10);
		userRewardRepo.save(reward);
		userSurveyRepo.save(survey);
		return;
		}
		throw new RuntimeException("No Survey Submitted as it was all blank");
		
	}

	@Override
	public List<UserSurvey> getUserSurvey(String userId) {
		return null;
	}

	@Override
	public String getQuestion(long questionId) {
		return questionRepo.getQuestion(questionId);
	}

	@Override
	public String getAnswer(long answerId) {
		return answerRepo.getAnswer(answerId);
	}

	@Override
	public List<UserSurvey> getAllUserSurvey(String flightNo, String date) {
		return userSurveyRepo.findByFlightNoAndSurveyDate(flightNo, LocalDate.parse(date));
	}
}
