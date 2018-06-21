package skhu.artview.model;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import lombok.Data;

@Data
public class Pagination {

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

	public int getOb() {
		return ob;
	}

	public void setOb(int ob) {
		this.ob = ob;
	}
	
	public String getQueryString() {
		String url =null;
		try {
			String temp =(st==null) ? "": URLEncoder.encode(st,"UTF-8");
			url=String.format("bd=%d&pg=%d&sz=%d&ob=%d&sb=%d&st=%s", bd,pg,sz,ob,sb,temp);
		}catch(UnsupportedEncodingException e) {}
		return url;
	}
}
