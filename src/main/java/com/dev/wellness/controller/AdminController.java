package com.dev.wellness.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.wellness.entity.Contact;
import com.dev.wellness.entity.Products;
import com.dev.wellness.entity.Results;
import com.dev.wellness.service.AdminService;

@RestController
@RequestMapping("/api")
public class AdminController {

	@Autowired
	AdminService service;

	private static final Logger logger = LogManager.getLogger(AdminController.class);

	@PostMapping("/add-product")
	public ResponseEntity<?> addProduct(@RequestBody Products product) {

		logger.info("Processing product related request");

		Products prod = service.addProduct(product);

		if (null != prod) {
			return new ResponseEntity<>("Product added/Updated", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("add-contact")
	public ResponseEntity<?> addContact(@RequestBody Contact contact) {
		logger.info("Processing result related request");
		Contact con = service.addContactDetails(contact);
		if (null != con) {
			return new ResponseEntity<>("Contact added/Updated", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	} 

	@PostMapping("/add-result")
	public ResponseEntity<?> addResult(@RequestBody Results result) {
		logger.info("Processing result related request");
		Results res = service.addResult(result);
		if (null != res) {
			return new ResponseEntity<>("Result added/Updated", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
