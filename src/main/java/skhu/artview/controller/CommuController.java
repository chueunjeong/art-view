package skhu.artview.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import skhu.artview.dto.Article;
import skhu.artview.dto.Project;
import skhu.artview.mapper.ArticleMapper;
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
	@Autowired ArticleMapper articleMapper;

	/*작성자: 남하영*/

/*	작성 예정 컨트롤러
	프로젝트별 게시판 게시글+댓글 조회
	프로젝트별 게시판 게시글 작성
	프로젝트별 게시판 게시글 수정
	프로젝트별 게시판 게시글 삭제
	프로젝트별 게시판 게시글 댓글 작성
	프로젝트별 게시판 게시글 댓글 수정
	프로젝트별 게시판 게시글 댓글 삭제
	프로젝트 작성자/제목/내용/제목+내용으로 검색
	게시글 작성자/제목/내용/제목+내용으로 검색
	프로젝트 신청버튼->신청서 작성(신청cnt++)
	mapper에 작성: 프로젝트 신청자 현황 조회(작성자 한정)
	mapper에 작성: 프로젝트 멤버수 조회
	프로젝트별 채팅창 지원 생각중*/


	//전체 프로젝트 조회(메인 출력)
	@RequestMapping("projects")
	public List<Project> projects() {
		return projectMapper.findAll();
	}

	//프로젝트 클릭 후 조회
	@RequestMapping("project/{id}")
	public Project commu_submit(@PathVariable("id") int id) {
		Project project = projectMapper.findOne(id);
		return project;
	}

	/*//프로젝트 작성(파일 업로드용 서버를 정해야 함...ㅠㅠ)
	@RequestMapping(value = "project", method = RequestMethod.POST)
	public String submit(@RequestBody Project project) {
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

	//프로젝트별 게시판 출력
	@RequestMapping(value = "article/{boardId}")
	public List<Article> community(@PathVariable("boardId") int boardId) {
		return articleMapper.findByBoardId(boardId);
	}

}
