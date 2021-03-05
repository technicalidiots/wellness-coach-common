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
@Table(name = "result_details")
public class Results {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	@JsonIgnore
	private WellnessUser user;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "result_id")
	private Long id;

	@Column(name = "customer_name")
	private String custName;

	@Column(name = "customer_desc")
	private String custDesc;

	@Column(name = "customer_img")
	private String custImage;

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

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getCustDesc() {
		return custDesc;
	}

	public void setCustDesc(String custDesc) {
		this.custDesc = custDesc;
	}

	public String getCustImage() {
		return custImage;
	}

	public void setCustImage(String custImage) {
		this.custImage = custImage;
	}

	@Override
	public String toString() {
		return "Results [user=" + user + ", id=" + id + ", custName=" + custName + ", custDesc=" + custDesc
				+ ", custImage=" + custImage + ", userName=" + userName + "]";
	}

}
