package skhu.artview.dto;

/*전민선 : 
 * grouping_id는 project의 id이다.
 */
public class P_exhibition{

	int id;
	int artfield_id;
	int grouping_id;
	String subject;
	String start_date;
	String end_date;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getArtfield_id() {
		return artfield_id;
	}
	public void setArtfield_id(int artfield_id) {
		this.artfield_id = artfield_id;
	}
	public int getGrouping_id() {
		return grouping_id;
	}
	public void setGrouping_id(int grouping_id) {
		this.grouping_id = grouping_id;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getStart_date() {
		return start_date;
	}
	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}
	public String getEnd_date() {
		return end_date;
	}
	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}
	
	
	
	
}