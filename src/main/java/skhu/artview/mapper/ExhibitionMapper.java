package skhu.artview.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import skhu.artview.dto.Exhibition;

@Mapper
public interface ExhibitionMapper {
	
	Exhibition findOne(int id);
	Exhibition findOneByArtist_id(int artist_id);
	List <Exhibition> findAll();
	int countAll(int artist_id);
	void insert (Exhibition artwork);
	void delete (int id);

}
