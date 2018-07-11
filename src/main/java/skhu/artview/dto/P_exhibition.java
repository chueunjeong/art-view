package skhu.artview.dto;

/*전민선 :
 * 전시 기간과 지역을 확정하는 단계 후
 * 공간제공자에게 제공하는 전시기획서 내용입니다.

 * grouping_id는 project의 id이다.
 */
public class P_exhibition{

	int id;
	int project_id;//mypage등에서 연결된 정보 찾기 위한 정보
	int author_id; //작성자아이디 = user_id정보를 이름만 바꿔서 저장
	String title; //제목
	String content; //내용
	int file_id;
	String start_date; // 전시시작 기간 결정
	String end_date; //선호 전시종료 기간 결정
	int artfield_id;
	int district_id;//전시지역
	int grouping_id;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public int getProject_id() {
		return project_id;
	}
	public void setProject_id(int project_id) {
		this.project_id = project_id;
	}
	public int getAuthor_id() {
		return author_id;
	}
	public void setAuthor_id(int author_id) {
		this.author_id = author_id;
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
	public int getFile_id() {
		return file_id;
	}
	public void setFile_id(int file_id) {
		this.file_id = file_id;
	}
	public String getDay_start() {
		return day_start;
	}
	public void setDay_start(String day_start) {
		this.day_start = day_start;
	}
	public String getDay_end() {
		return day_end;
	}
	public void setDay_end(String day_end) {
		this.day_end = day_end;
	}
	public int getArtfield_id() {
		return artfield_id;
	}
	public void setArtfield_id(int artfield_id) {
		this.artfield_id = artfield_id;
	}
	public int getDistrict_id() {
		return district_id;
	}
	public void setDistrict_id(int district_id) {
		this.district_id = district_id;
	}
	public int getGrouping_id() {
		return grouping_id;
	}
	public void setGrouping_id(int grouping_id) {
		this.grouping_id = grouping_id;
	}



}