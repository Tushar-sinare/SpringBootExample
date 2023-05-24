package com.app.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import jakarta.mail.internet.MimeMessage;

@Component
public class EmailUtil {

	@Autowired
	 private JavaMailSender sender;
	
	public boolean Send(String to,String subject,String text,MultipartFile file) {
		boolean flag = false;
		try {
			MimeMessage message = sender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message,file!=null?true:false);
			helper.setTo(to);
			helper.setFrom("tusharsinare0202@gmail.com");
			helper.setSubject(subject);
			helper.setText(text);
			if(file!=null) {
				helper.addAttachment(file.getOriginalFilename(),file);
			}
			sender.send(message);
			flag=true;
			
		}catch(Exception e) {
			flag=false;
			e.printStackTrace();
		}
		return flag;
	}
}
