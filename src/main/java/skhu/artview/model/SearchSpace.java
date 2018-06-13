package skhu.artview.model;

import java.util.List;

public class SearchSpace {
	List<skhu.artview.dto.Space> list;
	Option[] orderBy;
	Option[] searchBy;
	Option[] costBetween;
	
	
	public List<skhu.artview.dto.Space> getList() {
		return list;
	}
	public void setList(List<skhu.artview.dto.Space> list) {
		this.list = list;
	}
	public Option[] getOrderBy() {
		return orderBy;
	}
	public void setOrderBy(Option[] orderBy) {
		this.orderBy = orderBy;
	}
	public Option[] getSearchBy() {
		return searchBy;
	}
	public void setSearchBy(Option[] searchBy) {
		this.searchBy = searchBy;
	}
	public Option[] getCostBetween() {
		return costBetween;
	}
	public void setCostBetween(Option[] costBetween) {
		this.costBetween = costBetween;
	}
	
	
	
	
	
}
