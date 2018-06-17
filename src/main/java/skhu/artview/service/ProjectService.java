package skhu.artview.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import skhu.artview.dto.FileDTO;
import skhu.artview.dto.Project;
import skhu.artview.dto.User;
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

	S3Uploader s3Uploader = new S3Uploader();

	public int appli_cnt(int projectId) {
		return p_applyMapper.appli_cnt(projectId);
	}

	public int mem_cnt(int projectId) {
		return p_applyMapper.mem_cnt(projectId);
	}

	public ProjectDetail projectMapping(Project project, ProjectDetail projectDetail) {
		projectDetail.setId(project.getId());
		projectDetail.setAuthor_id(project.getAuthor_id());
		projectDetail.setTitle(project.getTitle());
		projectDetail.setContent(project.getContent());
		projectDetail.setFile_id(project.getFile_id());
		projectDetail.setD_day(project.getD_day());
		projectDetail.setArtfield_id(project.getArtfield_id());
		projectDetail.setFav_day_start(project.getFav_day_start());
		projectDetail.setFav_day_end(project.getFav_day_end());
		projectDetail.setDistrict_id(project.getDistrict_id());

		projectDetail.setAuthor(userMapper.findOne(project.getAuthor_id()));
		projectDetail.setApplicants(userMapper.findMyApplicant(project.getId()));
		projectDetail.setMembers(userMapper.findMyMember(project.getId()));
		projectDetail.setAppli_cnt(this.appli_cnt(project.getId()));
		projectDetail.setMem_cnt(this.mem_cnt(project.getId()));
		return projectDetail;
	}

	//작성 예정
	public List<ProjectDetail> makeList(List<Project> p_list) {
		return null;
	}

	public String projectSubmit(Project project, MultipartFile file) {
		FileDTO uploadFile = new FileDTO();

		String result = s3Uploader.upload(file);
		if(result.equals("fail"))
			return "실패하였습니다";
		else
			uploadFile.setName(result);

		fileMapper.insert(uploadFile);
		int fileId = fileMapper.getId(result);
		project.setFile_id(fileId);

		User user = null; //현재 유저 정보 받아오기
		project.setAuthor_id(user.getId());
		projectMapper.insert(project); //insert mapper만들어야 함
		return "등록되었습니다";
	}

	//작성자=0, 제목=1, 내용=2, 제목+내용=3
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
}

