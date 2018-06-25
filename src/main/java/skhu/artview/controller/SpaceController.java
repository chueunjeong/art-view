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
import skhu.artview.model.Space;
import skhu.artview.service.SpaceService;

@RestController
@CrossOrigin
@RequestMapping("api")
public class SpaceController {
	
	@Autowired
	SpaceService spaceService;
	
	
	@RequestMapping(value = "spaceDetail/{keyword}" , method= RequestMethod.GET)
	   public List<Space> spaceDetail(Model model, HttpServletRequest request, @PathVariable("keyword") String keyword)  throws Exception {
			
	       return spaceService.searchSpace(keyword,10,1);
	   }
	
	@RequestMapping(value = "spaces" , method= RequestMethod.POST)
	   public  SearchSpace spaces(Model model, HttpServletRequest request, @RequestBody SearchSpace pagination)  throws Exception {
			
	       return spaceService.findAllSpace(pagination);
	       
	   }
	
	
	
	
	
	
	/*
	//카카오페이 연동 결제 서비스
	@RequestMapping(value="kakaologin", produces= "application/json", 
			method = {RequestMethod.GET,RequestMethod.POST})
	public String kakaoLogin(@RequestParam("code") String code, HttpServletRequest request, HttpServletResponse response) {
		//로그인 후 code 얻음
		System.out.println("code: " +code);
		return code;
	}*/
	


}
