package skhu.artview.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import skhu.artview.dto.User;
import skhu.artview.mapper.UserMapper;

@RestController
@RequestMapping("/user")
public class UserController {

	 private UserMapper userMapper;
	    private BCryptPasswordEncoder bCryptPasswordEncoder;

	    public UserController(UserMapper userMapper,
	                          BCryptPasswordEncoder bCryptPasswordEncoder) {
	        this.userMapper = userMapper;
	        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	    }

	    @PostMapping("/sign-up")
	    public void signUp(@RequestBody User user) {
	     user.setPwd(bCryptPasswordEncoder.encode(user.getPwd()));
	        userMapper.saveNormal(user);
	    }
	    
	    @RequestMapping("/list")
	    public List<User> list () {
	    	return userMapper.findAll();
	    }
	/*전민선 :  jwt 토큰 생성 시 사용했던 컨트롤러(/sign-up)이 대신 합니다.
    @RequestMapping(value="create", method=RequestMethod.POST)
    public String create(Model model, User user) {
        UserMapper.insert(user);
        return "redirect:list";
    }
	*/
    @RequestMapping(value="edit", method=RequestMethod.GET)
    public String edit(Model model, @RequestParam("id") int id) {
        User user = userMapper.findOne(id);

        model.addAttribute("user", user);

        return "user/edit";
    }

    @RequestMapping(value="edit", method=RequestMethod.POST)
    public String edit(Model model, User user) {
        //UserMapper.update(User);
        return "redirect:list";
    }

    @RequestMapping("delete")
    public String delete(Model model, @RequestParam("id") int id) {
        userMapper.delete(id);
        return "redirect:list";
    }
}
