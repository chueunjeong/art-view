package skhu.artview.service;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import skhu.artview.dto.Article;
import skhu.artview.dto.Question;
import skhu.artview.mapper.QuestionMapper;
import skhu.artview.mapper.UserMapper;
import skhu.artview.model.QnADetail;

@Service
public class QuestionService {
	
	@Autowired QuestionMapper questionMapper;
	@Autowired UserMapper userMapper;
	@Autowired S3Service s3Service;
	@Autowired AnswerService answerService;
	
	
	public QnADetail  QnAMapping(Question question) {
		
		QnADetail qnaDetail = new QnADetail();
		qnaDetail.setId(question.getId());
		qnaDetail.setUserId(question.getUserId());
		qnaDetail.setTitle(question.getTitle());
		qnaDetail.setContent(question.getContent());
		qnaDetail.setType(question.getType());
		qnaDetail.setFile_id(question.getFile_id());
		qnaDetail.setUser(question.getUser());
		qnaDetail.setHits(question.getHits());
		
		return answerService.QnAMapping(qnaDetail, question.getId());
		
		
		
		
		
	}
		
		
}
