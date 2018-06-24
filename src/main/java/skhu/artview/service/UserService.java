package skhu.artview.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import skhu.artview.model.EmailAndName;
import skhu.artview.dto.User;
import skhu.artview.mapper.UserMapper;

@Service
public class UserService {
		@Autowired UserMapper userMapper;

		//가입정보 저장
		public void register (User user) {
			userMapper.insert(user);
		}

		//회원아이디 조회
		public User findOne(int id) {
			return userMapper.findOne(id);
		}

		//login아이디로 조회
		public User findOneByLoginId(String login_id) {
			return userMapper.findOneByLoginId(login_id);
		}

		//전체회원 조회
		public List<User> findAll(){
			return userMapper.findAll();
		}

		
		public User findUserByEmailAndName(EmailAndName en){
			return userMapper.findByEmailAndName(en);
			
		}
		
}
