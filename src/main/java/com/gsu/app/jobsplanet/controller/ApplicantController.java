package com.gsu.app.jobsplanet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gsu.app.jobsplanet.entity.JobSeeker;
import com.gsu.app.jobsplanet.service.JobSeekerService;

@RestController
@RequestMapping("/applicants")
public class ApplicantController {

	@Autowired
	private JobSeekerService jobSeekerService;

	@GetMapping
	public ResponseEntity<List<JobSeeker>> getAllJobSeekerList() {
		return ResponseEntity.ok(jobSeekerService.getAllJobSeekerList());
	}

	@GetMapping("/{id}")
	public ResponseEntity<JobSeeker> getJobSeekerById(@PathVariable Long id) {
		return ResponseEntity.ok(jobSeekerService.getJobSeekerById(id));
	}

	@PutMapping("/{id}")
	public ResponseEntity<Void> updateJobSeeker(@PathVariable Long id, @RequestBody JobSeeker jobSeeker) {
		jobSeekerService.updateJobSeeker(id, jobSeeker);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteJobSeeker(@PathVariable Long id) {
		jobSeekerService.deleteJobSeeker(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

}
