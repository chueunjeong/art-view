package skhu.artview.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import skhu.artview.dto.Artwork;

@Mapper
public interface ArtworkMapper {

	Artwork findOne(int id);
	Artwork findOneByUser_id(String user_id);
	List <Artwork> findAll();
	int countAll(int user_id);
	void insert (Artwork artwork);
	void delete (int id);

}
