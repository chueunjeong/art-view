package skhu.artview.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import skhu.artview.dto.User;
import skhu.artview.mapper.UserMapper;

@RestController
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
