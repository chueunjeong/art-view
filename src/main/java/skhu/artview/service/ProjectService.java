package skhu.artview.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import skhu.artview.dto.Artfield;
import skhu.artview.dto.District;
import skhu.artview.dto.P_apply;
import skhu.artview.dto.Project;
import skhu.artview.dto.User;
import skhu.artview.mapper.ArtfieldMapper;
import skhu.artview.mapper.DistrictMapper;
import skhu.artview.mapper.FileMapper;
import skhu.artview.mapper.P_applyMapper;
import skhu.artview.mapper.ProjectMapper;
import skhu.artview.mapper.UserMapper;
import skhu.artview.model.ProjectDetail;

@Service
public class ProjectService {

	@Autowired P_applyMapper p_applyMapper;
	@Autowired ProjectMapper projectMapper;
	@Autowired FileMapper fileMapper;
	@Autowired UserMapper userMapper;
	@Autowired ArtfieldMapper artfieldMapper;
	@Autowired DistrictMapper districtMapper;
	@Autowired S3Service s3Service;

	S3Uploader s3Uploader = new S3Uploader();

	public int appli_cnt(int projectId) {
		return p_applyMapper.appli_cnt(projectId);
	}

	public int mem_cnt(int projectId) {
		return p_applyMapper.mem_cnt(projectId);
	}

	public ProjectDetail projectMapping(Project project) {

		ProjectDetail projectDetail = new ProjectDetail();
		projectDetail.setId(project.getId());
		projectDetail.setAuthor_id(project.getAuthor_id());
		projectDetail.setTitle(project.getTitle());
		projectDetail.setContent(project.getContent());
		projectDetail.setFile_id(project.getFile_id());
		projectDetail.setD_day(project.getDead_line());
		projectDetail.setArtfield_id(project.getArtfield_id());
		projectDetail.setFav_day_start(project.getFav_start_date());
		projectDetail.setFav_day_end(project.getFav_end_date());
		projectDetail.setDistrict_id(project.getDistrict_id());

		projectDetail.setAuthor(userMapper.findOne(project.getAuthor_id()));
		projectDetail.setApplicants(userMapper.findMyApplicant(project.getId()));
		projectDetail.setMembers(userMapper.findMyMember(project.getId()));
		projectDetail.setAppli_cnt(this.appli_cnt(project.getId()));
		projectDetail.setMem_cnt(this.mem_cnt(project.getId()));
		return projectDetail;

	}

	//projectList를 projectDetailList로 바꿔주는 메서드
	public List<ProjectDetail> makeList(List<Project> p_list) {
		List<ProjectDetail> list = new ArrayList<ProjectDetail>();

		for (int i = 0; i < p_list.size(); i++) {
			list.add(i,
			this.projectMapping(p_list.get(i))
			);
		}

		return list;
	}

	public String projectSubmit(Project project, MultipartFile file) {

		int fileId = s3Service.fileUpload(file);
		if(fileId == 000)
			return "실패하였습니다";
		project.setFile_id(fileId);

		User user = null; //현재 유저 정보 받아오기
		project.setAuthor_id(user.getId());
		projectMapper.insert(project); //insert mapper만들어야 함
		return "등록되었습니다";
	}

	public String projectSubmitTest(Project project) {
		projectMapper.insertTest(project);
		return "등록되었습니다";
	}

	//작성자=0, 제목=1, 내용=2, 제목+내용=3 검색
	public List<ProjectDetail> search(int code, String keyword) {
		switch(code) {
		case 0:
			return this.makeList(projectMapper.findByUserName(keyword));
		case 1:
			return this.makeList(projectMapper.findByTitle(keyword));
		case 2:
			return this.makeList(projectMapper.findByContent(keyword));
		case 3:
			return this.makeList(projectMapper.findByTitleAndContent(keyword));
		default:
			return null;
		}
	}

	public ProjectDetail projectDetail(int id) {
		Project project = projectMapper.findOne(id);
		return this.projectMapping(project);
	}

	public String projectDelete(int id) {
		projectMapper.delete(id);
		return "삭제되었습니다";
	}

	public String projectApply(int id, P_apply p_apply) {
		//User user = UserService.getCurrentUser(); //현재 유저 정보 받아오기
		//p_apply.setUserId(user.getId());
		p_apply.setProject_id(id);
		p_applyMapper.insert(p_apply);
		return "신청되었습니다";
	}

	public List<Artfield> artfields() {
		return artfieldMapper.findAll();
	}

	public List<District> districts() {
		return districtMapper.findAll();
	}
}

