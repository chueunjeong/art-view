
package skhu.artview.dto;
public class Artist extends User {

	int id;
	String user_id;
	int grouping_id;
	int fav_city_id;
	int fav_district_id;
	int major;

/*
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
	}
*/

//getter&setter
	@Override
	public int getId() {
		return id;
	}

	@Override
	public void setId(int id) {
		this.id = id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String string) {
		this.user_id = string;
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

	public int getMajor() {
		return major;
	}

	public void setMajor(int major) {
		this.major = major;
	}

	public int getFav_city_id() {
		return fav_city_id;
	}

	public void setFav_city_id(int fav_city_id) {
		this.fav_city_id = fav_city_id;
	}


}
