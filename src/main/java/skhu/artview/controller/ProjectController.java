//article dto에 프로젝트 아이디, 전시공간 아이디 칼럼 따로 나눠서 불러옴
//프로젝트 관련 컨트롤러입니다

package skhu.artview.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import skhu.artview.dto.Artfield;
import skhu.artview.dto.District;
import skhu.artview.dto.P_apply;
import skhu.artview.dto.Project;
import skhu.artview.mapper.ArticleMapper;
import skhu.artview.mapper.CommentMapper;
import skhu.artview.mapper.P_applyMapper;
import skhu.artview.mapper.ProjectMapper;
import skhu.artview.mapper.UserMapper;
import skhu.artview.model.ProjectDetail;
import skhu.artview.service.ProjectService;
import skhu.artview.service.S3Service;
import skhu.artview.service.UserService;

@RestController
@CrossOrigin
@RequestMapping("api")
public class ProjectController {

	@Autowired ProjectService projectService;
	@Autowired ProjectMapper projectMapper;
	@Autowired UserService userService;
	@Autowired S3Service s3Service;
	@Autowired UserMapper userMapper;
	@Autowired P_applyMapper p_applyMapper;
	@Autowired ArticleMapper articleMapper;
	@Autowired CommentMapper commentMapper;

	/*작성자: 남하영*/

/*	작성 예정 컨트롤러*/

    @RequestMapping(value = "upload", method = RequestMethod.POST)
    public void upload(@RequestBody MultipartFile file) throws IOException {
    	projectService.upload(file);
    	System.out.println(s3Service.getFileUrl(6));
    }

    @RequestMapping(value = "getUrl", method = RequestMethod.GET)
    public String getUrl() {
    	return s3Service.getFileUrl(5);
    }

	//전체 프로젝트 조회(메인 출력)
	@RequestMapping(value = "projectList", method= RequestMethod.GET)
	public List<ProjectDetail> projects() {
		return projectService.makeList(projectMapper.findAll());
	}

	//프로젝트 클릭 후 조회
	@RequestMapping(value = "projectDetail/{id}", method= RequestMethod.GET)
	public ProjectDetail projectDetail(Model model, HttpServletRequest request, @PathVariable("id") int id)  throws Exception {
		return projectService.projectDetail(id);
	}

	//artfield
	@RequestMapping(value = "artfields", method = RequestMethod.GET)
	public List<Artfield> artfields() {
		return projectService.artfields();
	}

	//district
	@RequestMapping(value = "districts", method = RequestMethod.GET)
	public List<District> districts() {
		return projectService.districts();
	}

	//프로젝트 작성
	@RequestMapping(value = "projectSubmit", method = RequestMethod.POST)
	public String projectSubmit(@RequestBody Project project, @RequestBody MultipartFile file) {
		return projectService.projectSubmit(project, file);
	}

	//프로젝트 작성 테스트
	@RequestMapping(value = "projectTest", method = RequestMethod.POST)
	public String projectSubmitTest(Model model, HttpServletRequest request, @RequestBody Project project) {
		String result = projectService.projectSubmitTest(project);
		return result;
	}

	//프로젝트 삭제
	@RequestMapping(value = "project/{id}", method = RequestMethod.DELETE)
	public String projectDelete(@PathVariable("id") int id) {
		return projectService.projectDelete(id);
	}

	//프로젝트 수정 불가 방침으로, 컨트롤러 없음

	//프로젝트 작성자/제목/내용/제목+내용으로 검색
	@RequestMapping("projectSearch")
	public List<ProjectDetail> projectSearch(@PathVariable("code") int code, @PathVariable("keyword") String keyword) {
		return projectService.search(code, keyword);
	}

	//프로젝트 신청버튼->신청서 작성(신청서 테이블 추가)
	@RequestMapping(value = "project/{id}/p_apply", method = RequestMethod.POST)
	public String projectApply(@PathVariable("id") int id, @RequestBody P_apply p_apply) {
		//User user = UserService.getCurrentUser(); //현재 유저 정보 받아오기
		//p_apply.setUserId(user.getId());
		return projectService.projectApply(id, p_apply);
	}

}
