package com.gsu.app.jobsplanet.service;

import java.util.List;
import java.util.Optional;

import com.gsu.app.jobsplanet.dtos.JobDto;
import com.gsu.app.jobsplanet.entity.ContactUs;
import com.gsu.app.jobsplanet.entity.JobPost;
import com.gsu.app.jobsplanet.entity.Jobs;

public interface JobPostService {
	public List<JobPost> getAllJobPostList();

	public JobPost createJobPost(JobPost jobPost);

	public JobPost updateJobPost(long id, JobPost jobPost);

	public JobPost getJobPostById(long jobsId);

	public void deleteJobPost(long jobsId);

	public JobPost searchJobPostType(String jobType);

	public void submitJobPost(Long jobId, Long jobseekerId);

	public JobPost advanceSearch(String jobType, String locationId);

}
