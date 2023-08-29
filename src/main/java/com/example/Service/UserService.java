package com.example.Service;

import com.example.Binding.DashboardDto;
import com.example.Binding.LoginFormDto;
import com.example.Binding.UserDto;

public interface UserService {
	
	    //loginForm
		public String login(LoginFormDto loginFormDto);
		
		//forgot password
		public boolean forgotPwd(String email);

		//Dashboard Information
		public DashboardDto fetchDashboardInfor();
		
		//
		public UserDto getUserByEmail(String email);
		
}
