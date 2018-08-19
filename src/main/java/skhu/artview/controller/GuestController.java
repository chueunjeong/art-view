package skhu.artview.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import skhu.artview.dto.Age;
import skhu.artview.dto.Artfield;
import skhu.artview.dto.Artist;
import skhu.artview.dto.City;
import skhu.artview.dto.District;
import skhu.artview.dto.User;
import skhu.artview.mapper.ArtfieldMapper;
import skhu.artview.mapper.ArtistMapper;
import skhu.artview.mapper.CityMapper;
import skhu.artview.mapper.DistrictMapper;
import skhu.artview.mapper.UserMapper;
import skhu.artview.service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("api")
public class GuestController {

	@Autowired
	UserService userService;
	@Autowired
	ArtistMapper artistMapper;
	@Autowired
	ArtfieldMapper artfieldMapper;
	@Autowired
	CityMapper cityMapper;
	@Autowired
	DistrictMapper districtMapper;

	private UserMapper userMapper;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public GuestController(UserMapper userMapper,
                          BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userMapper = userMapper;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    //회원가입
    @RequestMapping(value="/sign-up", method = RequestMethod.POST)
    public String signUp(@RequestBody User user, Model model, HttpServletRequest request) {
    	userMapper.saveNormal(user);
        return "회원가입 성공";
    }

    //Artist 회원가입
    @RequestMapping(value="sign-up/artist", method = RequestMethod.POST)
    public String signUp_art(@RequestBody Artist artist, Model model, HttpServletRequest request) {
    	String uid = userMapper.findOneByUser_id();
    	userMapper.updateType(1,uid);
    	artist.setUser_id(uid);
    	artistMapper.insert(artist);
        return "회원가입 성공";
    }

    //회원 조회
    @RequestMapping("/list")
    public List<User> list () {
    	return userMapper.findAll();
    }

    //연령대 조회
    @RequestMapping("/ages")
    public List<Age> FindAges(Model model, HttpServletRequest request) {
    	return userMapper.findAges();
    }

    //도 조회
    @RequestMapping("/cities")
    public List<City> CityList(Model model, HttpServletRequest request) {
    	return cityMapper.findAll();
    }

    //구 조회
    @RequestMapping("/districts")
    public List<District> DistrictList(Model model, HttpServletRequest request) {
    		return districtMapper.findAll();
    }

    //예술분야 조회
    @RequestMapping("/artfields")
    public List<Artfield> Artfields(Model model, HttpServletRequest request) {
    	return artfieldMapper.findAll();
    }


	// 회원 아이디 조회
	@RequestMapping(value = "user/{login_id}")
	public User user(@PathVariable("login_id") String login_id) {
		return userService.findOneByLoginId(login_id);
	}

	// 전체 회원 조회
	@RequestMapping(value = "users")
	public List<User> user() {
		return userService.findAll();
	}

	// 일반 회원 회원가입
	@RequestMapping(value = "user", method = RequestMethod.POST)
	public String basicRegister(@RequestBody User user) {
		userService.register(user); // 가입 정보 저장
		return "저장성공";
	}

}
