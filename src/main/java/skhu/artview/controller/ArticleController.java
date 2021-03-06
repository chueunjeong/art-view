package skhu.artview.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import skhu.artview.dto.Article;
import skhu.artview.mapper.ArticleMapper;
import skhu.artview.mapper.CommentMapper;
import skhu.artview.mapper.ProjectMapper;
import skhu.artview.mapper.UserMapper;
import skhu.artview.model.ArticleDetail;
import skhu.artview.service.ArticleService;
import skhu.artview.service.ProjectService;
import skhu.artview.service.UserService;

@RestController
@CrossOrigin
@RequestMapping("api")
public class ArticleController {

	@Autowired ProjectService commuService;
	@Autowired ArticleService articleService;
	@Autowired ProjectMapper projectMapper;
	@Autowired UserService userService;
	@Autowired UserMapper userMapper;
	@Autowired ArticleMapper articleMapper;
	@Autowired CommentMapper commentMapper;

	/*작성자: 남하영*/

/*	작성 예정 컨트롤러
	프로젝트별 채팅창 지원 생각중*/

	//프로젝트별 게시판 출력
	@RequestMapping(value = "article/{board_id}")
	public List<ArticleDetail> articles(@PathVariable("board_id") int boardId) {
		return articleService.articles(boardId);
	}

	//프로젝트별 게시판 게시글+댓글 조회
	@RequestMapping(value = "article/{id}")
	public ArticleDetail articleDetail(@PathVariable("id") int id) {
		return articleService.articleDetail(id);
	}

/*	//프로젝트별 게시판 게시글 작성(파일x)
	@RequestMapping(value = "article/{id}", method = RequestMethod.POST)
	public String articleSubmit(@RequestBody Article article) {
		return articleService.articleSubmit(article);
	}*/

	//프로젝트별 게시판 게시글 작성(파일o)
	@RequestMapping(value = "article/{id}", method = RequestMethod.POST)
	public String articleSubmit(@RequestBody Article article, @RequestBody MultipartFile file) {
		return articleService.articleSubmit(article, file);
	}

	//프로젝트별 게시판 게시글 수정
	@RequestMapping(value = "article/{id}", method = RequestMethod.PUT)
	public String articleEdit(@RequestBody Article article) {
		return articleService.articleEdit(article);
	}

	//프로젝트별 게시판 게시글 삭제
	@RequestMapping(value = "article/{id}", method = RequestMethod.DELETE)
	public String articleDelete(@PathVariable("id") int id) {
		return articleService.articleDelete(id);
	}

	//게시글 작성자/제목/내용/제목+내용으로 검색
	@RequestMapping("articleSearch")
	public List<ArticleDetail> articleSearch(@PathVariable("code") int code, @PathVariable("keyword") String keyword) {
		//작성자=0, 제목=1, 내용=2, 제목+내용=3
		return articleService.search(code, keyword);
	}

}
