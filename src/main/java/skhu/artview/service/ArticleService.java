/*package skhu.artview.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import skhu.artview.dto.Article;
import skhu.artview.mapper.ArticleMapper;
import skhu.artview.model.Pagination;

@Service
public class ArticleService {
	@Autowired ArticleMapper articleMapper;

	public List<Article> findAll(Pagination pagination) {
        int count = articleMapper.count(pagination);
        pagination.setRecordCount(count);
        return articleMapper.findAllByBoard(pagination);
    }

}
*/