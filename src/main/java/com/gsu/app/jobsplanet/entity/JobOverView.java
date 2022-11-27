package com.gsu.app.jobsplanet.entity;

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
@Table(name = "job_overview")
public class JobOverView {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String posteDate;
	private String location;
	private String vacancy;
	private String jobNature;
	private String salary;
	private String applicationDate;

}
