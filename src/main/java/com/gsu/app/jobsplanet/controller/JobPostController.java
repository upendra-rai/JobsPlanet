package com.gsu.app.jobsplanet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gsu.app.jobsplanet.dtos.JobDto;
import com.gsu.app.jobsplanet.entity.JobPost;
import com.gsu.app.jobsplanet.entity.Jobs;
import com.gsu.app.jobsplanet.service.JobPostService;
import com.gsu.app.jobsplanet.service.JobsService;

@RestController
@RequestMapping("/jobPost")
public class JobPostController {

	@Autowired
	private JobPostService jobPostService;

	@PostMapping("/save")
	public JobPost createJobPost(@RequestBody JobPost jobPost) {
		return jobPostService.createJobPost(jobPost);
	}

	@PutMapping("/{id}")
	public JobPost updateJobPost(@PathVariable long id, @RequestBody JobPost jobPost) {
		return jobPostService.updateJobPost(id, jobPost);
	}

	@GetMapping("/{jobPostId}")
	public JobPost getJobPostById(@PathVariable long jobPostId) {
		return jobPostService.getJobPostById(jobPostId);
	}

	@GetMapping("/search/{jobType}")
	public JobPost searchJobPostType(@PathVariable String jobType) {
		return jobPostService.searchJobPostType(jobType);
	}

	@GetMapping("/search/{jobType}/location/{locationId}")
	public JobPost advanceSearch(@PathVariable String jobType, @PathVariable String locationId) {
		return jobPostService.advanceSearch(jobType,locationId);
	}

	@GetMapping
	public List<JobPost> getAllJobPostList() {
		return jobPostService.getAllJobPostList();
	}

	@DeleteMapping("/deletebyId/{id}")
	public void deleteJobPost(@PathVariable("id") Long id) {
		jobPostService.deleteJobPost(id);
	}

	@PostMapping("/deletebyId/{id}")
	public void submitJobPost(@PathVariable Long jobId, @PathVariable Long jobSeekerId) {
		jobPostService.submitJobPost(jobId, jobSeekerId);
	}

}
