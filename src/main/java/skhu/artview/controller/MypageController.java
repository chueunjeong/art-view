package skhu.artview.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import skhu.artview.dto.Article;
import skhu.artview.dto.Artist;
import skhu.artview.dto.District;
import skhu.artview.dto.Project;
import skhu.artview.dto.User;
import skhu.artview.model.MypageSummary;
import skhu.artview.mapper.ArticleMapper;
import skhu.artview.mapper.ArtistMapper;
import skhu.artview.mapper.ArtworkMapper;
import skhu.artview.mapper.CommentMapper;
import skhu.artview.mapper.DistrictMapper;
import skhu.artview.mapper.ExhibitionMapper;
import skhu.artview.mapper.ProjectMapper;
import skhu.artview.mapper.UserMapper;
import skhu.artview.service.MypageService;
import skhu.artview.service.ProjectService;
import skhu.artview.service.UserService;

@RestController
@CrossOrigin
@RequestMapping("api")
public class MypageController {

	
	@Autowired
	MypageService mypageService;
	
	
	//마이페이지 첫 페이지 구성하는 컨트롤러
	@RequestMapping("mypage")
	public MypageSummary mypage (Model model, Authentication auth) {
		
		return mypageService.bringMypageSummary(auth);
		
	}
	
	
}
