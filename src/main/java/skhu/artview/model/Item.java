package skhu.artview.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown =true)
public class Item {
	private String DP_SEQ;
	private String title;	//전시명
	private String subtitle;//전시부제
	private String image;	//대표이미지
	private String price;	//관람료(원)
	
	private String DP_PLACE;//전시 장소
	private String DP_LAN;	//언어 구분
	private String DP_START;//전시시작시간
	private String DP_END; //전시끝기간
	private String DP_TYPE; //전시 장르
	private String DP_HOMEPAGE; // 홈페이지URL
	private String DP_EVENT; //부대행사
	private String DP_SPONSOR; //주최및후원
	private String DP_VIEWTIME; //전시(관람)시간
	private String DP_ART_PART; // 전시 부문
	private int DP_APR_CNT; //작품수
	private String DP_ARTIST; //출품작가
	private String DP_DOCENT; //도슨트
	private String DP_VIEWPOINT; //관람포인트
	private String DP_MASTER; //담당자
	private String DP_PHONE; //문의전화
	private String DP_INFO; //전시 설명
	

	public String getDP_SEQ() {
		return DP_SEQ;
	}
	public void setDP_SEQ(String dP_SEQ) {
		DP_SEQ = dP_SEQ;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	


	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getSubtitle() {
		return subtitle;
	}
	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}
	
	public String getDP_PLACE() {
		return DP_PLACE;
	}
	public void setDP_PLACE(String dP_PLACE) {
		DP_PLACE = dP_PLACE;
	}
	public String getDP_LAN() {
		return DP_LAN;
	}
	public void setDP_LAN(String dP_LAN) {
		DP_LAN = dP_LAN;
	}
	public String getDP_START() {
		return DP_START;
	}
	public void setDP_START(String dP_START) {
		DP_START = dP_START;
	}
	public String getDP_END() {
		return DP_END;
	}
	public void setDP_END(String dP_END) {
		DP_END = dP_END;
	}
	public String getDP_TYPE() {
		return DP_TYPE;
	}
	public void setDP_TYPE(String dP_TYPE) {
		DP_TYPE = dP_TYPE;
	}
	public String getDP_HOMEPAGE() {
		return DP_HOMEPAGE;
	}
	public void setDP_HOMEPAGE(String dP_HOMEPAGE) {
		DP_HOMEPAGE = dP_HOMEPAGE;
	}
	public String getDP_EVENT() {
		return DP_EVENT;
	}
	public void setDP_EVENT(String dP_EVENT) {
		DP_EVENT = dP_EVENT;
	}
	public String getDP_SPONSOR() {
		return DP_SPONSOR;
	}
	public void setDP_SPONSOR(String dP_SPONSOR) {
		DP_SPONSOR = dP_SPONSOR;
	}
	public String getDP_VIEWTIME() {
		return DP_VIEWTIME;
	}
	public void setDP_VIEWTIME(String dP_VIEWTIME) {
		DP_VIEWTIME = dP_VIEWTIME;
	}
	public String getDP_ART_PART() {
		return DP_ART_PART;
	}
	public void setDP_ART_PART(String dP_ART_PART) {
		DP_ART_PART = dP_ART_PART;
	}
	public int getDP_APR_CNT() {
		return DP_APR_CNT;
	}
	public void setDP_APR_CNT(int dP_APR_CNT) {
		DP_APR_CNT = dP_APR_CNT;
	}
	public String getDP_ARTIST() {
		return DP_ARTIST;
	}
	public void setDP_ARTIST(String dP_ARTIST) {
		DP_ARTIST = dP_ARTIST;
	}
	public String getDP_DOCENT() {
		return DP_DOCENT;
	}
	public void setDP_DOCENT(String dP_DOCENT) {
		DP_DOCENT = dP_DOCENT;
	}
	public String getDP_VIEWPOINT() {
		return DP_VIEWPOINT;
	}
	public void setDP_VIEWPOINT(String dP_VIEWPOINT) {
		DP_VIEWPOINT = dP_VIEWPOINT;
	}
	public String getDP_MASTER() {
		return DP_MASTER;
	}
	public void setDP_MASTER(String dP_MASTER) {
		DP_MASTER = dP_MASTER;
	}
	public String getDP_PHONE() {
		return DP_PHONE;
	}
	public void setDP_PHONE(String dP_PHONE) {
		DP_PHONE = dP_PHONE;
	}
	public String getDP_INFO() {
		return DP_INFO;
	}
	public void setDP_INFO(String dP_INFO) {
		DP_INFO = dP_INFO;
	}
	@Override
	public String toString() {
		return "Item{" +
				"title= '" + title +'\'' +
				
				",image = '" + image +'\'' +
				",price =" +price +
				'}';

	}
}
