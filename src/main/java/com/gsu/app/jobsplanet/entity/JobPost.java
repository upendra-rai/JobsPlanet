package com.gsu.app.jobsplanet.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "job_post")
public class JobPost {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Size(max = 100, message = "criteria not met")
	private String jobTitle;

	private String employeeWorkPlace;

	private Date startingDate;

	private Date deadLineDate;

	private String minimumPay;

	private String maximumPay;

	private String rate;

	private String resume;

	private String noOfOpening;

	private String jobType;

	private String jobSchedule;

	private String jobSuplimentalPay;

	private String jobOfferBenefit;

	private String jobLocation;

	private String descripation;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "recruiter_id", nullable = false)
	private Recruiter recruiter;

}
