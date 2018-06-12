package skhu.artview.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import skhu.artview.dto.Project;
import skhu.artview.mapper.P_applyMapper;
import skhu.artview.model.ProjectDetail;

@Service
public class ProjectService {
	@Autowired P_applyMapper p_applyMapper;

	public int appli_cnt(int projectId) {
		return p_applyMapper.appli_cnt(projectId);
	}

	public int mem_cnt(int projectId) {
		return p_applyMapper.mem_cnt(projectId);
	}

	public ProjectDetail projectMapping(Project project, ProjectDetail projectDetail) {
		projectDetail.setId(project.getId());
		projectDetail.setTitle(project.getTitle());
		projectDetail.setContent(project.getContent());
		projectDetail.setP_path(project.getP_path());
		projectDetail.setD_day(project.getD_day());
		projectDetail.setAppli_cnt(this.appli_cnt(project.getId()));
		projectDetail.setMem_cnt(this.mem_cnt(project.getId()));
		return projectDetail;
	}
}

