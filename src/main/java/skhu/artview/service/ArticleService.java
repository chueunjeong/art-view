package skhu.artview.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import skhu.artview.dto.Article;
import skhu.artview.dto.Comment;
import skhu.artview.dto.User;
import skhu.artview.mapper.ArticleMapper;
import skhu.artview.mapper.CommentMapper;
import skhu.artview.mapper.UserMapper;
import skhu.artview.model.ArticleDetail;
import skhu.artview.model.CommentDetail;

@Service
public class ArticleService {
	@Autowired ArticleMapper articleMapper;
	@Autowired CommentMapper commentMapper;
	@Autowired UserMapper userMapper;
	@Autowired S3Service s3Service;
	@Autowired CommentService commentService;

	/*public List<Article> findAll(Pagination pagination) {
        int count = articleMapper.count(pagination);
        pagination.setRecordCount(count);
        return articleMapper.findAllByBoard(pagination);
    }*/

	public ArticleDetail articleMapping(Article article) {

		ArticleDetail articleDetail = new ArticleDetail();
		articleDetail.setId(article.getId());
		articleDetail.setBoard_id(article.getBoard_id());
		articleDetail.setUser_id(article.getUser_id());
		articleDetail.setTitle(article.getTitle());
		articleDetail.setContent(article.getContent());
		articleDetail.setHits(article.getHits());
		articleDetail.setDate(article.getDate());
		//articleDetail.setFile_id(article.getFile_id());

		List<Comment> comments = commentMapper.findByArticleId(article.getId());
		List<CommentDetail> dcomments = commentService.makeList(comments);
		articleDetail.setComment(dcomments);
		User user = userMapper.findOne(article.getUser_id());
		articleDetail.setAuthor(userMapper.findOneByLoginId(user.getLogin_id()));
		return articleDetail;
	}

	//ArticleList를ArticleDetailList로 바꿔주는 메서드
	public List<ArticleDetail> makeList(List<Article> list) {
		List<ArticleDetail> newList = new ArrayList<ArticleDetail>();

		for (int i = 0; i < list.size(); i++) {
			newList.add(i,
			this.articleMapping(list.get(i))
			);
		}

		return newList;
	}

	//작성자=0, 제목=1, 내용=2, 제목+내용=3 검색
	public List<ArticleDetail> search(int code, String keyword) {
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

	public List<ArticleDetail> articles(int board_id) {
		List<Article> articles = articleMapper.findByBoardId(board_id);
		return this.makeList(articles);
	}

	public ArticleDetail articleDetail(int id) {
		Article article = articleMapper.findOne(id);
		article.setHits(article.getHits()+1);
		return this.articleMapping(article);
	}

	//파일 없을 경우
	public String articleSubmit(Article article) {
		User user = null; //현재 유저 정보 받아오기
		article.setUser_id(user.getId());
		articleMapper.insert(article); //insert mapper만들어야 함
		return "등록되었습니다";
	}

	public String articleSubmit(Article article, MultipartFile file) {

		if(file.isEmpty())
			return this.articleSubmit(article);

		int fileId = s3Service.fileUpload(file);
		if(fileId == 000)
			return "실패하였습니다";
		//article.setFile_id(fileId);

		User user = null; //현재 유저 정보 받아오기
		article.setUser_id(user.getId());
		articleMapper.insert(article); //insert mapper만들어야 함
		return "등록되었습니다";
	}

	public String articleEdit(Article article) {
		articleMapper.update(article);
		return "수정되었습니다";
	}

	public String articleDelete(int id) {
		articleMapper.delete(id);
		return "삭제되었습니다";
	}

}