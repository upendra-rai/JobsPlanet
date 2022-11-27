package com.gsu.app.jobsplanet.service;

import java.util.List;
import java.util.Optional;

import com.gsu.app.jobsplanet.dtos.InterViewDto;
import com.gsu.app.jobsplanet.dtos.JobDto;
import com.gsu.app.jobsplanet.entity.ContactUs;
import com.gsu.app.jobsplanet.entity.Interview;
import com.gsu.app.jobsplanet.entity.Jobs;

public interface InterViewService {

	public Interview createInterView(InterViewDto interViewDto);

	public Interview getInterViewById(long interviewId);

	public void deleteInterView(long interviewId);

	public List<Interview> getAllInterViewList();

}
