//article dto에 프로젝트 아이디, 전시공간 아이디 칼럼 따로 나눠서 불러옴

package skhu.artview.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import skhu.artview.dto.P_apply;
import skhu.artview.dto.Project;
import skhu.artview.mapper.ArticleMapper;
import skhu.artview.mapper.CommentMapper;
import skhu.artview.mapper.P_applyMapper;
import skhu.artview.mapper.ProjectMapper;
import skhu.artview.mapper.UserMapper;
import skhu.artview.service.CommuService;
import skhu.artview.service.UserService;

@RestController
@CrossOrigin
@RequestMapping("api")
public class CommuController {

	@Autowired CommuService commuService;
	@Autowired ProjectMapper projectMapper;
	@Autowired UserService userService;
	@Autowired UserMapper userMapper;
	@Autowired P_applyMapper p_applyMapper;
	@Autowired ArticleMapper articleMapper;
	@Autowired CommentMapper commentMapper;

	/*작성자: 남하영*/

/*	작성 예정 컨트롤러*/


	//전체 프로젝트 조회(메인 출력)
	@RequestMapping("projects")
	public List<Project> projects() {
		return projectMapper.findAll();
	}

	//프로젝트 클릭 후 조회
	@RequestMapping("project/{id}")
	public Project projectDetail(@PathVariable("id") int id) {
		Project project = projectMapper.findOne(id);
		project = commuService.projectMapping(project);
		return project;
	}

	/*//프로젝트 작성(파일 업로드용 서버를 정해야 함...ㅠㅠ)
	@RequestMapping(value = "project", method = RequestMethod.POST)
	public String projectSubmit(@RequestBody Project project) {
		User user = UserService.getCurrentUser(); //현재 유저 정보 받아오기
		project.add(user.getId());
		projectMapper.insert(project);
		return "등록되었습니다";
	}*/

	//프로젝트 삭제
	@RequestMapping(value = "project/{id}", method = RequestMethod.DELETE)
	public String projectDelete(@PathVariable("id") int id) {
		projectMapper.delete(id);
		return "삭제되었습니다";
	}

	//프로젝트 수정 불가 방침으로, 컨트롤러 없음

	//프로젝트 작성자/제목/내용/제목+내용으로 검색
	@RequestMapping("projectSearch")
	public List<Project> projectSearch(@PathVariable("code") int code, @PathVariable("keyword") String keyword) {
		//작성자=0, 제목=1, 내용=2, 제목+내용=3
		List<Project> results = null;
		return results;
	}

	//프로젝트 신청버튼->신청서 작성(신청서 테이블 추가)
	@RequestMapping(value = "project/{id}/p_apply", method = RequestMethod.POST)
	public void projectApply(@PathVariable("id") int id, @RequestBody P_apply p_apply) {
		//User user = UserService.getCurrentUser(); //현재 유저 정보 받아오기
		//p_apply.setUserId(user.getId());
		p_apply.setProjectId(id);
		p_applyMapper.insert(p_apply);
	}

}
