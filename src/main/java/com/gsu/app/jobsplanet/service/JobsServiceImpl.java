package com.gsu.app.jobsplanet.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gsu.app.jobsplanet.dtos.JobDto;
import com.gsu.app.jobsplanet.entity.ContactUs;
import com.gsu.app.jobsplanet.entity.JobPost;
import com.gsu.app.jobsplanet.entity.JobSeeker;
import com.gsu.app.jobsplanet.entity.Jobs;
import com.gsu.app.jobsplanet.entity.Recruiter;
import com.gsu.app.jobsplanet.repository.ContactUsRepository;
import com.gsu.app.jobsplanet.repository.JobSeekerRepository;
import com.gsu.app.jobsplanet.repository.JobsRepository;
import com.gsu.app.jobsplanet.repository.RecruiterRepository;

@Service
public class JobsServiceImpl implements JobsService {

	@Autowired
	private JobsRepository jobsRepository;

	@Autowired
	private JobSeekerRepository jobSeekerRepository;

	@Autowired
	private RecruiterRepository recruiterRepository;

	@Override
	public List<Jobs> getAllJobsList() {
		return jobsRepository.findAll();
	}

	@Override
	public Jobs createJobs(JobDto jobs) {
		Jobs saveJobs = new Jobs();
		Recruiter recruiter = recruiterRepository.findById(jobs.getRecruiterId())
				.orElseThrow(() -> new RuntimeException(" Id Not Found"));
		saveJobs.setName(jobs.getName());
		saveJobs.setAddress(jobs.getAddress());
		saveJobs.setDescripation(jobs.getDescripation());
		saveJobs.setRecruiter(recruiter);
		saveJobs.setType(jobs.getType());
		saveJobs.setCompanyName(jobs.getCompanyName());
		jobsRepository.save(saveJobs);
		return saveJobs;
	}

	@Override
	public Jobs updateJobs(long id, Jobs jobs) {
		Jobs updatejob = jobsRepository.findById(id).orElseThrow(() -> new RuntimeException("Job Id Not Found"));
		updatejob.setName(jobs.getName());
		updatejob.setType(jobs.getType());
		updatejob.setAddress(jobs.getAddress());
		updatejob.setDescripation(jobs.getDescripation());
		return jobsRepository.save(updatejob);
	}

	@Override
	public Jobs getJobsById(long jobsId) {
		return jobsRepository.findById(jobsId).orElseThrow(() -> new RuntimeException("Job Id Not Found"));
	}

	@Override
	public void deleteJobs(long jobsId) {
		jobsRepository.deleteById(jobsId);
	}

	@Override
	public Jobs searchJobType(String jobType) {
		return jobsRepository.findByType(jobType).orElseThrow(() -> new RuntimeException("Job Id Not Found"));
	}

	@Override
	@Transactional
	public void submitJobPost(Long jobId, Long jobseekerId) {
		Jobs jobs = jobsRepository.findById(jobId).orElseThrow(() -> new RuntimeException("Job Id Not Found"));
		JobSeeker jobSeeker = jobSeekerRepository.findById(jobseekerId)
				.orElseThrow(() -> new RuntimeException("Job Seeker Id Not Found"));
		// jobs.setJobSeeker(jobSeeker);
	}

	@Override
	@Transactional
	public Jobs advanceSearch(String jobType, String locationId) {
		return jobsRepository.findByTypeAndAddress(jobType, locationId)
				.orElseThrow(() -> new RuntimeException("Job Id Not Found"));
	}

}
