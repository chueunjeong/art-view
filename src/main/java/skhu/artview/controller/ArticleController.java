package skhu.artview.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import skhu.artview.dto.Article;
import skhu.artview.dto.Comment;
import skhu.artview.mapper.ArticleMapper;
import skhu.artview.mapper.CommentMapper;
import skhu.artview.mapper.ProjectMapper;
import skhu.artview.mapper.UserMapper;
import skhu.artview.service.ArticleService;
import skhu.artview.service.CommuService;
import skhu.artview.service.UserService;

@RestController
@CrossOrigin
@RequestMapping("api")
public class ArticleController {

	@Autowired CommuService commuService;
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
	@RequestMapping(value = "article/{boardId}")
	public List<Article> article(@PathVariable("boardId") int boardId) {
		List<Article> articles = articleMapper.findByBoardId(boardId);
		for (int i = 0; i < articles.size(); i++) {
			articles.add(i, articleService.articleMapping(articles.get(i)));
		}
		return articles;
	}

	//프로젝트별 게시판 게시글+댓글 조회
	@RequestMapping(value = "article/{id}")
	public Article article_detail(@PathVariable("id") int id) {
		Article article = articleMapper.findOne(id);
		article = articleService.articleMapping(article);
		return article;
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
	public void article_edit(Article article) {
		articleMapper.update(article);
		//return "수정되었습니다";
	}

	//프로젝트별 게시판 게시글 삭제
	@RequestMapping(value = "article/{id}", method = RequestMethod.DELETE)
	public void article_delete(@PathVariable("id") int id) {
		articleMapper.delete(id);
		//return "삭제되었습니다";
	}

	//프로젝트별 게시판 게시글 댓글 작성
	@RequestMapping(value = "comment/{id}", method = RequestMethod.POST)
	public void comment_submit(@RequestBody Comment comment) {
		//User user = UserService.getCurrentUser(); //현재 유저 정보 받아오기
		//article.add(user.getId());
		commentMapper.insertComment(comment);
		//return "등록되었습니다";
	}

	//프로젝트별 게시판 게시글 댓글 수정
	@RequestMapping(value = "comment/{id}", method = RequestMethod.PUT)
	public void comment_edit(@PathVariable("id") int id) {
		commentMapper.updateContext(id);
	}

	//프로젝트별 게시판 게시글 댓글 삭제
	@RequestMapping(value = "comment/{id}", method = RequestMethod.DELETE)
	public void comment_delete(@PathVariable("id") int id) {
		commentMapper.delete(id);
		//return "삭제되었습니다";
	}

	//게시글 작성자/제목/내용/제목+내용으로 검색
	@RequestMapping("search")
	public List<Article> search(@PathVariable("code") int code, @PathVariable("keyword") String keyword) {
		//작성자=0, 제목=1, 내용=2, 제목+내용=3
		List<Article> results = null;
		return results;
	}

}
