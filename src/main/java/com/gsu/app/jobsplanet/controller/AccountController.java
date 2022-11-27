package com.gsu.app.jobsplanet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gsu.app.jobsplanet.entity.Recruiter;
import com.gsu.app.jobsplanet.entity.Users;
import com.gsu.app.jobsplanet.service.AccountService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/account")
public class AccountController {

	@Autowired
	private AccountService accountService;

	@PostMapping("/register")
	public ResponseEntity<Void> registerAccount(@RequestBody Users users) {
		log.info(">> registerAccount({})", users);
		accountService.registerAccount(users);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	@PostMapping("/login")
	public String logIn(@RequestHeader String username, @RequestHeader String Password) {
		log.info(">> logIn({})", username,Password);
		return accountService.logIn( username,Password);
	}

//	@PutMapping("/reset")
//	public ResponseEntity<Void> resetPassword(@RequestBody ResetPassword resetPassword) {
//		log.info(">> resetPassword({})", resetPassword);
//		accountService.resetPassword(resetPassword);
//		return ResponseEntity.status(HttpStatus.CREATED).build();
//	}
//
//	@PostMapping("/forgetPassword")
//	public ResponseEntity<Void> forgetPassword(@RequestBody ForgetPassword forgetPassword) {
//		log.info(">> forgetPassword({})", forgetPassword);
//		accountService.forgetPassword(forgetPassword);
//		return ResponseEntity.status(HttpStatus.CREATED).build();
//	}

}
