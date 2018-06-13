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

	public MypageSummary bringMypageSummary(Authentication auth) {
		MypageSummary summary = new MypageSummary();

		String login_id = (String) auth.getPrincipal();
		Artist artist = artistMapper.findOneByLoginId(login_id);
		int artist_id = artist.getId();
		District district = districtMapper.findOne(artist.getFav_district_id());

		String district_name = district.getName();
		String district_city_name = district.getCity_name();

		int submit_count = artworkMapper.countAll(artist_id);
		int finish_Exhibition_count = exhibitionMapper.countAll(artist_id);

		summary.setLogin_id(login_id);
		summary.setDistrict_name(district_name);
		summary.setDistrict_city_name(district_city_name);
		summary.setSubmit_count(submit_count);
		summary.setFinish_Exhibition_count(finish_Exhibition_count);

		return summary;
	}

}
