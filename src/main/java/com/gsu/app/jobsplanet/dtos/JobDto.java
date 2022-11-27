package com.gsu.app.jobsplanet.dtos;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.gsu.app.jobsplanet.entity.Recruiter;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class JobDto {

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

	private Long recruiterId;

}
