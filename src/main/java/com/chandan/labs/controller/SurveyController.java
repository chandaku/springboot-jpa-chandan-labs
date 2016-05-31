package com.chandan.labs.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.chandan.labs.dto.common.DownloadAttachmentDTO;
import com.chandan.labs.entity.Questions;
import com.chandan.labs.entity.UserSurvey;
import com.chandan.labs.exception.DataNotFoundException;
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
	
	@RequestMapping(value = "FileUpload/{id}/attachment", method = RequestMethod.GET)
    public void getAttachment(HttpServletResponse response, @PathVariable("id") long id) throws IOException {
        DownloadAttachmentDTO file = service.getAttachment(id);

        if (file != null) {
            OutputStream out = response.getOutputStream();
            response.setStatus(HttpServletResponse.SC_OK);
            response.setContentType(file.getMimeType());
            out.write(file.getBytes());
            out.flush();
            out.close();
        } else {
            throw new DataNotFoundException("No attachment found for id:" + id);
        }
    }
	
	@RequestMapping(value = "FileUpload/{id}/attachment", method = RequestMethod.POST)
    public void saveAttachment(@RequestParam("file") MultipartFile aFile, @PathVariable("id") long id) {
        service.saveAttachment(aFile, id);
    }
	
}
