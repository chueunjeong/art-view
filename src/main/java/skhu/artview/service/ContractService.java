package skhu.artview.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import skhu.artview.dto.Grouping;
import skhu.artview.dto.P_exhibition;
import skhu.artview.dto.Project;
import skhu.artview.mapper.GroupingMapper;
import skhu.artview.mapper.P_applyMapper;
import skhu.artview.mapper.P_exhibitionMapper;
import skhu.artview.mapper.ProjectMapper;

@Service
public class ContractService {

	@Autowired
	P_exhibitionMapper p_exhibitionMapper;
	
	@Autowired
	GroupingMapper groupingMapper;
	
	@Autowired
	ProjectMapper projectMapper;
	
	public P_exhibition makeExhibition(int project_id) {
		Grouping grouping = groupingMapper.findOneByProject_id(project_id);
		Project project = projectMapper.findOne(project_id);
		
		P_exhibition p_exhi = new P_exhibition(Project project);
		p_exhi.setGrouping_id(grouping.getId());
				
		return p_exhibition;
	
	}
	
	
	
	
	
	
}


