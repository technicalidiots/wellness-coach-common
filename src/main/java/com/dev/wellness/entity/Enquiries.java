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
@Table(name = "enquiry_details")
public class Enquiries {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	@JsonIgnore
	private WellnessUser user;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "enq_id")
	private Long id;

	@Column(name = "enq_name")
	private String name;

	@Column(name = "enq_phone")
	private String phone;

	@Column(name = "enq_email")
	private String email;

	@Column(name = "enq_status")
	private char status;

	@Column(name = "enq_msg")
	private String msg;

	@Transient
	private String userName;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public char getStatus() {
		return status;
	}

	public void setStatus(char status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "Enquiries [user=" + user + ", id=" + id + ", name=" + name + ", phone=" + phone + ", email=" + email
				+ ", status=" + status + ", msg=" + msg + ", userName=" + userName + "]";
	}

}
