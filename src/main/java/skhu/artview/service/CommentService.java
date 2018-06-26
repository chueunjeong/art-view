package skhu.artview.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import skhu.artview.dto.Comment;
import skhu.artview.dto.User;
import skhu.artview.mapper.ArticleMapper;
import skhu.artview.mapper.CommentMapper;
import skhu.artview.mapper.UserMapper;
import skhu.artview.model.CommentDetail;

@Service
public class CommentService {
	@Autowired ArticleMapper articleMapper;
	@Autowired CommentMapper commentMapper;
	@Autowired UserMapper userMapper;


	public CommentDetail commentMapping(Comment comment) {

		CommentDetail commentDetail = new CommentDetail();
		commentDetail.setId(comment.getId());
		commentDetail.setArticle_id(comment.getArticle_id());
		commentDetail.setUser_id(comment.getUser_id());
		commentDetail.setContent(comment.getContent());
		commentDetail.setDate(comment.getDate());

		commentDetail.setAuthor(userMapper.findOne(comment.getUser_id()));
		return commentDetail;
	}

	//CommentList를 CommentDetailList로 바꿔주는 메서드
	public List<CommentDetail> makeList(List<Comment> list) {
		List<CommentDetail> newList = new ArrayList<CommentDetail>();

		for (int i = 0; i < list.size(); i++) {
			newList.add(i,
			this.commentMapping(list.get(i))
			);
		}

		return newList;
	}

	public String commentSubmit(Comment comment, int article_id) {
		User user = null; //현재 유저 정보 받아오기
		comment.setUser_id(user.getId());
		comment.setArticle_id(article_id);
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