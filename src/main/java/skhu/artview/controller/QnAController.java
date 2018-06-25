package skhu.artview.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import skhu.artview.dto.Question;
import skhu.artview.model.QnADetail;
import skhu.artview.service.AnswerService;
import skhu.artview.service.QuestionService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("api")
public class QnAController {
	
	@Autowired
	AnswerService answerService;
	@Autowired
	QuestionService questionService;
	
	
	@RequestMapping(value = "qnaDetail/{id}" , method= RequestMethod.GET)
	   public QnADetail qnaDetail(Model model, HttpServletRequest request, @PathVariable("id") int id)  throws Exception {
			
			Question q = questionService.getQuestionById(id);	
			
	       return questionService.QnAMapping(q);
	   }
	
	

}
