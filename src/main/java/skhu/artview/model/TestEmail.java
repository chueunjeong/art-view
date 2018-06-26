package skhu.artview.model;

public class TestEmail {
	private String sender;
	private String recipient;

	private String subject;
	private String content;
	
	
	
	public TestEmail(String sender, String recipient, String subject, String content) {
		super();
		this.sender = sender;
		this.recipient = recipient;
		this.subject = subject;
		this.content = content;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getRecipient() {
		return recipient;
	}
	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

	
}
