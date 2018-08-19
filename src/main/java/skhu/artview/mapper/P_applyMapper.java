package skhu.artview.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import skhu.artview.dto.P_apply;

@Mapper
public interface P_applyMapper {
	P_apply findOne(int id);
	List<P_apply> findAll();
	List<P_apply> findByProjectId(int project_id);
	List<P_apply> findByUserId(int user_id);
	List<P_apply> findMyApplicant(int project_id);
	List<P_apply> findMyMember(int project_id);
	void insert(P_apply p_apply);
	void updateState(int id);
	void delete(int id);
	int appli_cnt(int project_id);
	int mem_cnt(int project_id);
}