package com.dev.wellness.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "contact_details")
public class Contact {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	@JsonIgnore
	private WellnessUser user;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "contact_id")
	private Long id;

	@Column(name = "address")
	private String address;

	@Column(name = "phone", unique = true)
	private String phone;

	@Column(name = "email", unique = true)
	private String email;

	@Column(name = "fb_link", unique = true)
	private String fbLink;

	@Column(name = "insta_link", unique = true)
	private String instaLink;

	@Transient
	private String userName;

	public WellnessUser getUser() {
		return user;
	}

	public void setUser(WellnessUser user) {
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFbLink() {
		return fbLink;
	}

	public void setFbLink(String fbLink) {
		this.fbLink = fbLink;
	}

	public String getInstaLink() {
		return instaLink;
	}

	public void setInstaLink(String instaLink) {
		this.instaLink = instaLink;
	}

	@Override
	public String toString() {
		return "Contact [user=" + user + ", id=" + id + ", address=" + address + ", phone=" + phone + ", email=" + email
				+ ", fbLink=" + fbLink + ", instaLink=" + instaLink + "]";
	}

}
