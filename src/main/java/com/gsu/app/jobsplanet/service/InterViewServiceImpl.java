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
import com.gsu.app.jobsplanet.entity.JobPost;
import com.gsu.app.jobsplanet.entity.JobSeeker;
import com.gsu.app.jobsplanet.entity.Jobs;
import com.gsu.app.jobsplanet.entity.Recruiter;
import com.gsu.app.jobsplanet.repository.ContactUsRepository;
import com.gsu.app.jobsplanet.repository.InterviewRepository;
import com.gsu.app.jobsplanet.repository.JobSeekerRepository;
import com.gsu.app.jobsplanet.repository.JobsRepository;
import com.gsu.app.jobsplanet.repository.RecruiterRepository;

@Service
public class InterViewServiceImpl implements InterViewService {

	@Autowired
	private JobsRepository jobsRepository;

	@Autowired
	private InterviewRepository interviewRepository;

	@Autowired
	private JobSeekerRepository jobSeekerRepository;

	@Override
	public List<Interview> getAllInterViewList() {
		return interviewRepository.findAll();
	}

	@Override
	public Interview createInterView(InterViewDto interViewDto) {
		Interview interview = new Interview();
		JobSeeker jobSeeker = jobSeekerRepository.findById(interViewDto.getJobSeekerId())
				.orElseThrow(() -> new RuntimeException(" Id Not Found"));
		Jobs jobs = jobsRepository.findById(interViewDto.getJobId())
				.orElseThrow(() -> new RuntimeException("Job Id Not Found"));
		interview.setJobSeeker(jobSeeker);
		interview.setJobs(jobs);
		interviewRepository.save(interview);
		return interview;
	}

	@Override
	public Interview getInterViewById(long interviewId) {
		return interviewRepository.findById(interviewId).orElseThrow(() -> new RuntimeException("Job Id Not Found"));
	}

	@Override
	public void deleteInterView(long interviewId) {
		interviewRepository.deleteById(interviewId);
	}

}
