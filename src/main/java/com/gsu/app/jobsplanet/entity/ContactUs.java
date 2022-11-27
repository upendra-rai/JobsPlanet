package com.gsu.app.jobsplanet.entity;

import javax.persistence.Entity;
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
@Table(name = "contactus")
public class ContactUs {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@NotNull(message = "Name can not be null")
	@Size(max=100,min=5,message="criteria not met")
	private String name;
	
	@NotNull(message = "Email can not be null")
	@Size(max=100,min=5,message="criteria not met")
	private String email;
	
	@NotNull(message = "Subject can not be null")
	@Size(max=100,min=5,message="criteria not met")
	private String subject;
	
	private String message;

}
