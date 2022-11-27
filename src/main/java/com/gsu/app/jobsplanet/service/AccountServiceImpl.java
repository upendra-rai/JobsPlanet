package com.gsu.app.jobsplanet.service;

import java.util.Objects;

import javax.persistence.RollbackException;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.gsu.app.jobsplanet.entity.JobSeeker;
import com.gsu.app.jobsplanet.entity.Recruiter;
import com.gsu.app.jobsplanet.entity.Users;
import com.gsu.app.jobsplanet.entity.Users.UserType;
import com.gsu.app.jobsplanet.repository.JobSeekerRepository;
import com.gsu.app.jobsplanet.repository.RecruiterRepository;
import com.gsu.app.jobsplanet.repository.UsersRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private UsersRepository userRepository;

	@Autowired
	private JobSeekerRepository jobSeekerRepository;

	@Autowired
	private RecruiterRepository recruiterRepository;

	@Override
	public void registerAccount(Users user) {
		log.info(">> registerAccount({})", user);
		if (UserType.JOB_SEEKER.equals(user.getUserType())) {
			JobSeeker jobSeeker = new JobSeeker();
			jobSeeker.setFullName(user.getFullName());
			jobSeeker.setUserName(user.getUserName());
			jobSeeker.setEmail(user.getEmail());
			jobSeeker.setMobileNumber(user.getMobileNumber());
			jobSeeker.setLocation(user.getLocation());
			jobSeeker.setExperiance(user.getExperiance());
			jobSeeker.setIndustry(user.getIndustry().toString());
			jobSeeker.setUserSkills(user.getUserSkills());
			jobSeekerRepository.save(jobSeeker);
			user.setJobSeeker(jobSeeker);
		}
		if (UserType.RECRUITER.equals(user.getUserType())) {
			Recruiter recruite = new Recruiter();
			recruite.setFullName(user.getFullName());
			recruite.setEmail(user.getEmail());
			recruite.setUserName(user.getUserName());
			recruite.setMobileNumber(user.getMobileNumber());
			recruite.setLocation(user.getLocation());
			recruite.setExperiance(user.getExperiance());
			recruite.setIndustry(user.getIndustry().toString());
			recruite.setUserSkills(user.getUserSkills());
			recruite.setCompanyName(user.getCompanyName());
			recruite.setCompanyEmail(user.getCompanyEmail());
			recruite.setCompanyEstYear(user.getCompanyEstYear());
			recruite.setCompanyAddress(user.getCompanyAddress());
			recruite.setCompanyCity(user.getCompanyCity());
			recruite.setCompanyState(user.getCompanyState());
			recruite.setCompanyZipCode(user.getCompanyZipCode());
			recruite.setCompanyType(user.getCompanyType().toString());
			recruite.setCompanyGstNumber(user.getCompanyGstNumber());
			recruiterRepository.save(recruite);
			user.setRecruiter(recruite);
		}
		userRepository.save(user);
	}

	@Override
	public String logIn(String username, String password) {
		if (StringUtils.isNotBlank(username) && StringUtils.isNotBlank(password)) {
			Users users = userRepository.findByEmailAndPassword(username, password)
					.orElseThrow(() -> new RuntimeException("UserName and Password are Incorrect"));
			Long RercuiterId = null;
			try {
				if (!Long.valueOf(users.getRecruiter().getRecruiterId()).equals(null)) {
					RercuiterId = RercuiterId = users.getRecruiter().getRecruiterId();

				}
			} catch (NullPointerException e) {
				RercuiterId = null;
			}
			Long jobSeekerId = null;
			try {
				if (!Long.valueOf(users.getJobSeeker().getJobSeekerId()).equals(null)) {
					jobSeekerId = users.getJobSeeker().getJobSeekerId();
				}
			} catch (NullPointerException e) {
				RercuiterId = null;
			}
			return "Successfully LoggedIn" + " RercuiterId= " + RercuiterId + " jobSeekerId= " + jobSeekerId;
		} else {
			return "UserName and Password are Incorrect";
		}
	}

//	@Override
//	@Transactional
//	public void resetPassword(ResetPassword resetPassword) {
//		log.info(">> resetPassword({})", resetPassword);
//		User user = userRepository.findByToken(resetPassword.getToken())
//				.orElseThrow(() -> new ServiceException(ErrorCode.TOKEN_NOT_INVALID, resetPassword.getToken()));
//		user.setPassword(bCryptPasswordEncoder.encode(resetPassword.getConfirmPassword()));
//	}
//
//	@Override
//	public void forgetPassword(ForgetPassword forgetPassword) {
//		User user = userRepository.findByEmail(forgetPassword.getEmail())
//				.orElseThrow(() -> new ServiceException(ErrorCode.TOKEN_NOT_INVALID, forgetPassword.getEmail()));
//		user.setToken(UUID.randomUUID().toString());
//	}

}
