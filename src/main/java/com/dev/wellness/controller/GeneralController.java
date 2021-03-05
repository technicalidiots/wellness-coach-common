package com.dev.wellness.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dev.wellness.entity.Enquiries;
import com.dev.wellness.models.Output;
import com.dev.wellness.service.DataService;
import com.dev.wellness.utils.AppConstants;
import com.dev.wellness.utils.LoggerMsgSequence;
import com.dev.wellness.utils.LoggingParams;

@RestController
@RequestMapping("/api")
public class GeneralController {

	@Autowired
	DataService service;

	private static final Logger logger = LogManager.getLogger(GeneralController.class);

	@GetMapping("/fetch-data")
	public ResponseEntity<?> fetchDetails(@RequestParam("user") String user) {

		LoggingParams params = new LoggingParams(user, AppConstants.FETCH_DATA, "");

		params.setMsg("Processing request");
		logger.info(LoggerMsgSequence.getMsg(params));

		Output op = service.fetchData(user, AppConstants.FETCH_DATA);

		if (null != op) {
			params.setMsg("Request processed");
			logger.info(LoggerMsgSequence.getMsg(params));

			return new ResponseEntity<>(op, HttpStatus.OK);
		} else {

			params.setMsg("Error processing request");
			logger.error(LoggerMsgSequence.getMsg(params));

			return new ResponseEntity<>(op, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/add-enquiry")
	public ResponseEntity<?> addEnquiry(@RequestBody Enquiries enquiry) {
		LoggingParams params = new LoggingParams(enquiry.getUserName(), AppConstants.ADD_ENQUIRY, "");

		params.setMsg("Processing request");
		logger.info(LoggerMsgSequence.getMsg(params));
		Enquiries result = service.addEnquiry(enquiry, AppConstants.ADD_ENQUIRY);

		if (null != result) {
			params.setMsg("Adding Enquiry Successful");
			logger.info(LoggerMsgSequence.getMsg(params));
			return new ResponseEntity<>(AppConstants.ENQ_SUCCESS, HttpStatus.OK);
		} else {
			params.setMsg("Adding Enquiry Failed");
			logger.error(LoggerMsgSequence.getMsg(params));
			return new ResponseEntity<>(AppConstants.ENQ_FAIL, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}
