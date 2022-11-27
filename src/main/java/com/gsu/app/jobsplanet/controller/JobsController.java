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
import com.gsu.app.jobsplanet.entity.Jobs;
import com.gsu.app.jobsplanet.service.JobsService;

@RestController
@RequestMapping("/jobs")
public class JobsController {

	@Autowired
	private JobsService jobsService;

	@PostMapping("/save")
	public Jobs createProject(@RequestBody JobDto jobs) {
		return jobsService.createJobs(jobs);
	}

	@PutMapping("/{id}")
	public Jobs updateProject(@PathVariable long id, @RequestBody Jobs jobs) {
		return jobsService.updateJobs(id, jobs);
	}

	@GetMapping("/{jobsId}")
	public Jobs getJobsById(@PathVariable long jobsId) {
		return jobsService.getJobsById(jobsId);
	}

	@GetMapping("/search/{jobType}")
	public Jobs searchJobType(@PathVariable String jobType) {
		return jobsService.searchJobType(jobType);
	}

	@GetMapping("/search/{jobType}/location/{locationId}")
	public Jobs advanceSearch(@PathVariable String jobType, @PathVariable String locationId) {
		return jobsService.advanceSearch(jobType,locationId);
	}

	@GetMapping
	public List<Jobs> getallJobs() {
		return jobsService.getAllJobsList();
	}

	@DeleteMapping("/deletebyId/{id}")
	public void deleteJobs(@PathVariable("id") Long jobs) {
		jobsService.deleteJobs(jobs);
	}

	@PostMapping("/deletebyId/{id}")
	public void submitJobPost(@PathVariable Long jobId, @PathVariable Long jobSeekerId) {
		jobsService.submitJobPost(jobId, jobSeekerId);
	}

}
