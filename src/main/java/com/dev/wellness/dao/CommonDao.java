package com.dev.wellness.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.wellness.entity.Contact;
import com.dev.wellness.entity.Enquiries;
import com.dev.wellness.entity.Products;
import com.dev.wellness.entity.Results;
import com.dev.wellness.entity.WellnessUser;
import com.dev.wellness.repo.ContactsRepo;
import com.dev.wellness.repo.EnquiryRepo;
import com.dev.wellness.repo.ProductsRepo;
import com.dev.wellness.repo.ResultsRepo;
import com.dev.wellness.repo.UserRepo;

@Service
public class CommonDao {

	@Autowired
	ContactsRepo contactsRepo;

	@Autowired
	EnquiryRepo enquiryRepo;

	@Autowired
	ProductsRepo productsRepo;

	@Autowired
	ResultsRepo resultsRepo;

	@Autowired
	UserRepo userRepo;

//	private static final Logger logger = LogManager.getLogger(CommonDao.class);

	// User related functions
	public WellnessUser fetchUser(String userName) {
		return userRepo.findByUserName(userName);
	}

	// Enquiries related functions
	public List<Enquiries> fetchEnquiries(WellnessUser user) {
		return enquiryRepo.findByUser(user);
	}

	public Enquiries addEnquiry(Enquiries enquiry) {
		return enquiryRepo.save(enquiry);
	}

	// Product related functions
	public List<Products> fetchProducts(WellnessUser user) {
		return productsRepo.findByUser(user);
	}

	public Products findProduct(Long id) {
		return productsRepo.findProduct(id);
	}

	public Products addProduct(Products product) {
		return productsRepo.save(product);
	}

	public void deleteProduct(Long id) {
		productsRepo.deleteById(id);
	}

	// Result related functions
	public List<Results> fetchResults(WellnessUser user) {
		return resultsRepo.findByUser(user);
	}

	public Results addResult(Results result) {
		return resultsRepo.save(result);
	}

	public Results findResult(Long id) {
		return resultsRepo.findResult(id);
	}

	// Contact related funtions
	public Contact fetchContact(WellnessUser user) {
		return contactsRepo.findByUser(user);
	}

	public Contact findContact(Long id) {
		return contactsRepo.findContact(id);
	}

	public Contact addContact(Contact contact) {
		return contactsRepo.save(contact);
	}
}
