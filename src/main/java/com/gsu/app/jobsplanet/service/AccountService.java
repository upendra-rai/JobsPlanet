package com.gsu.app.jobsplanet.service;

import com.gsu.app.jobsplanet.entity.Users;

public interface AccountService {

	void registerAccount(Users users);

	String logIn(String username, String password);

//	void resetPassword(ResetPassword resetPassword);
//
//	void forgetPassword(ForgetPassword forgetPassword);

}
