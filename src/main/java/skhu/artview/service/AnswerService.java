package skhu.artview.service;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import skhu.artview.dto.Answer;
import skhu.artview.dto.Question;
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
		
	//id로 답변 한 개만
	public Answer getAnswerById(int id) {
			
			return answerMapper.findOne(id);

		}
	//답변 등록
	public String SaveA(Answer a) {
		answerMapper.insertA(a);
		
		if(getAnswerById(a.getId()) != null) {
			return "저장 완료";
		}
		return "저장 실패";
	}
}
