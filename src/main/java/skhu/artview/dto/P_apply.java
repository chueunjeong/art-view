//작성자: 남하영
//회원이 개설된 프로젝트의 팀원으로 신청했을 때, 신청서를 저장하는 테이블의 dto입니다.

package skhu.artview.dto;

public class P_apply {
	int id; //AI
	int userId; //신청자id
	int projectId; //프로젝트id
	String content; //신청서 내용
	String date; //신청서 등록일자
	boolean state; //승인여부

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
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

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}

}