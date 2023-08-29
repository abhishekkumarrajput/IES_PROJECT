package com.example.Service;

import java.util.List;

import com.example.Binding.UserDto;
import com.example.Binding.LoginFormDto;
import com.example.Binding.UnlockFormDto;
import com.example.Model.UserEntity;

public interface AccountService {

	//createUser   //updateUser ke liye hum same method rekh sakte hai no need to required another method for update 
	
	public boolean createUser(UserDto userFormDto);
	
	//getAllUser
	
	public List<UserDto>getAllUSer();
	
	//getUserById
	
	public UserDto getUserById(Integer userId);
	   
  //change Account Status active or De-Active account based on accountId and status
	
	public String changAccStatus(Integer accId,String status);
	
	//unlockForm
 public boolean unlockAccount(UnlockFormDto unlockFormDto);
			
	
	
}
