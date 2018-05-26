
package skhu.artview.dto;

public class Artist extends User {

	int id;
	int user_id;
	int grouping_id;
	int fav_district_id;
	String major;
	String career;

//constructor
	public Artist(int id, int fav_artfield_id, String login_id, String pwd, String name, String phone, String email,
			int age) {
		super(id, fav_artfield_id, login_id, pwd, name, phone, email, age);
		// TODO Auto-generated constructor stub
	}

	public Artist(int id, int fav_artfield_id, String login_id, String pwd, String name, String phone, String email,
			int age, int id2, int user_id, int grouping_id, int fav_district_id, String major, String career) {
		super(id, fav_artfield_id, login_id, pwd, name, phone, email, age);
		id = id2;
		this.user_id = user_id;
		this.grouping_id = grouping_id;
		this.fav_district_id = fav_district_id;
		this.major = major;
		this.career = career;
	}

//getter&setter
	@Override
	public int getId() {
		return id;
	}

	@Override
	public void setId(int id) {
		this.id = id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getGrouping_id() {
		return grouping_id;
	}

	public void setGrouping_id(int grouping_id) {
		this.grouping_id = grouping_id;
	}

	public int getFav_district_id() {
		return fav_district_id;
	}

	public void setFav_district_id(int fav_district_id) {
		this.fav_district_id = fav_district_id;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getCareer() {
		return career;
	}

	public void setCareer(String career) {
		this.career = career;
	}



}
