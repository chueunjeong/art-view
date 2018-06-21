package skhu.artview.mapper;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import skhu.artview.dto.P_exhibition;

@Mapper
public interface P_exhibitionMapper {
	
	P_exhibition findOne(int id);
	P_exhibition findOneByProject_id(int project_id);
	P_exhibition findOneByArtist_id(int artist_id);
	P_exhibition findOneByGrouping_id(int grouping_id);
	List <P_exhibition> findAll();
	void insert (P_exhibition p_exhibition);
	void delete (int id);

}