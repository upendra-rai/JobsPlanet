package com.gsu.app.jobsplanet.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gsu.app.jobsplanet.entity.Users;
import com.gsu.app.jobsplanet.repository.UsersRepository;
import com.gsu.app.jobsplanet.util.Enums.UserType;

@Service
public class UsersServiceImpl implements UsersService {

	@Autowired
	UsersRepository applUserRepository;

	public Users createUser(Users applUsers) {
		return applUserRepository.save(applUsers);
	}

	@Override
	public Users updateUser(Users applUsers) {
		return applUserRepository.save(applUsers);
	}

	@Override
	public Optional<Users> getUserById(long applUsersId) {
		return applUserRepository.findById(applUsersId);
	}

	@Override
	public void deleteUser(long applUsersId) {
		applUserRepository.deleteById(applUsersId);
	}

	@Override
	public int resetPassword(long userId, String Password) {
		return applUserRepository.resetPassoword(userId, Password);
	}

	@Override
	public List<Users> getAllUserList() {
		return applUserRepository.findAll();
	}

	@Override
	public List<Users> getAllUserListByUserType(String userType) {

		UserType test = Enum.valueOf(UserType.class, userType);

		return applUserRepository.findByUserType(test);
	}

	@Override
	public Users login(String username, String password) {
		List<Users> app = applUserRepository.findByUserName(username);

		if (app.get(0).getPassword().equals(password))
			return app.get(0);
		else
			throw new RuntimeException();
	}

}
