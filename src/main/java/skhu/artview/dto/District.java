package skhu.artview.dto;
/* 전민선 :
 * 지역 목록은 추가와 삭제가 빈번하지 않기 때문에
 * mybatis의 cache를 적용하여
 * 구현했습니다.
 *
 *
 */
import java.io.Serializable;

public class District implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;


	private int id;
	private int city_id;
	private String name;
	String city_name; //join

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCity_id() {
		return city_id;
	}
	public void setCity_id(int city_id) {
		this.city_id = city_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity_name() {
		return city_name;
	}
	public void setCity_name(String city_name) {
		this.city_name = city_name;
	}



}
