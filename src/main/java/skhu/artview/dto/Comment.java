//게시글에 달린 코멘트와 공간 리스트에 달린 평가를 구분해서 뿌려주어야 함

package skhu.artview.dto;

public class Comment {

	int id;
	int article_id;
	int space_id;
	int user_id;
	String content;
	int rate;
	String date;
	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getArticle_id() {
		return article_id;
	}

	public void setArticle_id(int article_id) {
		this.article_id = article_id;
	}

	public int getSpace_id() {
		return space_id;
	}

	public void setSpace_id(int space_id) {
		this.space_id = space_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}


}