package com.gsu.app.jobsplanet.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gsu.app.jobsplanet.dtos.InterViewDto;
import com.gsu.app.jobsplanet.dtos.JobDto;
import com.gsu.app.jobsplanet.entity.ContactUs;
import com.gsu.app.jobsplanet.entity.Interview;
import com.gsu.app.jobsplanet.entity.JobOverView;
import com.gsu.app.jobsplanet.entity.JobPost;
import com.gsu.app.jobsplanet.entity.JobSeeker;
import com.gsu.app.jobsplanet.entity.Jobs;
import com.gsu.app.jobsplanet.entity.Recruiter;
import com.gsu.app.jobsplanet.repository.ContactUsRepository;
import com.gsu.app.jobsplanet.repository.InterviewRepository;
import com.gsu.app.jobsplanet.repository.JobOverViewRepository;
import com.gsu.app.jobsplanet.repository.JobSeekerRepository;
import com.gsu.app.jobsplanet.repository.JobsRepository;
import com.gsu.app.jobsplanet.repository.RecruiterRepository;

@Service
public class JobOverViewServiceImpl implements JobOverViewService {

	@Autowired
	private JobOverViewRepository jobOverViewRepository;

	@Transactional
	@Override
	public List<JobOverView> getAllJobOverViewList() {
		return jobOverViewRepository.findAll();
	}

	@Override
	@Transactional
	public JobOverView createJobOverView(JobOverView jobOverView) {
		return jobOverViewRepository.save(jobOverView);
	}

	@Override
	@Transactional
	public JobOverView getJobOverViewById(long jobOverViewId) {
		return jobOverViewRepository.findById(jobOverViewId)
				.orElseThrow(() -> new RuntimeException("Job Id Not Found"));
	}

	@Override
	@Transactional
	public JobOverView updateJobOverView(long jobOverViewId, JobOverView jobOverView) {
		JobOverView updateJobOverView = jobOverViewRepository.findById(jobOverViewId)
				.orElseThrow(() -> new RuntimeException("jobOverViewId Not Found"));
		updateJobOverView.setVacancy(jobOverView.getVacancy());
		updateJobOverView.setApplicationDate(jobOverView.getApplicationDate());
		updateJobOverView.setJobNature(jobOverView.getJobNature());
		updateJobOverView.setLocation(jobOverView.getLocation());
		updateJobOverView.setPosteDate(jobOverView.getPosteDate());
		updateJobOverView.setSalary(jobOverView.getSalary());
		jobOverViewRepository.save(updateJobOverView);
		return updateJobOverView;
	}

	@Override
	@Transactional
	public void deleteJobOverView(long jobOverviewId) {
		jobOverViewRepository.deleteById(jobOverviewId);
	}

}
