package skhu.artview.mapper;

import java.sql.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import skhu.artview.dto.Space;
import skhu.artview.model.Option;
import skhu.artview.model.Pagination;
import skhu.artview.model.SearchSpace;

@Mapper
public interface SpaceMapper {

	Option[] searchBy = { new Option(0, "검색없음"), new Option(1, "기관명"),
							new Option(2, "지역명") };
	Option[] costBetween = { new Option(0,"가격 범위 없음"), new Option(1,"가격 범위 설정")};
	Option[] orderBy = { new Option(0, "기관명 오름자순"), new Option(1, "가격 오름차순"), new Option(2, "가격 내림차순") };


	Space findOne(int id);

	List<Space> findByCity_id(int city_id);

	List<Space> findByProvider_id(int provider_id);

	List<Space> findByCost(int cost);

	List<Space> findAll(SearchSpace pagination);
	
	int count(SearchSpace pagination);
	
	void updateCity_id(int id);

	void updateProvider_id(int id);

	void updateCost(int id);

	void updateUnavailable(Date date);

	void updateAddress(String address);

	void delete(int id);

	void insert(Space space);
}
