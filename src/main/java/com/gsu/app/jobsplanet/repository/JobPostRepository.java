package com.gsu.app.jobsplanet.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gsu.app.jobsplanet.entity.JobPost;
import com.gsu.app.jobsplanet.entity.Jobs;

@Repository
public interface JobPostRepository extends JpaRepository<JobPost, Long> {

	Optional<JobPost> findByJobType(String jobType);

	//Optional<JobPost> findByTypeAndAddress(String jobType, String locationId);
	

}