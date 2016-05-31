package com.chandan.labs.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.chandan.labs.entity.Questions;
import com.chandan.labs.entity.UserSurvey;
import com.chandan.labs.dto.common.DownloadAttachmentDTO;

public interface SurveyService {
	
	public List<Questions> questionaire();
	
	public void recordUserSurvey(List<UserSurvey> survey);
	
	public List<UserSurvey> getUserSurvey(String userId);
	
	public List<UserSurvey> getAllUserSurvey(String flightNo,String date);
	
	public String getQuestion(long questionId);
	
	public String getAnswer(long answerId);
	
	public void saveAttachment(MultipartFile aFile, long id);
	
	public DownloadAttachmentDTO getAttachment(long id);
	
}
