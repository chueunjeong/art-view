package skhu.artview.mapper;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import skhu.artview.dto.Facility;

@Mapper
public interface FacilityMapper {

	Facility findOne(int id);
	List<Facility> findByType(String type);
	List<Facility> findAll();
	void insert(Facility facility);
	void update(Facility facility);
	void delete(int id);

}