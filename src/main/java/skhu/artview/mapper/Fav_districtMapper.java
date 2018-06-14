package skhu.artview.mapper;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import skhu.artview.dto.Fav_district;

@Mapper
public interface Fav_districtMapper {

	Fav_district findOne(int id);
	List<Fav_district> findByUserId(int user_id);
	Fav_district findOneByDistrictId(int district_id);
	List<Fav_district> findAll();
	void insert(Fav_district fav_district);
	void update(Fav_district fav_district);
	void delete(int id);

}