package skhu.artview.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import skhu.artview.model.TestEmail;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;



@Service
public class EmailService {
	@Autowired
	private JavaMailSender javaMailSender;

	//이메일 발송(MimeMessage 객체 안의 내용으로 발송됨)
	public void sendMail(TestEmail email) throws MessagingException {
		MimeMessage message = javaMailSender.createMimeMessage();
		message.setSubject(email.getSubject());
		message.setSender(new InternetAddress(email.getSender()));
		message.setRecipient(Message.RecipientType.TO, new InternetAddress(email.getRecipient()));
		message.setText(email.getContent());
		message.setSentDate(new Date());

		javaMailSender.send(message);
	}
}
