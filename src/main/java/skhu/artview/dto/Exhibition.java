package skhu.artview.dto;


public class Exhibition {

	private int id;
	private int grouping_id;
	private int pexhibition_id;
	private int artfield_id;
	private String start_date;
	private String end_date;
	private String subject;
	private String description;
	private int finish_exhibition_count;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getGrouping_id() {
		return grouping_id;
	}
	public void setGrouping_id(int grouping_id) {
		this.grouping_id = grouping_id;
	}
	public int getPexhibition_id() {
		return pexhibition_id;
	}
	public void setPexhibition_id(int pexhibition_id) {
		this.pexhibition_id = pexhibition_id;
	}
	public int getArtfield_id() {
		return artfield_id;
	}
	public void setArtfield_id(int artfield_id) {
		this.artfield_id = artfield_id;
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
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getFinish_exhibition_count() {
		return finish_exhibition_count;
	}
	public void setFinish_exhibition_count(int finish_exhibition_count) {
		this.finish_exhibition_count = finish_exhibition_count;
	}
	
}
