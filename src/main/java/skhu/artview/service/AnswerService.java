package skhu.artview.service;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import skhu.artview.dto.Answer;
import skhu.artview.mapper.AnswerMapper;
import skhu.artview.mapper.UserMapper;
import skhu.artview.model.QnADetail;

@Service
public class AnswerService {

	@Autowired AnswerMapper answerMapper;
	@Autowired UserMapper userMapper;
	@Autowired S3Service s3Service;
	
	public QnADetail  QnAMapping(QnADetail qnaDetail, int question_id){
		
		ArrayList<Answer> answers =answerMapper.findByQuestion_id(question_id);
		
		qnaDetail.setAnswers(answers);
		
		return qnaDetail;
	}
		
	
	
}
