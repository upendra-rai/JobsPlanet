package com.gsu.app.jobsplanet.service;

import java.util.List;
import java.util.Optional;

import com.gsu.app.jobsplanet.dtos.InterViewDto;
import com.gsu.app.jobsplanet.dtos.JobDto;
import com.gsu.app.jobsplanet.entity.ContactUs;
import com.gsu.app.jobsplanet.entity.Interview;
import com.gsu.app.jobsplanet.entity.JobOverView;
import com.gsu.app.jobsplanet.entity.JobPost;
import com.gsu.app.jobsplanet.entity.Jobs;

public interface JobOverViewService {

	public JobOverView createJobOverView(JobOverView jobOverView);

	public JobOverView getJobOverViewById(long jobOverViewId);

	public void deleteJobOverView(long jobOverViewId);

	public List<JobOverView> getAllJobOverViewList();
	
	public JobOverView updateJobOverView(long id, JobOverView jobOverView);

}
