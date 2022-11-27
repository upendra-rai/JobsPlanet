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
import com.gsu.app.jobsplanet.entity.JobOverView;
import com.gsu.app.jobsplanet.entity.Jobs;
import com.gsu.app.jobsplanet.service.JobOverViewService;
import com.gsu.app.jobsplanet.service.JobsService;

@RestController
@RequestMapping("/overView")
public class JobOverViewController {

	@Autowired
	private JobOverViewService jobOverViewService;

	@PostMapping("/save")
	public JobOverView createProject(@RequestBody JobOverView jobOverView) {
		return jobOverViewService.createJobOverView(jobOverView);
	}

	@PutMapping("/{id}")
	public JobOverView updateProject(@PathVariable long id, @RequestBody JobOverView jobOverView) {
		return jobOverViewService.updateJobOverView(id, jobOverView);
	}

	@GetMapping("/{jobOverViewId}")
	public JobOverView getJobsById(@PathVariable long jobOverViewId) {
		return jobOverViewService.getJobOverViewById(jobOverViewId);
	}

	@GetMapping
	public List<JobOverView> getAllJobOverViewList() {
		return jobOverViewService.getAllJobOverViewList();
	}

	@DeleteMapping("/deletebyId/{jobOverViewId}")
	public void deleteJobOverView(@PathVariable Long jobOverViewId) {
		jobOverViewService.deleteJobOverView(jobOverViewId);
	}

}
