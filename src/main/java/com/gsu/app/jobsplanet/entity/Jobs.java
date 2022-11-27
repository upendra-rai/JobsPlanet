package com.gsu.app.jobsplanet.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "jobs")
public class Jobs {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotNull(message = "Job Name can not be null")
	@Size(max = 100, message = "criteria not met")
	private String name;

	@NotNull(message = "Job Type can not be null")
	@Size(max = 100, message = "criteria not met")
	private String type;

	private String descripation;

	@NotNull(message = "Job Address can not be null")
	@Size(max = 100, message = "criteria not met")
	private String address;

	@NotNull(message = "Company Name can not be null")
	@Size(max = 100, message = "criteria not met")
	private String companyName;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<JobSeeker> jobSeekers = new HashSet<>();

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "recruiter_id", nullable = false)
	private Recruiter recruiter;

}
