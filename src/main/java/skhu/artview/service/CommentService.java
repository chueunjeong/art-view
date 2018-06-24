package skhu.artview.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import skhu.artview.dto.Comment;
import skhu.artview.dto.User;
import skhu.artview.mapper.ArticleMapper;
import skhu.artview.mapper.CommentMapper;
import skhu.artview.mapper.UserMapper;

@Service
public class CommentService {
	@Autowired ArticleMapper articleMapper;
	@Autowired CommentMapper commentMapper;
	@Autowired UserMapper userMapper;

	public String commentSubmit(Comment comment, int article_id) {
		User user = null; //현재 유저 정보 받아오기
		comment.setUserId(user.getId());
		comment.setArticleId(article_id);
		commentMapper.insertComment(comment);
		return "등록되었습니다";
	}

	public String commentEdit(int id) {
		commentMapper.updateContext(id);
		return "수정되었습니다";
	}

	public String commentDelete(int id) {
		commentMapper.delete(id);
		return "삭제되었습니다";
	}

}