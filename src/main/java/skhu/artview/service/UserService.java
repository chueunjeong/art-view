package skhu.artview.service;
import java.util.List;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.skhu.email.utils.Encryption;
import net.skhu.email.utils.RandomPassword;
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

		//임시 비밀번호 발급을 위한 회원정보 조회 (이메일 + 이름)
		public User findUserByEmailAndName(EmailAndName en){
			return userMapper.findByEmailAndName(en);
			
		}
		
		//임시 비밀번호 생성, 데이터베이스 업데이트, 사용자 이메일로 임시 비밀번호 발송
		public String setNewPassword(User user) throws MessagingException {
			String newPassword = RandomPassword.getRamdomPassword(4);
			String setPassword = Encryption.encrypt(newPassword, Encryption.MD5);
			userMapper.updatePassword(setPassword, user.getEmail());
					
		
			return newPassword;
		}
		
		
}
