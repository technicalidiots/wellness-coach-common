package com.dev.wellness.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.wellness.dao.CommonDao;
import com.dev.wellness.entity.Contact;
import com.dev.wellness.entity.Products;
import com.dev.wellness.entity.Results;
import com.dev.wellness.entity.WellnessUser;
import com.dev.wellness.utils.AppConstants;
import com.dev.wellness.utils.LoggerMsgSequence;
import com.dev.wellness.utils.LoggingParams;

@Service
public class AdminService {

	@Autowired
	CommonDao dao;

	private static final Logger logger = LogManager.getLogger(AdminService.class);

	public Products addProduct(Products product) {
		String userName = product.getUserName();

		LoggingParams params = new LoggingParams(userName, "", "");

		if (null != product.getId()) {
			params.setRequestType(AppConstants.UPDATE_PRODUCT);

			params.setMsg("Product ID Present, checking product entry");
			logger.info(LoggerMsgSequence.getMsg(params));

			Products prod = dao.findProduct(product.getId());
			if (null != prod) {
				params.setMsg("Product Present, updating entry");
				logger.info(LoggerMsgSequence.getMsg(params));

				prod.setImage(product.getImage());
				prod.setName(product.getName());
				prod.setDesc(product.getDesc());

				dao.addProduct(prod);
			} else {
				params.setMsg("Invalid Product ID !!");
				logger.error(LoggerMsgSequence.getMsg(params));
			}

			return prod;
		} else {
			params.setRequestType(AppConstants.ADD_PRODUCT);
			params.setMsg("Product ID not present, validating user");
			logger.info(LoggerMsgSequence.getMsg(params));

			WellnessUser user = dao.fetchUser(userName);

			if (null != user) {
				params.setMsg("User present, adding product");
				logger.info(LoggerMsgSequence.getMsg(params));

				product.setUser(user);
				Products prod = dao.addProduct(product);
				return prod;
			} else {
				params.setMsg("User not found");
				logger.error(LoggerMsgSequence.getMsg(params));

				return null;
			}

		}

	}

	public Results addResult(Results result) {

		String userName = result.getUserName();

		LoggingParams params = new LoggingParams(userName, "", "");

		if (null != result.getId()) {
			params.setRequestType(AppConstants.UPDATE_RESULT);

			params.setMsg("Result ID Present, checking result entry");
			logger.info(LoggerMsgSequence.getMsg(params));

			Results res = dao.findResult(result.getId());
			if (null != res) {
				params.setMsg("Result Present, updating entry");
				logger.info(LoggerMsgSequence.getMsg(params));

				res.setCustImage(result.getCustImage());
				res.setCustName(result.getCustName());
				res.setCustDesc(result.getCustDesc());

				dao.addResult(res);
			} else {
				params.setMsg("Invalid Result ID !!");
				logger.error(LoggerMsgSequence.getMsg(params));
			}

			return res;
		} else {
			params.setRequestType(AppConstants.ADD_RESULT);
			params.setMsg("Result ID not present, validating user");
			logger.info(LoggerMsgSequence.getMsg(params));

			WellnessUser user = dao.fetchUser(userName);

			if (null != user) {
				params.setMsg("User present, adding result");
				logger.info(LoggerMsgSequence.getMsg(params));

				result.setUser(user);
				Results res = dao.addResult(result);
				return res;
			} else {
				params.setMsg("User not found");
				logger.error(LoggerMsgSequence.getMsg(params));

				return null;
			}

		}

	}

	public Contact addContactDetails(Contact contact) {

		String userName = contact.getUserName();

		LoggingParams params = new LoggingParams(userName, "", "");

		if (null != contact.getId()) {
			params.setRequestType(AppConstants.UPDATE_CONTACT);

			params.setMsg("Contact ID Present, checking contact entry");
			logger.info(LoggerMsgSequence.getMsg(params));

			Contact con = dao.findContact(contact.getId());
			if (null != con) {
				params.setMsg("Contact Present, updating entry");
				logger.info(LoggerMsgSequence.getMsg(params));

				con.setAddress(contact.getAddress());
				con.setEmail(contact.getEmail());
				con.setFbLink(contact.getFbLink());
				con.setInstaLink(contact.getInstaLink());
				con.setPhone(contact.getPhone());

				dao.addContact(con);
			} else {
				params.setMsg("Invalid Result ID !!");
				logger.error(LoggerMsgSequence.getMsg(params));
			}

			return con;
		} else {
			params.setRequestType(AppConstants.ADD_CONTACT);
			params.setMsg("Contact ID not present, validating user");
			logger.info(LoggerMsgSequence.getMsg(params));

			WellnessUser user = dao.fetchUser(userName);

			if (null != user) {
				params.setMsg("User present, adding contact");
				logger.info(LoggerMsgSequence.getMsg(params));

				contact.setUser(user);
				Contact con = dao.addContact(contact);
				return con;
			} else {
				params.setMsg("User not found");
				logger.error(LoggerMsgSequence.getMsg(params));

				return null;
			}

		}

	}

}
