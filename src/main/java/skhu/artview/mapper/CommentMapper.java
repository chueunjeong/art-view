package skhu.artview.mapper;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import skhu.artview.dto.Comment;

@Mapper
public interface CommentMapper {
	Comment findOne(int id);
	List<Comment> findByUserId(String user_id);
    List<Comment> findByArticleId(int article_id);
	List<Comment> findAll();
	void updateContext(int id);
	void updateRate(int id);
	void delete(int id);
	void insertComment(Comment comment);
	void insertRate(Comment comment);
}
