package com.gsu.app.jobsplanet.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gsu.app.jobsplanet.entity.JobSeeker;
import com.gsu.app.jobsplanet.entity.Users;
import com.gsu.app.jobsplanet.repository.JobSeekerRepository;
import com.gsu.app.jobsplanet.repository.UsersRepository;

@Service
public class JobSeekerServiceImpl implements JobSeekerService {

	@Autowired
	JobSeekerRepository jobSeekerRepository;
	
	@Autowired
	private UsersRepository usersRepository;

	@Override
	@Transactional
	public List<JobSeeker> getAllJobSeekerList() {
		return jobSeekerRepository.findAll();
	}

	@Override
	public JobSeeker getJobSeekerById(long jobSeekerId) {
		JobSeeker jobSeeker = jobSeekerRepository.findById(jobSeekerId)
				.orElseThrow(() -> new RuntimeException("JobSeekar Id Not Found"));
		return jobSeeker;
	}

	@Override
	@Transactional
	public void updateJobSeeker(long id, JobSeeker jobSeeker) {
		JobSeeker updateJobSeeker = jobSeekerRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("JobSeekar Id Not Found"));
		updateJobSeeker.setFullName(jobSeeker.getFullName());
		updateJobSeeker.setUserName(jobSeeker.getUserName());
		updateJobSeeker.setEmail(jobSeeker.getEmail());
		updateJobSeeker.setMobileNumber(jobSeeker.getMobileNumber());
		updateJobSeeker.setProfilePic(jobSeeker.getProfilePic());
		updateJobSeeker.setResume(jobSeeker.getResume());
		updateJobSeeker.setLocation(jobSeeker.getLocation());
		updateJobSeeker.setExperiance(jobSeeker.getExperiance());
		updateJobSeeker.setIndustry(jobSeeker.getIndustry());
		updateJobSeeker.setUserSkills(jobSeeker.getUserSkills());
		jobSeekerRepository.save(updateJobSeeker);
	}

	@Override
	public void deleteJobSeeker(long jobSeekerId) {
		JobSeeker jobSeeker = jobSeekerRepository.findById(jobSeekerId)
				.orElseThrow(() -> new RuntimeException("JobSeekar Id Not Found"));
		Users users=usersRepository.findByJobSeeker(jobSeeker).orElseThrow(() -> new RuntimeException("JobSeekar Id Not Found"));
		usersRepository.delete(users);
		jobSeekerRepository.delete(jobSeeker);
	}

}
