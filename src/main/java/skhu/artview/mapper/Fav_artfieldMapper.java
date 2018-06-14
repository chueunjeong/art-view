package skhu.artview.mapper;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import skhu.artview.dto.Fav_artfield;

@Mapper
public interface Fav_artfieldMapper {

	Fav_artfield findOne(int id);
	List<Fav_artfield> findByUserId(int user_id);
	List<Fav_artfield> findByArtfieldId(int artfield_id);
	List<Fav_artfield> findAll();
	void insert(Fav_artfield fav_artfield);
	void update(Fav_artfield fav_artfield);
	void delete(int id);

}