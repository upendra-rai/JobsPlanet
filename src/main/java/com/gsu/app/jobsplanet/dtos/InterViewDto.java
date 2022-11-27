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
public class InterViewDto {

	private Long jobSeekerId;
	
	private Long jobId;

}
