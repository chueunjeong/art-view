package skhu.artview.service;

/*전민선 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import skhu.artview.dto.Artist;
import skhu.artview.dto.District;
import skhu.artview.mapper.ArtistMapper;
import skhu.artview.mapper.ArtworkMapper;
import skhu.artview.mapper.DistrictMapper;
import skhu.artview.mapper.ExhibitionMapper;
import skhu.artview.model.MypageSummary;

@Service
public class MypageService {

	@Autowired
	ArtistMapper artistMapper;
	@Autowired
	DistrictMapper districtMapper;
	@Autowired
	ArtworkMapper artworkMapper;
	@Autowired
	ExhibitionMapper exhibitionMapper;

	//마이페이지 첫 화면 구성 속성들 조회해오는 메소드
	public MypageSummary bringMypageSummary(Authentication auth) {
		MypageSummary summary = new MypageSummary();

		String login_id = (String) auth.getPrincipal();
		Artist artist = artistMapper.findOneByLoginId(login_id);
		
		int picture_id = artist.getFile_id();

		String introMessage = artist.getIntro_message();
		
		int artist_id = artist.getId();
		District district = districtMapper.findOne(artist.getFav_district_id());

		String district_name = district.getName();
		String district_city_name = district.getCity_name();

		int submit_count = artworkMapper.countAll(artist_id);
		int finish_Exhibition_count = exhibitionMapper.countAll(artist_id);
		
		
		//1.프로필 정보
		summary.setPicture_id(picture_id);
		summary.setIntroMessage(introMessage);
		
		//2.artist 정보 요약
		summary.setLogin_id(login_id);
		summary.setDistrict_name(district_name);
		summary.setDistrict_city_name(district_city_name);
		summary.setSubmit_count(submit_count);
		summary.setFinish_Exhibition_count(finish_Exhibition_count);

		//3.월 별 그래프
		
		
		
		
		return summary;
	}

}
