package skhu.artview.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import skhu.artview.model.Pagination;
import skhu.artview.model.SearchSpace;
import skhu.artview.dto.Question;
import skhu.artview.dto.Space;
import skhu.artview.model.NaverSpace;
import skhu.artview.service.SpaceService;

@RestController
@CrossOrigin
@RequestMapping("api")
public class SpaceController {

	@Autowired
	SpaceService spaceService;

	@RequestMapping(value = "spaceDetails", method = RequestMethod.GET)
	public List<NaverSpace> spaceDetail(Model model, HttpServletRequest request) throws Exception {
		String keyword = "갈비";
		return spaceService.searchSpace(keyword, 10, 1);
	}

	// 공간 정보를 검색하는 메소드(네이버 api 활용)
	@RequestMapping(value = "spaceDetail/{keyword}", method = RequestMethod.GET)
	public List<NaverSpace> spaceDetail(Model model, HttpServletRequest request,
			@PathVariable("keyword") String keyword) throws Exception {

		return spaceService.searchSpace(keyword, 10, 1);
	}

	// 공간 정보를 조회하는 메소드 (art-view 데이터베이스 활용)
	@RequestMapping(value = "spaceList", method = RequestMethod.GET)
	public List<Space> spaces(Model model, HttpServletRequest request) throws Exception {

		return spaceService.findAllSpaces();

	}

	// 공간 상세 정보를 조회하는 메소드 (art-view 데이터베이스 활용)
	@RequestMapping(value = "dbSpaceDetail/{id}", method = RequestMethod.GET)
	public Space dbSpaceDetail(Model model, HttpServletRequest request, @PathVariable("id") int id) throws Exception {

		return spaceService.findById(id);

	}

	// 공간 등록
	@RequestMapping(value = "space/1", method = RequestMethod.POST)
	public String saveSpace(Model model, HttpServletRequest request, @RequestBody Space s) throws Exception {

		String result = spaceService.saveSpace(s);
		return result;
	}

	/*
	 * //공간 정보를 조회하는 메소드 (art-view 데이터베이스 활용)
	 * 
	 * @RequestMapping(value = "spaces" , method= RequestMethod.GET) public
	 * SearchSpace spaces(Model model, HttpServletRequest request) throws Exception
	 * {
	 * 
	 * return spaceService.findAllSpace();
	 * 
	 * }
	 * 
	 */

	/*
	 * //카카오페이 연동 결제 서비스
	 * 
	 * @RequestMapping(value="kakaologin", produces= "application/json", method =
	 * {RequestMethod.GET,RequestMethod.POST}) public String
	 * kakaoLogin(@RequestParam("code") String code, HttpServletRequest request,
	 * HttpServletResponse response) { //로그인 후 code 얻음 System.out.println("code: "
	 * +code); return code; }
	 */

}
