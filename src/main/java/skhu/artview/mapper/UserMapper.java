//findOne에 id와 login_id가 혼용되어 사용되고 있어 findOneByLoginId를 추가했습니다.
//UserService에도 혼용되어 사용되고 있어 추가함. 적절히 수정하거나 통일해주세요.
//충돌이 났을 땐 반드시 파일 우클릭->Team->Merge Tool로 적절히 파일을 수정해준 후 add to index를 해 줘야 코드가 섞이지 않습니다.
//확인 후에 주석을 지워주세요.

package skhu.artview.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import skhu.artview.dto.Age;
import skhu.artview.dto.Artfield;
import skhu.artview.dto.City;
import skhu.artview.dto.District;
import skhu.artview.dto.User;

@Mapper
public interface UserMapper {

	User findOne(int id);
	User findOneByLoginId(String login_id);
	List <User> findAll();
	void insert (User user);
	List <Age> findAges();
	List <City> findCity();
	List <District> findDistrict(int c_id);
	List<Artfield> findArtfield();

	void saveNormal (User user); //일반회원 테스트용
	void delete (int id);

	List<User> findMyApplicant(int projectId); //프로젝트 신청자 리스트
	List<User> findMyMember(int projectId); //프로젝트 멤버 리스트

}

