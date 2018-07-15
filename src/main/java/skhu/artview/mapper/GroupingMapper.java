package skhu.artview.mapper;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import skhu.artview.dto.Grouping;

@Mapper
public interface GroupingMapper {

	Grouping findOne(int id);
	Grouping findOneByProjectId(int project_id);
	Grouping findOneByArtistId(int user_id);
	Grouping findOneByDistrictId(int district_id);
	List <Grouping> findAll();
	int countAll(int user_id);
	void insert (Grouping grouping);
	void delete (int id);

}