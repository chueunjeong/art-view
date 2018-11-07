  package skhu.artview.model;
/*남하영, 전민선 :
 * Project 게시글을 쓸 때는 dto.project을 사용하고
 * Project 상세페이지를 볼 때는 model.projectDetail을 사용합니다.
 *
 */
import java.util.List;

import skhu.artview.dto.User;

public class ProjectDetail {

	int id;
	int author_id; //작성자아이디
	String title; //제목
	String content; //내용
	int file_id; //사진 id 저장
	//String v_path; //동영상 url 저장
	String dead_line; //마감 기한
	int artfield_id;
	String fav_start_date; //선호 전시시작 기간
	String fav_end_date; //선호 전시종료 기간
	int district_id;//전시지역

	User author; //작성자
	List<User> applicants; //신청자 리스트
	List<User> members; //멤버 리스트
	int appli_cnt; //신청자 수
	int mem_cnt; //멤버 수

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

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public List<User> getApplicants() {
		return applicants;
	}

	public void setApplicants(List<User> applicants) {
		this.applicants = applicants;
	}

	public List<User> getMembers() {
		return members;
	}

	public void setMembers(List<User> members) {
		this.members = members;
	}

	public int getAppli_cnt() {
		return appli_cnt;
	}

	public void setAppli_cnt(int appli_cnt) {
		this.appli_cnt = appli_cnt;
	}

	public int getMem_cnt() {
		return mem_cnt;
	}

	public void setMem_cnt(int mem_cnt) {
		this.mem_cnt = mem_cnt;
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

	public String getDead_line() {
		return dead_line;
	}

	public void setDead_line(String dead_line) {
		this.dead_line = dead_line;
	}

	public String getFav_start_date() {
		return fav_start_date;
	}

	public void setFav_start_date(String fav_start_date) {
		this.fav_start_date = fav_start_date;
	}

	public String getFav_end_date() {
		return fav_end_date;
	}

	public void setFav_end_date(String fav_end_date) {
		this.fav_end_date = fav_end_date;
	}

/*	public String getV_path() {
		return v_path;
	}

	public void setV_path(String v_path) {
		this.v_path = v_path;
	} */
}