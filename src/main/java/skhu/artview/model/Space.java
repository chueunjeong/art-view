package skhu.artview.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Space {

	/*
	 * title : 검색 결과 업체, 기관명을 나타낸다. 
	 * link :검색 결과 업체, 기관의 상세 정보가 제공되는 네이버 페이지의 하이퍼텍스트 link를 나타낸다. 
	 * description 검색 결과 업체, 기관명에 대한 설명을 제공한다.
	 * telephone 검색 결과 업체, 기관명의 전화번호를 제공한다. 
	 * address string 검색 결과 업체, 기관명의 주소를 제공한다. 
	 * roadAddress string 검색 결과 업체, 기관명의 도로명 주소를 제공한다.
	 */
	String title;
	String link;
	String description;
	String selephone;
	String address;
	String roadAddress;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getSelephone() {
		return selephone;
	}
	public void setSelephone(String selephone) {
		this.selephone = selephone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getRoadAddress() {
		return roadAddress;
	}
	public void setRoadAddress(String roadAddress) {
		this.roadAddress = roadAddress;
	}

	
	
}
