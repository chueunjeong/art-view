package skhu.artview.service;
import java.util.List;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import skhu.artview.utils.RandomPassword;
import skhu.artview.model.EmailAndName;
import skhu.artview.dto.User;
import skhu.artview.mapper.UserMapper;

@Service
public class UserService {

    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
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

		//회원가입 후 비활성화 계정을 찾아 인증 메일 발송
		public User unabledUserByEmail(String email) {
			return userMapper.findByEmail(email);
		}
		//이메일 링크 클릭 시 계정 활성화 서비스
		public String setEnabled(User user) {
			userMapper.updateEnabled(user);
			return "로그인이 가능합니다.";
		}
		
		
		
		//임시 비밀번호 발급을 위한 회원정보 조회 (이메일 + 이름)
		public User findUserByEmailAndName(EmailAndName en){
			return userMapper.findByEmailAndName(en);
			
		}
		
		//임시 비밀번호 생성, 데이터베이스 업데이트, 사용자 이메일로 임시 비밀번호 발송
		public String setNewPassword(User user) throws MessagingException {
			String newPassword = RandomPassword.getRamdomPassword(4);
			System.out.println("암호화 전");
			String setPassword = bCryptPasswordEncoder.encode(newPassword);
			System.out.println("암호화 후");
			userMapper.updatePassword(setPassword, user.getEmail());
			System.out.println("디비 업데이트 완료");
		
			return newPassword;
		}
		
		
}
