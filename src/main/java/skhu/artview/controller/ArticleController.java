package skhu.artview.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import skhu.artview.dto.Article;
import skhu.artview.mapper.ArticleMapper;
import skhu.artview.mapper.CommentMapper;
import skhu.artview.mapper.ProjectMapper;
import skhu.artview.mapper.UserMapper;
import skhu.artview.service.CommuService;
import skhu.artview.service.UserService;

@RestController
@CrossOrigin
@RequestMapping("api")
public class ArticleController {

	@Autowired CommuService commuService;
	@Autowired ProjectMapper projectMapper;
	@Autowired UserService userService;
	@Autowired UserMapper userMapper;
	@Autowired ArticleMapper articleMapper;
	@Autowired CommentMapper commentMapper;

	/*작성자: 남하영*/

/*	작성 예정 컨트롤러
	프로젝트별 게시판 게시글 댓글 작성
	프로젝트별 게시판 게시글 댓글 수정
	프로젝트별 게시판 게시글 댓글 삭제
	게시글 작성자/제목/내용/제목+내용으로 검색
	프로젝트별 채팅창 지원 생각중*/

	//프로젝트별 게시판 출력
	@RequestMapping(value = "article/{boardId}")
	public List<Article> community(@PathVariable("boardId") int boardId) {
		return articleMapper.findByBoardId(boardId);
	}

	//프로젝트별 게시판 게시글+댓글 조회
	@RequestMapping(value = "article/{id}")
	public Article article(@PathVariable("id") int id) {
		return articleMapper.findOne(id);
	}

	//프로젝트별 게시판 게시글 작성(나중에 서비스로 분리 예정, 파일서버 파야함)
/*	@RequestMapping(value = "article", method = RequestMethod.POST)
	public String article_submit(@RequestBody Article article) {
		User user = UserService.getCurrentUser(); //현재 유저 정보 받아오기
		article.add(user.getId());
		articleMapper.insert(article);
		return "등록되었습니다";
	}*/

	//프로젝트별 게시판 게시글 수정
	@RequestMapping(value = "article/{id}", method = RequestMethod.PUT)
	public String article_edit(Article article) {
		articleMapper.update(article);
		return "수정되었습니다";
	}

	//프로젝트별 게시판 게시글 삭제
	@RequestMapping(value = "project/{id}", method = RequestMethod.DELETE)
	public String articleDelete(@PathVariable("id") int id) {
		articleMapper.delete(id);
		return "삭제되었습니다";
	}

}
