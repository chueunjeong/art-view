package skhu.artview.mapper;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import skhu.artview.dto.Question;
import skhu.artview.model.Pagination;

@Mapper
public interface QuestionMapper {
		List<Question> findAllQ(Pagination pagination);
		Question findOne(int id);
		Question findOneWithComment(int id);
		List<Question> findByBoardId(int boardId);
		List<Question> findByUserId(int userId);
		List<Question> findByUsername(String username);
		List<Question> findByTitle(String keyword);
		List<Question> findByContent(String keyword);
		List<Question> findByTitleAndContent(String keyword);
		void insertQ(Question article);	//질문 등록
		
		void updateQ(Question article);	//질문 수정
		void delete(int id);
}
