package com.gsu.app.jobsplanet.repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gsu.app.jobsplanet.entity.JobSeeker;
import com.gsu.app.jobsplanet.entity.Users;
import com.gsu.app.jobsplanet.util.Enums.UserType;

@Repository
@Transactional
public interface UsersRepository extends JpaRepository<Users, Long> {

	@Modifying
	@Query(value = "update users set password = :password where id = :id", nativeQuery = true)
	int resetPassoword(@Param("id") long id, @Param("password") String password);

	List<Users> findByUserType(UserType userType);

	List<Users> findByUserName(String userName);

	Optional<Users> findByEmailAndPassword(String username, String password);

	Optional<Users> findByJobSeeker(JobSeeker jobSeeker);
}
