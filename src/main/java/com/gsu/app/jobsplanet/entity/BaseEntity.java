package com.gsu.app.jobsplanet.entity;

import java.sql.Date;

import javax.persistence.MappedSuperclass;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public class BaseEntity {
	
	private String createdby;
	
	//@JsonFormat(shape=JsonFormatTypes.STRING, pattern="dd-MM-yyyy")
	private Date createdDate;
	private String updatedBy;
	
	//@JsonFormat(shape=JsonFormatTypes.STRING, pattern="dd-MM-yyyy")
	private Date updatedDate;

}
