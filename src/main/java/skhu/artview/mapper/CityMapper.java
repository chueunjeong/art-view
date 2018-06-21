package skhu.artview.mapper;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import skhu.artview.dto.City;

@Mapper
public interface CityMapper {

	City findOne(int id);
	City findOneByName(String name);
	List<City> findAll();
	void insert(City city);
	void update(City city);
	void delete(int id);

}