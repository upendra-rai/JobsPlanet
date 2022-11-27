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
@Table(name = "job_seeker")
public class JobSeeker {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long jobSeekerId;

	@NotNull(message = "Full Name can not be null")
	private String fullName;

	@NotNull(message = "UserName can not be null")
	private String userName;

	@NotNull(message = "Email can not be null")
	private String email;

	private String mobileNumber;

	private String profilePic;

	private String resume;

	private String location;

	private String experiance;

	private String industry;

	@NotNull(message = "Company Name can not be null")
	private String userSkills;

	

}
