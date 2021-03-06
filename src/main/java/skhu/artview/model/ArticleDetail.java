package skhu.artview.model;

import java.util.List;

import skhu.artview.dto.User;

public class ArticleDetail {

	int id;
	int board_id; //게시글이 소속된 게시판(커뮤니티 id)
	int user_id;
	int boardId; //게시글이 소속된 게시판(커뮤니티 id)
	String title;
	String content;
	int hits;
	String date;
	int file_id;

	List<CommentDetail> comment;
	User author; //작성자 객체


	public List<CommentDetail> getComment() {
		return comment;
	}

	public void setComment(List<CommentDetail> comment) {
		this.comment = comment;
	}

	public int getFile_id() {
		return file_id;
	}

	public void setFile_id(int file_id) {
		this.file_id = file_id;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBoard_id() {
		return board_id;
	}

	public void setBoard_id(int board_id) {
		this.board_id = board_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getHits() {
		return hits;
	}

	public void setHits(int hits) {
		this.hits = hits;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}