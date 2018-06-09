package skhu.artview.mapper;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import skhu.artview.dto.Comment;

@Mapper
public interface CommentMapper {
	Comment findOne(int id);
	List<Comment> findByUserId(String userId);
    List<Comment> findByArticleId(int articleId);
	List<Comment> findAll();
	void commentUpload(Comment comment);
	void rateUpload(Comment comment);
	void updateContext(Comment comment);
	void updateRate(Comment comment);
	void delete(int id);
	void insertComment(Comment comment);
	void insertRate(Comment comment);
}
