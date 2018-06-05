package skhu.artview.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import skhu.artview.dto.User;
import skhu.artview.mapper.UserMapper;
import skhu.artview.service.UserService;

@RestController
@CrossOrigin
@RequestMapping("guest")
public class GuestController {

	@Autowired
	UserService userService;

	private UserMapper userMapper;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public GuestController(UserMapper userMapper,
                          BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userMapper = userMapper;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    //회원가입
    @PostMapping("/sign-up")
    public void signUp(@RequestBody User user, Model model, HttpServletRequest request) {
     user.setPwd(bCryptPasswordEncoder.encode(user.getPwd()));
        userMapper.saveNormal(user);
    }

    //회원 조회
    @RequestMapping("/list")
    public List<User> list () {
    	return userMapper.findAll();
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
