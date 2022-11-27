package com.gsu.app.jobsplanet.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gsu.app.jobsplanet.entity.JobPost;
import com.gsu.app.jobsplanet.entity.JobSeeker;
import com.gsu.app.jobsplanet.entity.Recruiter;
import com.gsu.app.jobsplanet.repository.JobPostRepository;
import com.gsu.app.jobsplanet.repository.JobSeekerRepository;
import com.gsu.app.jobsplanet.repository.RecruiterRepository;

@Service
public class JobPostServiceImpl implements JobPostService {

	@Autowired
	private JobPostRepository jobPostRepository;

	@Autowired
	private JobSeekerRepository jobSeekerRepository;

	@Autowired
	private RecruiterRepository recruiterRepository;

	@Override
	public List<JobPost> getAllJobPostList() {
		return jobPostRepository.findAll();
	}

	@Override
	public JobPost createJobPost(JobPost jobPost) {
		Recruiter recruiter = recruiterRepository.findById(jobPost.getRecruiter().getRecruiterId())
				.orElseThrow(() -> new RuntimeException("RecruiterId Not Found"));
		jobPost.setRecruiter(recruiter);
		jobPostRepository.save(jobPost);
		return jobPost;
	}

	@Override
	public JobPost updateJobPost(long id, JobPost jobPost) {
		JobPost updateJobPost = jobPostRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Job Id Not Found"));
		updateJobPost.setJobTitle(jobPost.getJobTitle());
		updateJobPost.setEmployeeWorkPlace(jobPost.getEmployeeWorkPlace());
		updateJobPost.setStartingDate(jobPost.getStartingDate());
		updateJobPost.setDeadLineDate(jobPost.getDeadLineDate());
		updateJobPost.setMinimumPay(jobPost.getMinimumPay());
		updateJobPost.setMaximumPay(jobPost.getMaximumPay());
		updateJobPost.setRate(jobPost.getRate());
		updateJobPost.setResume(jobPost.getResume());
		updateJobPost.setNoOfOpening(jobPost.getNoOfOpening());
		updateJobPost.setJobType(jobPost.getJobType());
		updateJobPost.setJobSchedule(jobPost.getJobSchedule());
		updateJobPost.setJobSuplimentalPay(jobPost.getJobSuplimentalPay());
		updateJobPost.setJobOfferBenefit(jobPost.getJobOfferBenefit());
		updateJobPost.setJobLocation(jobPost.getJobLocation());
		updateJobPost.setDescripation(jobPost.getDescripation());
		return jobPostRepository.save(updateJobPost);
	}

	@Override
	public JobPost getJobPostById(long jobsId) {
		return jobPostRepository.findById(jobsId).orElseThrow(() -> new RuntimeException("Job Id Not Found"));
	}

	@Override
	public void deleteJobPost(long jobsId) {
		jobPostRepository.deleteById(jobsId);
	}

	@Override
	public JobPost searchJobPostType(String jobType) {
		return jobPostRepository.findByJobType(jobType).orElseThrow(() -> new RuntimeException("Job Type Not Found"));
	}

	@Override
	@Transactional
	public void submitJobPost(Long jobId, Long jobseekerId) {
		JobPost jobPost = jobPostRepository.findById(jobId).orElseThrow(() -> new RuntimeException("Job Id Not Found"));
		JobSeeker jobSeeker = jobSeekerRepository.findById(jobseekerId)
				.orElseThrow(() -> new RuntimeException("Job Seeker Id Not Found"));
	}

	@Override
	@Transactional
	public JobPost advanceSearch(String jobType, String locationId) {
		return null;
	}

}
