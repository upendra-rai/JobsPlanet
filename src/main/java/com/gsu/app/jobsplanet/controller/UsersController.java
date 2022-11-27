package com.gsu.app.jobsplanet.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gsu.app.jobsplanet.entity.Users;
import com.gsu.app.jobsplanet.service.UsersService;

@RestController
@RequestMapping("/user")
public class UsersController {

	@Autowired
	private UsersService applUserService;

	@PostMapping("/create")
	public Users createUser(@Valid @RequestBody Users applUsers) {

		Users app = null;
		try {
			app = applUserService.createUser(applUsers);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return app;
	}

	@PostMapping("/update")
	public Users updateUser(@Valid @RequestBody Users applUsers) {
		return applUserService.updateUser(applUsers);
	}

	@GetMapping("/getById")
	public Optional<Users> getUserById(@RequestParam("id") Long applUsersId) {
		return applUserService.getUserById(applUsersId);
	}

	@GetMapping("/login")
	public Users login(@RequestParam("username") String username, @RequestParam("password") String passowrd) {
		return applUserService.login(username, passowrd);
	}

	@GetMapping("/getAll")
	public List<Users> getAllUser() {
		return applUserService.getAllUserList();
	}

	@GetMapping("/getAllUserByUserType")
	public List<Users> getAllUserByUserType(String userType) {
		return applUserService.getAllUserListByUserType(userType);
	}

	@PostMapping("/resetPassword")
	public int resetPassword(@RequestParam("id") Long applUsersId, @RequestParam("password") String passowrd) {
		return applUserService.resetPassword(applUsersId, passowrd);
	}

	@DeleteMapping("/deletebyId/{id}")
	public void deleteUser(@PathVariable("id") int applUsers) {
		try {
			applUserService.deleteUser(applUsers);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
