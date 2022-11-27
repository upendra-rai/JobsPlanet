package com.gsu.app.jobsplanet.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "recruiter")
public class Recruiter {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long recruiterId;

	@NotNull(message = "Full Name can not be null")
	@Size(max = 100, min = 5, message = "criteria not met")
	private String fullName;

	@NotNull(message = "UserName can not be null")
	@Size(max = 100, min = 5, message = "criteria not met")
	private String userName;

	@NotNull(message = "Email can not be null")
	@Size(max = 30, min = 5, message = "criteria not met")
	private String email;

	@Size(max = 15, min = 5, message = "criteria not met")
	private String mobileNumber;

	private String profilePic;

	private String resume;

	private String location;

	private String experiance;

	private String industry;

	private String userSkills;

	private String companyName;

	private String companyEstYear;

	private String companyEmail;

	private String companyAddress;

	private String companyCity;

	private String companyState;

	private String companyZipCode;

	private String companyType;

	private String companyGstNumber;

	private String userType;


}
