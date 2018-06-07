package skhu.artview.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import skhu.artview.dto.Artist;

@Mapper
public interface ArtistMapper {
	
	Artist findOne(int id);
	Artist findOneByLoginId(String login_id);
	List <Artist> findAll();
	void insert (Artist user);
	void delete (int id);

}
