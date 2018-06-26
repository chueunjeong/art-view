package skhu.artview.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

//import skhu.artview.model.Pagination;
import skhu.artview.dto.Article;

@Mapper
public interface ArticleMapper {
	//List<Article> findAllByBoard(Pagination pagination);
	Article findOne(int id);
	Article findOneWithComment(int id);
	List<Article> findAllWithComments();
	List<Article> findAll();
	List<Article> findByBoardId(int boardId);
	List<Article> findByUserId(int userId);
	List<Article> findByUserName(String keyword);
	List<Article> findByTitle(String keyword);
	List<Article> findByContent(String keyword);
	List<Article> findByTitleAndContent(String keyword);
	void insert(Article article);
	void update(Article article);
	void delete(int id);
}