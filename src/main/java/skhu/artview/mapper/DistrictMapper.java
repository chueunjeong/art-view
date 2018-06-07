package skhu.artview.mapper;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import skhu.artview.dto.District;

@Mapper
public interface DistrictMapper {

	District findOne(int id);
	District findOneByName(String name);
	List <District> findAll();
	void insert (District district);
	void update (District district);
	void delete (int id);
}
