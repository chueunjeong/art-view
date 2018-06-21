package skhu.artview.dto;

public class QnA {

	int id;
	int boardId;
	String userId;
	String title;
	String content;
	String type;		//질문, 답변 구분
	
	FileDTO file;
	User username;
	int hits;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public int getBoardId() {
		return boardId;
	}
	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public FileDTO getFile() {
		return file;
	}
	public void setFile(FileDTO file) {
		this.file = file;
	}
	
	public User getUsername() {
		return username;
	}
	public void setUsername(User username) {
		this.username = username;
	}
	public int getHits() {
		return hits;
	}
	public void setHits(int hits) {
		this.hits = hits;
	}
	
	
}

