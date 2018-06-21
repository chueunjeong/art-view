package skhu.artview.service;
/*전민선 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import skhu.artview.dto.Contract;
import skhu.artview.dto.Grouping;
import skhu.artview.dto.P_exhibition;
import skhu.artview.dto.Project;
import skhu.artview.dto.Space;
import skhu.artview.mapper.ContractMapper;
import skhu.artview.mapper.GroupingMapper;
import skhu.artview.mapper.P_exhibitionMapper;
import skhu.artview.mapper.ProjectMapper;
import skhu.artview.mapper.SpaceMapper;

@Service
public class ContractService {

	@Autowired
	P_exhibitionMapper p_exhibitionMapper;

	@Autowired
	GroupingMapper groupingMapper;

	@Autowired
	ProjectMapper projectMapper;

	@Autowired
	ContractMapper contractMapper;

	@Autowired
	SpaceMapper spaceMapper;

	public P_exhibition bringProjectArticle(int project_id) {		//전시 기획서 작성페이지 [프로젝트 게시물 내용]으로 자동 채움 내용

		Project project = projectMapper.findOne(project_id);
		Grouping grouping = groupingMapper.findOneByProject_id(project_id);

		P_exhibition p_exhi = new P_exhibition();


		p_exhi.setAuthor_id(project.getAuthor_id());
		p_exhi.setTitle(project.getTitle());
		p_exhi.setContent(project.getContent());
		p_exhi.setFile_id(project.getFile_id());
		p_exhi.setDay_start(project.getFav_day_start());
		p_exhi.setDay_end(project.getFav_day_end());
		p_exhi.setArtfield_id(project.getArtfield_id());
		p_exhi.setGrouping_id(grouping.getId());


		return p_exhi;


	}


	public void saveP_exhibition(P_exhibition p_exhi) {			//전시 계획서 저장

		p_exhibitionMapper.insert(p_exhi);

	}


	public Contract bringP_exhibitionAndSpace(int project_id, int space_id) {	//공간 계약 작성 페이지 [전시계획서, 공간정보] 자동채움

		P_exhibition p_exhi = p_exhibitionMapper.findOneByProject_id(project_id);
		Space space = spaceMapper.findOne(space_id);

		Contract cont = new Contract();
		/*int id;
		int project_id;//mypage등에서 연결된 정보 찾기 위한 정보
		int pexhibition_id;
		int grouping_id;	//p_exhibition_id로 접근해서 채우기
		int space_id;
		int provider_id;
		long cost;*/

		cont.setProject_id(project_id);
		cont.setPexhibition_id(p_exhi.getId());
		cont.setGrouping_id(p_exhi.getGrouping_id());
		cont.setSpace_id(space_id);
		cont.setProvider_id(space.getProvider_id());
		cont.setCost(space.getCost());



		return cont;
	}


	public void saveContract(Contract cont) {			//공간 계약서 저장

		contractMapper.insert(cont);

	}








}


