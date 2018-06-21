package skhu.artview.mapper;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import skhu.artview.dto.QnA;
import skhu.artview.model.Pagination;
import skhu.artview.dto.QnA;

@Mapper
public interface QnAMapper {
		List<QnA> findAllQ(Pagination pagination);
		QnA findOne(int id);
		QnA findOneWithComment(int id);
		List<QnA> findByBoardId(int boardId);
		List<QnA> findByUserId(int userId);
		List<QnA> findByUsername(String username);
		List<QnA> findByTitle(String keyword);
		List<QnA> findByContent(String keyword);
		List<QnA> findByTitleAndContent(String keyword);
		void insertQ(QnA article);	//질문 등록
		void insertA(QnA article);	//답변 등록
		
		void updateQ(QnA article);	//질문 수정
		void updateA(QnA article);	//답변 수정
		void delete(int id);
}
