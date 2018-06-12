package skhu.artview.dto;

public class Contract {
	int id;
	int project_id;//mypage등에서 연결된 정보 찾기 위한 정보
	int pexhibition_id;
	int grouping_id;	//p_exhibition_id로 접근해서 채우기
	int space_id;
	int provider_id;
	long cost;
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
	public int getGrouping_id() {
		return grouping_id;
	}
	public void setGrouping_id(int grouping_id) {
		this.grouping_id = grouping_id;
	}
	public int getPexhibition_id() {
		return pexhibition_id;
	}
	public void setPexhibition_id(int pexhibition_id) {
		this.pexhibition_id = pexhibition_id;
	}
	public int getSpace_id() {
		return space_id;
	}
	public void setSpace_id(int space_id) {
		this.space_id = space_id;
	}
	public int getProvider_id() {
		return provider_id;
	}
	public void setProvider_id(int provider_id) {
		this.provider_id = provider_id;
	}
	public long getCost() {
		return cost;
	}
	public void setCost(long cost) {
		this.cost = cost;
	}
	
	
	
}
