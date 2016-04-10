package com.chandan.labs.controller;

import java.util.List;

import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chandan.labs.entity.Questions;
import com.chandan.labs.entity.UserSurvey;
import com.chandan.labs.service.SurveyService;



@RestController
@RequestMapping(value = "/")
public class SurveyController {
	
	@Autowired
	private SurveyService service;
	
	@RequestMapping(value = "Questionaire", method = RequestMethod.GET)
    public List<Questions> questionaire() {
        return service.questionaire();
    }
	
	@RequestMapping(value = "RecordUserSurvey", method = RequestMethod.POST)
    public void recordSurvey(@RequestBody List<UserSurvey> survey) {
         service.recordUserSurvey(survey);
    }
	
	@RequestMapping(value = "UserResponse", method = RequestMethod.GET)
    public List<UserSurvey> userSurvey(@RequestParam(value = "userId") String userId) {
        return service.getUserSurvey(userId);
    }
	
	@RequestMapping(value = "Question", method = RequestMethod.GET)
    public String getQuestion(@RequestParam(value = "questionId") long questionId) {
        return service.getQuestion(questionId);
    }
	
	@RequestMapping(value = "Answer", method = RequestMethod.GET)
    public String getAnswer(@RequestParam(value = "answerId") long answerId) {
        return service.getAnswer(answerId);
    }
	
	@RequestMapping(value = "AllUserFeedback", method = RequestMethod.GET)
    public List<UserSurvey> userSurvey(@RequestParam(value = "flightNo") String flightNo,@RequestParam(value = "date") String date) {
        return service.getAllUserSurvey(flightNo, date);
    }
	
}
