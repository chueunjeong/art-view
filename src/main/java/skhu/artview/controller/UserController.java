package skhu.artview.controller;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import skhu.artview.model.EmailAndName;
import skhu.artview.model.TestEmail;
import skhu.artview.service.EmailService;
import skhu.artview.service.UserService;
import skhu.artview.dto.User;
import skhu.artview.mapper.UserMapper;

@RestController
@CrossOrigin
@RequestMapping("api")
public class UserController {
@Autowired
UserMapper userMapper;
	/*전민선 :  jwt 토큰 생성 시 사용했던 컨트롤러(/sign-up)이 대신 합니다.
    @RequestMapping(value="create", method=RequestMethod.POST)
    public String create(Model model, User user) {
        UserMapper.insert(user);
        return "redirect:list";
    }
	*/

	//유저 정보 수정 페이지 조회
    @RequestMapping(value="user/2", method=RequestMethod.GET)
    public User edit( HttpServletRequest request, @PathVariable("id") int id) {
        return userMapper.findOne(id);
    }

    //유저 정보 수정 저장
    @RequestMapping(value="user/3", method=RequestMethod.PUT)
    public void edit(Model model, User user) {
        userMapper.update(user);
    }

    //유저 정보 삭제
    @RequestMapping(value="user/4", method=RequestMethod.DELETE)
    public void delete(Model model, @RequestParam("id") int id) {
        userMapper.delete(id);
    }
    
    
    
    @Autowired
	EmailService emailService;
	@Autowired
	UserService userService;

	//회원 임시비밀 번호 발송 메소드
	@RequestMapping(value = "sendMail/{email}", method = RequestMethod.POST)
	public void send(@PathVariable("email") String email) throws MessagingException {
		
		
		TestEmail testEmail = new TestEmail("iris3795@gmail.com", email, "제목입니다", "http://localhost:8080/art-view/api/enabled/"+email);
		emailService.sendMail(testEmail);
	}
	
	@RequestMapping(value = "enabled/{email}", method = RequestMethod.GET)
	public String enabled(@PathVariable("email") String email) throws MessagingException {
		
		User user = userService.unabledUserByEmail(email);
		userService.setEnabled(user);
		
		
		return "계정정보가 활성화되었습니다.";
	}
	
	

	@RequestMapping(value = "newPassword", 
						method = RequestMethod.POST)
	public String newPassword(@RequestBody EmailAndName en) throws MessagingException {

		User user  = userService.findUserByEmailAndName(en);

		if (user != null) {
			String sendPassword = userService.setNewPassword(user);

			TestEmail testEmail = new TestEmail("iris3795@gmail.com", en.getEmail(), "제목입니다", sendPassword);
			emailService.sendMail(testEmail);

			return "발송완료";
		}
		
		return "회원정보가 올바르지 않아 발송에 실패했습니다.";
	}

}
