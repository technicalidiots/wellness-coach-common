package com.dev.wellness.models;

import java.util.List;

import com.dev.wellness.entity.Contact;
import com.dev.wellness.entity.Products;
import com.dev.wellness.entity.Results;

public class Output {

	private List<Products> products;

	private List<Results> results;

	private Contact contact;

	public List<Products> getProducts() {
		return products;
	}

	public void setProducts(List<Products> products) {
		this.products = products;
	}

	public List<Results> getResults() {
		return results;
	}

	public void setResults(List<Results> results) {
		this.results = results;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

}
