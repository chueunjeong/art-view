package skhu.artview.dto;
/*전민선 : 
 * artwork 테이블의 
 * 작품 크기는 음수가 될 수 없어서 
 * DB에서 int(10)unsigned으로 정의했습니다.
 * 그래서 width와 height의 타입을 long으로 했습니다.
 */

public class Artwork {

	private int id;
	private int artist_id;
	private int artfield_id;
	private int exhibition_id;
	private String title;
	private String year;
	private long width;
	private long height;
	private String material;
	private String subject;
	private int submit_count;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getArtist_id() {
		return artist_id;
	}
	public void setArtist_id(int artist_id) {
		this.artist_id = artist_id;
	}
	public int getArtfield_id() {
		return artfield_id;
	}
	public void setArtfield_id(int artfield_id) {
		this.artfield_id = artfield_id;
	}
	public int getExhibition_id() {
		return exhibition_id;
	}
	public void setExhibition_id(int exhibition_id) {
		this.exhibition_id = exhibition_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public long getWidth() {
		return width;
	}
	public void setWidth(long width) {
		this.width = width;
	}
	public long getHeight() {
		return height;
	}
	public void setHeight(long height) {
		this.height = height;
	}
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public int getSubmit_count() {
		return submit_count;
	}
	public void setSubmit_count(int submit_count) {
		this.submit_count = submit_count;
	}
	
	
	
	
	
	
	
}
