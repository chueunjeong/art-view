package skhu.artview.dto;

/*전민선 : 
 * 전시 기간과 지역을 확정하는 단계
 * grouping_id는 project의 id이다.
 */
public class P_exhibition{
	
	int id;
	int author_id; //작성자아이디
	String title; //제목
	String content; //내용
	String day_start; // 전시시작 기간 결정
	String day_end; //선호 전시종료 기간 결정
	int artfield_id;
	int district_id;//전시지역
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	
	
	
}