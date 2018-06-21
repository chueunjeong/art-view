package skhu.artview.mapper;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import skhu.artview.dto.Grouping;

@Mapper
public interface GroupingMapper {
	
	Grouping findOne(int id);
	Grouping findOneByProject_id(int project_id);
	Grouping findOneByArtist_id(int artist_id);
	Grouping findOneByDistrict_id(int district_id);
	List <Grouping> findAll();
	int countAll(int artist_id);
	void insert (Grouping grouping);
	void delete (int id);

}