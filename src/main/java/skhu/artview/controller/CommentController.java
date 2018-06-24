package skhu.artview.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import skhu.artview.dto.Comment;
import skhu.artview.mapper.CommentMapper;
import skhu.artview.service.CommentService;

@RestController
@CrossOrigin
@RequestMapping("api")
public class CommentController {

	@Autowired CommentMapper commentMapper;
	@Autowired CommentService commentService;

	//프로젝트별 게시판 게시글 댓글 작성
	@RequestMapping(value = "comment/{id}", method = RequestMethod.POST)
	public String commentSubmit(@RequestBody Comment comment, @PathVariable("article_id") int article_id) {
		//User user = UserService.getCurrentUser(); //현재 유저 정보 받아오기
		//article.add(user.getId());
		return commentService.commentSubmit(comment, article_id);
	}

	//프로젝트별 게시판 게시글 댓글 수정
	@RequestMapping(value = "comment/{id}", method = RequestMethod.PUT)
	public String commentEdit(@PathVariable("id") int id) {
		return commentService.commentEdit(id);
	}

	//프로젝트별 게시판 게시글 댓글 삭제
	@RequestMapping(value = "comment/{id}", method = RequestMethod.DELETE)
	public String commentDelete(@PathVariable("id") int id) {
		return commentService.commentDelete(id);
	}

}