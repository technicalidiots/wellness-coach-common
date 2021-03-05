package com.dev.wellness.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.dev.wellness.dao.CommonDao;
import com.dev.wellness.entity.Contact;
import com.dev.wellness.entity.Enquiries;
import com.dev.wellness.entity.WellnessUser;
import com.dev.wellness.models.Output;
import com.dev.wellness.utils.LoggerMsgSequence;
import com.dev.wellness.utils.LoggingParams;
import com.dev.wellness.utils.MailUtil;

@Service
public class DataService {

	@Autowired
	MailUtil mail;

	@Autowired
	CommonDao dao;

	@Value("${from}")
	String from;

	private static final Logger logger = LogManager.getLogger(DataService.class);

	/**
	 * Returns products, results and contact details based on userName
	 * 
	 * @param userName
	 * @param requestType
	 * @return Output
	 */
	public Output fetchData(String userName, String requestType) {

		LoggingParams params = new LoggingParams(userName, requestType, "");

		Output op = null;

		params.setMsg("Validating user details");
		logger.info(LoggerMsgSequence.getMsg(params));

		WellnessUser user = dao.fetchUser(userName);

		if (null != user) {

			params.setMsg("User Validated.!");
			logger.info(LoggerMsgSequence.getMsg(params));

			op = new Output();
			op.setContact(dao.fetchContact(user));
			op.setProducts(dao.fetchProducts(user));
			op.setResults(dao.fetchResults(user));
		} else {
			params.setMsg("User not found");
			logger.error(LoggerMsgSequence.getMsg(params));

		}
		return op;

	}

	public Enquiries addEnquiry(Enquiries enquiry, String requestType) {
		String userName = enquiry.getUserName();
		Enquiries enq = null;
		LoggingParams params = new LoggingParams(userName, requestType, "");

		params.setMsg("Validating user details");
		logger.info(LoggerMsgSequence.getMsg(params));

		WellnessUser user = dao.fetchUser(userName);

		if (null != user) {
			params.setMsg("Fetching contact details");
			logger.info(LoggerMsgSequence.getMsg(params));
			Contact contact = dao.fetchContact(user);

			enquiry.setUser(user);

			params.setMsg("Adding enquiry details");
			logger.info(LoggerMsgSequence.getMsg(params));
			enq = dao.addEnquiry(enquiry);

			String text = "Hello,\n" + enquiry.getName()
					+ " has been trying to contact you.\nPlease find below details to contact,\n\n" + "Name : "
					+ enquiry.getName() + "\nEmail : " + enquiry.getEmail() + "\nPhone : " + enquiry.getPhone()
					+ "\nMessage : " + enquiry.getMsg();

			mail.sendMail(contact.getEmail(), from, text);

		}
		return enq;
	}

}
