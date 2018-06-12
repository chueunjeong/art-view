package skhu.artview.dto;

public class Project {

	int id;
	int user_id; //작성자아이디
	String title; //제목
	String content; //내용
	String p_path; //사진 url 저장
	String v_path; //동영상 url 저장
	String d_day; //마감 기한
	String fav_day_start; //선호 전시시작 기간
	String fav_day_end; //선호 전시종료 기간
	int district_id;//전시지역

	public int getDistrict_id() {
		return district_id;
	}

	public void setDistrict_id(int district_id) {
		this.district_id = district_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getD_day() {
		return d_day;
	}

	public void setD_day(String d_day) {
		this.d_day = d_day;
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

	public String getP_path() {
		return p_path;
	}

	public void setP_path(String p_path) {
		this.p_path = p_path;
	}

	public String getV_path() {
		return v_path;
	}

	public void setV_path(String v_path) {
		this.v_path = v_path;
	}
}