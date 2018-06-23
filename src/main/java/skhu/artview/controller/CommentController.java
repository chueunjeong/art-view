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

@RestController
@CrossOrigin
@RequestMapping("api")
public class CommentController {

	@Autowired CommentMapper commentMapper;

	//프로젝트별 게시판 게시글 댓글 작성
	@RequestMapping(value = "comment/{id}", method = RequestMethod.POST)
	public void commentSubmit(@RequestBody Comment comment) {
		//User user = UserService.getCurrentUser(); //현재 유저 정보 받아오기
		//article.add(user.getId());
		commentMapper.insertComment(comment);
		//return "등록되었습니다";
	}

	//프로젝트별 게시판 게시글 댓글 수정
	@RequestMapping(value = "comment/{id}", method = RequestMethod.PUT)
	public void commentEdit(@PathVariable("id") int id) {
		commentMapper.updateContext(id);
	}

	//프로젝트별 게시판 게시글 댓글 삭제
	@RequestMapping(value = "comment/{id}", method = RequestMethod.DELETE)
	public void commentDelete(@PathVariable("id") int id) {
		commentMapper.delete(id);
		//return "삭제되었습니다";
	}

}