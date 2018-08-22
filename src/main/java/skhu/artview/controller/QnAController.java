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

import skhu.artview.dto.Answer;
import skhu.artview.dto.Question;
import skhu.artview.model.Pagination;
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
	
	//질문 리스트
	@RequestMapping(value = "questionList" , method= RequestMethod.GET)
	   public List<Question> questions(Model model, HttpServletRequest request)  throws Exception {
			
			List<Question> questions = questionService.getAllQuestionList();
	       return questions;
	   }
	

	//질문 + 답변
	@RequestMapping(value = "questionDetail/{id}" , method= RequestMethod.GET)
	   public Question questionDetail(Model model, HttpServletRequest request, @PathVariable("id") int id)  throws Exception {
			
			Question q = questionService.getQuestionById(id);	
			
	       return q;
	   }
	
	
	
	
	//질문 + 답변
	@RequestMapping(value = "qnaDetail/{id}" , method= RequestMethod.GET)
	   public QnADetail qnaDetail(Model model, HttpServletRequest request, @PathVariable("id") int id)  throws Exception {
			
			Question q = questionService.getQuestionById(id);	
			
	       return questionService.QnAMapping(q);
	   }
	
	//질문 등록
	@RequestMapping(value = "question/1" , method= RequestMethod.POST)
	   public String saveQuestion(Model model, HttpServletRequest request, @RequestBody Question q)  throws Exception {
			
			String result = questionService.SaveQ(q);
	       return result;
	   }
	
	//질문 수정
	@RequestMapping(value = "question/2" , method= RequestMethod.POST)
	   public String updateQuestion(Model model, HttpServletRequest request, @RequestBody Question q)  throws Exception {
			
	String result = questionService.updateQ(q);
	       return result;
	   }
	//답변 등록
	@RequestMapping(value = "answer/1" , method= RequestMethod.POST)
	   public String saveAnswer(Model model, HttpServletRequest request, @RequestBody Answer a)  throws Exception {
			
			String result = answerService.SaveA(a);
	       return result;
	   }}
