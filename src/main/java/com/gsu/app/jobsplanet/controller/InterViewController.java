package com.gsu.app.jobsplanet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gsu.app.jobsplanet.dtos.InterViewDto;
import com.gsu.app.jobsplanet.entity.Interview;
import com.gsu.app.jobsplanet.service.InterViewService;

@RestController
@RequestMapping("/interview")
public class InterViewController {

	@Autowired
	private InterViewService interViewService;

	@GetMapping
	public List<Interview> getAllInterViewList() {
		return interViewService.getAllInterViewList();
	}

	@PostMapping("/save")
	public Interview createProject(@RequestBody InterViewDto interViewDto) {
		return interViewService.createInterView(interViewDto);
	}

	@GetMapping("/{jobsId}")
	public Interview getInterViewById(@PathVariable long interviewId) {
		return interViewService.getInterViewById(interviewId);
	}

	@DeleteMapping("/deletebyId/{id}")
	public void deleteInterView(@PathVariable("id") Long interviewId) {
		interViewService.deleteInterView(interviewId);
	}

}
