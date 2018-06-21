package skhu.artview.model;

/*
 * 전민선 : 
 * 공유문서함 > ART-VIEW > 설계 > 20180517_234750.jpg 
 * UI 디자인 설계 항목 참조
 * 
 * 1.프로필사진과 소개글
 * 2.아티스트 정보 요약 (아이디, 지역, 등록작품수, 완료전시수, 회원타입)
 * 3.등록 작품 개수 그래프
 * 4.프로젝트 정보 요약 (프로젝트명, 현황)
 * 5.사이드바에 정보수정, 포트폴리오 조회(작품정보,전시정보),대관신청현광, 나의 프로젝트, 평가내역, 즐겨찾기 목록 배치
 * 
 * */
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.mysql.jdbc.Blob;

import skhu.artview.dto.Comment;
import skhu.artview.dto.Project;
import skhu.artview.dto.User;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MypageSummary {
	/* 전민선 */
	// 1.프로필 소개
	private int picture_id;
	private String introMessage;

	// 2.아티스트 정보요약
	private String login_id;
	private String district_name;
	private String district_city_name;
	private int submit_count;// 등록된 작품수
	private int finish_Exhibition_count;// 완료된 전시회

	// 3.월 별 그래프
	private int[] submitGraph;

	// 4. 프로젝트 정보 요약
	private String project_name;
	private String status; // 진행상황


	public int getPicture_id() {
		return picture_id;
	}

	public void setPicture_id(int picture_id) {
		this.picture_id = picture_id;
	}

	public String getIntroMessage() {
		return introMessage;
	}

	public void setIntroMessage(String introMessage) {
		this.introMessage = introMessage;
	}

	public String getLogin_id() {
		return login_id;
	}

	public void setLogin_id(String login_id) {
		this.login_id = login_id;
	}

	public String getDistrict_name() {
		return district_name;
	}

	public void setDistrict_name(String district_name) {
		this.district_name = district_name;
	}

	public String getDistrict_city_name() {
		return district_city_name;
	}

	public void setDistrict_city_name(String district_city_name) {
		this.district_city_name = district_city_name;
	}

	public int getSubmit_count() {
		return submit_count;
	}

	public void setSubmit_count(int submit_count) {
		this.submit_count = submit_count;
	}

	public int getFinish_Exhibition_count() {
		return finish_Exhibition_count;
	}

	public void setFinish_Exhibition_count(int finish_Exhibition_count) {
		this.finish_Exhibition_count = finish_Exhibition_count;
	}

	public int[] getSubmitGraph() {
		return submitGraph;
	}

	public void setSubmitGraph(int[] submitGraph) {
		this.submitGraph = submitGraph;
	}

	public String getProject_name() {
		return project_name;
	}

	public void setProject_name(String project_name) {
		this.project_name = project_name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
