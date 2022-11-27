package com.gsu.app.jobsplanet.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "users")
public class Users extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long userId;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "Job_seeker_id")
	private JobSeeker jobSeeker;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "recruiter_id")
	private Recruiter recruiter;

	@NotNull(message = "FirstName can not be null")
	private String fullName;

	@NotNull(message = "UserName can not be null")
	private String userName;

	@NotNull(message = "UserName can not be null")
	@Column(name = "email",unique = true)
	private String email;

	private String password;

	private String mobileNumber;

	private String profilePic;

	private String resume;

	private String location;

	private String experiance;

	@Enumerated(EnumType.STRING)
	private Industry industry;

	private String userSkills;

	public enum Industry {
		TECHNICAL_SUPPORT, PROGRAMMER, WEB_DEVELOPER, COMPUTER_SYSTEM_ANALYST, IT_SECUTIRY, NETWORK_ENGINEER;
	}

	private String companyName;

	private String companyEstYear;

	private String companyEmail;

	private String companyAddress;

	private String companyCity;

	private String companyState;

	private String companyZipCode;

	@Enumerated(EnumType.STRING)
	private CompanyType companyType;

	private String companyGstNumber;

	@Enumerated(EnumType.STRING)
	private UserType userType;

	public enum UserType {
		RECRUITER, JOB_SEEKER;
	}

	public enum CompanyType {
		COMPANY, CONSULTANT;
	}

}
