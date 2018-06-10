package skhu.artview.mapper;
import java.sql.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import skhu.artview.dto.Space;

@Mapper
public interface SpaceMapper {
	Space findOne(int id);
	List<Space> findByCity_id(int city_id );
    List<Space> findByProvider_id(int provider_id);
    List<Space> findByCost(int cost);
   
	List<Space> findAll();
	
	void updateCity_id(int id);
	void updateProvider_id(int id);
	void updateCost(int id);
	void updateUnavailable(Date date);
	void updateAddress(String address);
	void delete(int id);
	void insert(Space space);
}
