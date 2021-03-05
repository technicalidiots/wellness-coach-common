package com.dev.wellness.utils;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class MailUtil {

	@Autowired
	JavaMailSender mailsender;

	private static final Logger logger = LogManager.getLogger(MailUtil.class);

	public void sendMail(String to, String from, String text) {
		try {
			MimeMessage messsage = mailsender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(messsage, true);

			helper.setSubject(AppConstants.NEW_ENQUIRY);
			helper.setTo(to);
			helper.setFrom(from);
			helper.setText(text);

			mailsender.send(messsage);

			logger.info("Mail sent");

		} catch (MessagingException e) {
			logger.error("Error Occurred while sending mail.", e);
		}

	}

	public void sendMailWithAttachment() {

	}

}
