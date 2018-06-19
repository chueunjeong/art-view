package skhu.artview.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import skhu.artview.dto.Article;
import skhu.artview.dto.Comment;
import skhu.artview.mapper.ArticleMapper;
import skhu.artview.mapper.CommentMapper;
import skhu.artview.mapper.UserMapper;

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

	//ArticleList를 MappingList로 바꿔주는 메서드
	public List<Article> makeList(List<Article> list) {
		List<Article> newList = new ArrayList<Article>();

		for (int i = 0; i < list.size(); i++) {
			newList.add(i,
			this.articleMapping(list.get(i))
			);
		}

		return newList;
	}

	//작성자=0, 제목=1, 내용=2, 제목+내용=3 검색
	public List<Article> search(int code, String keyword) {
		switch(code) {
		case 0:
			return this.makeList(articleMapper.findByUserName(keyword));
		case 1:
			return this.makeList(articleMapper.findByTitle(keyword));
		case 2:
			return this.makeList(articleMapper.findByContent(keyword));
		case 3:
			return this.makeList(articleMapper.findByTitleAndContent(keyword));
		default:
			return null;
		}
	}

}