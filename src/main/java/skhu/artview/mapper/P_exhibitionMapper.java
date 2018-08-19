package skhu.artview.mapper;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import skhu.artview.dto.P_exhibition;

@Mapper
public interface P_exhibitionMapper {
	
	P_exhibition findOne(int id);
	P_exhibition findOneByProjectId(int project_id);
	P_exhibition findOneByArtistId(int artist_id);
	P_exhibition findOneByGroupingId(int grouping_id);
	List <P_exhibition> findAll();
	void insert (P_exhibition p_exhibition);
	void delete (int id);

}