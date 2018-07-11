package skhu.artview.dto;

public class Project {

	int id;
	int author_id; //작성자아이디
	String title; //제목
	String content; //내용
	int file_id; //사진 id 저장
	String video_id; //동영상 url 저장
	String dead_line; //마감 기한
	String fav_day_start; //선호 전시시작 기간
	String fav_day_end; //선호 전시종료 기간
	int artfield_id;
	int district_id;//전시지역

	public int getDistrict_id() {
		return district_id;
	}

	public void setDistrict_id(int district_id) {
		this.district_id = district_id;
	}

	public int getAuthor_id() {
		return author_id;
	}

	public void setAuthor_id(int author_id) {
		this.author_id = author_id;
	}


/*
	public String getVideo_id() {
		return video_id;
	}

	public void setVideo_id(String video_id) {
		this.video_id = video_id;
	}
*/
	public String getDead_line() {
		return dead_line;
	}

	public void setDead_line(String dead_line) {
		this.dead_line = dead_line;
	}

	public String getFav_day_start() {
		return fav_day_start;
	}

	public void setFav_day_start(String fav_day_start) {
		this.fav_day_start = fav_day_start;
	}

	public String getFav_day_end() {
		return fav_day_end;
	}

	public void setFav_day_end(String fav_day_end) {
		this.fav_day_end = fav_day_end;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getFile_id() {
		return file_id;
	}

	public void setFile_id(int file_id) {
		this.file_id = file_id;
	}
/*

*/
	
	public int getArtfield_id() {
		return artfield_id;
	}

	public void setArtfield_id(int artfield_id) {
		this.artfield_id = artfield_id;
	}

}