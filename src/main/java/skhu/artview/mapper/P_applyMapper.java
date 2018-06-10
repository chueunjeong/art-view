package skhu.artview.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import skhu.artview.dto.P_apply;

@Mapper
public interface P_applyMapper {
	P_apply findOne(int id);
	List<P_apply> findAll();
	List<P_apply> findByProjectId(int projectId);
	List<P_apply> findByUserId(int userId);
	List<P_apply> findMyApplicant(int projectId);
	List<P_apply> findMyMember(int projectId);
	void insert(P_apply p_apply);
	void updateState(int id);
	void delete(int id);
	int appli_cnt(int projectId);
	int mem_cnt(int projectId);
}