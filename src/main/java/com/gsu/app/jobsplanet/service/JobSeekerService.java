package com.gsu.app.jobsplanet.service;

import java.util.List;
import java.util.Optional;

import com.gsu.app.jobsplanet.entity.ContactUs;
import com.gsu.app.jobsplanet.entity.JobSeeker;
import com.gsu.app.jobsplanet.entity.Jobs;

public interface JobSeekerService {

	public List<JobSeeker> getAllJobSeekerList();

	public void updateJobSeeker(long jobSeekerId, JobSeeker jobSeeker);

	public JobSeeker getJobSeekerById(long jobSeekerId);

	public void deleteJobSeeker(long jobsId);

}
