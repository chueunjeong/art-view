package skhu.artview.model;

import java.util.List;

public class SearchSpace {
	List<skhu.artview.dto.Space> list;
	Option[] orderBy;
	Option[] searchBy;
	Option[] costBetween;
	
	int bd;      // boardId
    int pg = 1;  // 현재 페이지
    int sz = 15; // 페이지 당 레코드 수
    int recordCount;
    
    int sb;		//검색 기준
    String st;	//검색 문자열
    
    int cost;	//가격 범위 옵션 검색 기준
    int min;
    int max;
    
    int ob;		//정렬

	
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
	public int getBd() {
		return bd;
	}
	public void setBd(int bd) {
		this.bd = bd;
	}
	public int getPg() {
		return pg;
	}
	public void setPg(int pg) {
		this.pg = pg;
	}
	public int getSz() {
		return sz;
	}
	public void setSz(int sz) {
		this.sz = sz;
	}
	public int getRecordCount() {
		return recordCount;
	}
	public void setRecordCount(int recordCount) {
		this.recordCount = recordCount;
	}
	public int getSb() {
		return sb;
	}
	public void setSb(int sb) {
		this.sb = sb;
	}
	public String getSt() {
		return st;
	}
	public void setSt(String st) {
		this.st = st;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public int getMin() {
		return min;
	}
	public void setMin(int min) {
		this.min = min;
	}
	public int getMax() {
		return max;
	}
	public void setMax(int max) {
		this.max = max;
	}
	public int getOb() {
		return ob;
	}
	public void setOb(int ob) {
		this.ob = ob;
	}
	
	
	
	
	
}
