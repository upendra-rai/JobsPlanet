package com.gsu.app.jobsplanet.service;

import java.util.List;
import java.util.Optional;

import com.gsu.app.jobsplanet.dtos.JobDto;
import com.gsu.app.jobsplanet.entity.ContactUs;
import com.gsu.app.jobsplanet.entity.Jobs;

public interface JobsService {
	
	public Jobs createJobs(JobDto jobs);
	public Jobs updateJobs(long id,Jobs jobs);
	public Jobs getJobsById(long jobsId);
	public void deleteJobs(long jobsId);
	public List<Jobs> getAllJobsList();
	public Jobs searchJobType(String jobType);
	public void submitJobPost(Long jobId, Long jobseekerId);
	public Jobs advanceSearch(String jobType, String locationId);

}

