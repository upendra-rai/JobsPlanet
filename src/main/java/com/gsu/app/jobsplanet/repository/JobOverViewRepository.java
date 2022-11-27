package com.gsu.app.jobsplanet.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gsu.app.jobsplanet.entity.JobOverView;
import com.gsu.app.jobsplanet.entity.Jobs;

@Repository
public interface JobOverViewRepository extends JpaRepository<JobOverView, Long> {

	//Optional<Jobs> findByType(String jobType);

//	Optional<Jobs> findByTypeAndAddress(String jobType, String locationId);
	

}