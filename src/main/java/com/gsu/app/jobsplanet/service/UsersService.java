package com.gsu.app.jobsplanet.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.gsu.app.jobsplanet.entity.Users;

@Service
public interface UsersService {
	
	public Users createUser(Users applUsers);
	public Users updateUser(Users applUsers);
	public Optional<Users> getUserById(long applUsersId);
	public List<Users> getAllUserList();
	public List<Users> getAllUserListByUserType(String userType);
	public void deleteUser(long applUsersId);
	
	public Users login(String username, String password);
	public int resetPassword(long userId, String Password);

}
