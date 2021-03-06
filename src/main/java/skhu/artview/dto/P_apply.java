//작성자: 남하영
//회원이 개설된 프로젝트의 팀원으로 신청했을 때, 신청서를 저장하는 테이블의 dto입니다.

package skhu.artview.dto;

public class P_apply {
	int id; //AI
	int user_id; //신청자id
	int project_id; //프로젝트id
	String content; //신청서 내용
	String date; //신청서 등록일자
	int state; //승인여부

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getProject_id() {
		return project_id;
	}

	public void setProject_id(int project_id) {
		this.project_id = project_id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

}