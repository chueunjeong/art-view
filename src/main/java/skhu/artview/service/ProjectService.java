package skhu.artview.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import skhu.artview.dto.Project;
import skhu.artview.mapper.P_applyMapper;

@Service
public class ProjectService {
	@Autowired P_applyMapper p_applyMapper;

	public int appli_cnt(int projectId) {
		return p_applyMapper.appli_cnt(projectId);
	}

	public int mem_cnt(int projectId) {
		return p_applyMapper.mem_cnt(projectId);
	}

	public Project projectMapping(Project project) {
		project.setAppli_cnt(this.appli_cnt(project.getId()));
		project.setMem_cnt(this.mem_cnt(project.getId()));
		return project;
	}
}

