package skhu.artview.controller;

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
import skhu.artview.service.ArticleService;
import skhu.artview.service.ProjectService;
import skhu.artview.service.UserService;

@RestController
@CrossOrigin
@RequestMapping("api")
public class AdminController {

	@Autowired ProjectService commuService;
	@Autowired ArticleService articleService;
	@Autowired ProjectMapper projectMapper;
	@Autowired UserService userService;
	@Autowired UserMapper userMapper;
	@Autowired ArticleMapper articleMapper;
	@Autowired CommentMapper commentMapper;

	/*작성자: 남하영*/

	//공지사항 게시판 게시글 작성(파일o)
	@RequestMapping(value = "notice/{id}", method = RequestMethod.POST)
	public String noticeSubmit(@RequestBody Article article, @RequestBody MultipartFile file) {
		return articleService.articleSubmit(article, file);
	}

	//공지사항 게시판 게시글 수정
	@RequestMapping(value = "notice/{id}", method = RequestMethod.PUT)
	public String noticeEdit(@RequestBody Article article) {
		return articleService.articleEdit(article);
	}

	//공지사항 게시판 게시글 삭제
	@RequestMapping(value = "notice/{id}", method = RequestMethod.DELETE)
	public String noticeDelete(@PathVariable("id") int id) {
		return articleService.articleDelete(id);
	}

}