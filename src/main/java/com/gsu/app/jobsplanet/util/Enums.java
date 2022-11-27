package com.gsu.app.jobsplanet.util;

public class Enums {
	
	public enum UserType { 
		Developer, QA, Support, Admin, Client 
	}  

	public enum DefectStatus { 
		New, Assigned, InProgress, Fixed, Retest, ReOpen, Closed 
	}  
	
	public enum Environment { 
		Devlopment, Integration, UAT, Simulation, Production 
	}  
	
	public enum DefectType { 
		Database, Backend, Frontend, Server, Devops, Infra
	}  
	
	public enum Priority { 
		Low, Medium, High
	}  
}
