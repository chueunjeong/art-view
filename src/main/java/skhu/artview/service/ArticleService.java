package skhu.artview.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import skhu.artview.dto.Article;
import skhu.artview.dto.Comment;
import skhu.artview.mapper.ArticleMapper;
import skhu.artview.mapper.CommentMapper;
import skhu.artview.mapper.UserMapper;
//import skhu.artview.model.Pagination;

@Service
public class ArticleService {
	@Autowired ArticleMapper articleMapper;
	@Autowired CommentMapper commentMapper;
	@Autowired UserMapper userMapper;

	/*public List<Article> findAll(Pagination pagination) {
        int count = articleMapper.count(pagination);
        pagination.setRecordCount(count);
        return articleMapper.findAllByBoard(pagination);
    }*/

	public Article articleMapping(Article article) {
		List<Comment> comments = commentMapper.findByArticleId(article.getId());
		article.setComment(comments);
		article.setAuthor(userMapper.findOne(article.getUserId()));
		//코멘트 list를 article 객체에 추가했는데 이 방법이 맞나 모르겠다..
		return article;
	}

}