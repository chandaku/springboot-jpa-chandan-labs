package com.chandan.labs.service;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.internal.SessionImpl;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.chandan.labs.dto.common.DownloadAttachmentDTO;
import com.chandan.labs.entity.FileAttachment;
import com.chandan.labs.entity.FileUploadTest;
import com.chandan.labs.entity.Questions;
import com.chandan.labs.entity.UserReward;
import com.chandan.labs.entity.UserSurvey;
import com.chandan.labs.exception.DataNotFoundException;
import com.chandan.labs.repo.AnswersRepo;
import com.chandan.labs.repo.FileAttachmentRepo;
import com.chandan.labs.repo.FileUploadTestRepo;
import com.chandan.labs.repo.QuestionsRepo;
import com.chandan.labs.repo.UserRewardRepo;
import com.chandan.labs.repo.UserSurveyRepo;
import com.chandan.labs.util.FileUploadUtil;
import com.chandan.labs.util.MimeTypeMapper;

@Service
public class SurveyServiceImpl implements SurveyService{
	
	public static final String COMMON_BLOB="FILE_ATTACHMENT";
	
	public static final String COMMON_SELECT="SELECT FILE_ATTACHMENT FROM AP_SMARTCAPEX.SC_COMMON_FILE_ATTACH_IN WHERE id = ?";
	
	@Autowired
	private QuestionsRepo questionRepo;
	
	@Autowired
	private AnswersRepo answerRepo;
	
	@Autowired
	private UserSurveyRepo userSurveyRepo;
	
	@Autowired
	private UserRewardRepo userRewardRepo;
	
	@Autowired
	private FileUploadTestRepo uploadTestRepo;
	
	@Autowired
	private FileAttachmentRepo attachmentRepo;
	
	@Autowired
	private EntityManager entityManager;
	
	@Autowired 
	private FileUploadUtil fileUtil;
	
	
	
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

	@Override
	public void saveAttachment(MultipartFile aFile, long id) {

		FileUploadTest entity = uploadTestRepo.findOne(id);

		if (entity == null) {
			throw new DataNotFoundException("Data does not exist for provided id:" + id);
		}

		FileAttachment attachment=null;
		if(entity.getFileId()==null){
			attachment=new FileAttachment();
		}else{
			attachment=entity.getFileId();
		}
		entity.setFileName(aFile.getOriginalFilename());

		prepareUpload(aFile, attachment);
		entity.setFileId(attachment);
		attachmentRepo.save(attachment);
		uploadTestRepo.save(entity);
	}
	
	private void prepareUpload(MultipartFile aFile, FileAttachment attachment) {
	String mime = MimeTypeMapper.getMime(aFile.getOriginalFilename());
	if (mime == null) {
        mime = aFile.getContentType();
    }
	attachment.setFileMimeType(mime);
	Session session = entityManager.unwrap(Session.class);
	try {
        attachment.setFileAttachment(session.getLobHelper().createBlob(aFile.getBytes()));
    } catch (IOException e) {
        e.printStackTrace();
        throw new RuntimeException("Problem with Upload");
    }
		
	}

	@Override
	public DownloadAttachmentDTO getAttachment(long id) {

		FileUploadTest entity = uploadTestRepo.findOne(id);

		if (entity == null) {
			throw new DataNotFoundException("Data does not exist for provided id:" + id);
		}
			
		fileUtil.validateAttachmentAvaialblity(entity.getFileId());
		
		return new DownloadAttachmentDTO(entity.getFileId().getFileMimeType(),fileUtil.getBlob(COMMON_SELECT, entity.getFileId().getId(), COMMON_BLOB,entityManager.unwrap(SessionImpl.class).connection()));
	}
	
	
}
