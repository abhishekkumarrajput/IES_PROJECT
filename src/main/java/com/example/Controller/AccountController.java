package com.example.Controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Binding.UnlockFormDto;
import com.example.Binding.UserDto;
import com.example.Service.AccountService;

@RestController
public class AccountController {
	private Logger logger= LoggerFactory.getLogger(AccountController.class);
	
	
	@Autowired
	private AccountService accountService;
	
	//createAccount
	@PostMapping("/user")
	public ResponseEntity<String>creatAccount(@RequestBody UserDto userDto ){
		
		logger.debug("Account Creation Process Started...");
		boolean status = this.accountService.createUser(userDto);
		if(status) {
			
			logger.info("Account Created Successfully");
			return new ResponseEntity<String>("Account Successful login",HttpStatus.CREATED);   //201 status code
		}else {
			logger.info("Account Creation Failed");
			return	new ResponseEntity<String>("Account Creations falied",HttpStatus.INTERNAL_SERVER_ERROR);  //500 status code
		}
	}
	
	//view AccountForm
	@GetMapping("/Alluser")
public ResponseEntity<List<UserDto>> getAllUser(){
				return ResponseEntity.ok(this.accountService.getAllUSer());
	}
	
	//getUser
	@GetMapping("/user/{userId}")
	public ResponseEntity<UserDto>updateUser(@PathVariable Integer userId){
		logger.debug(" Users Accounts fatching Start....");
		return ResponseEntity.ok(this.accountService.getUserById(userId));
	}
	
	//update Account
	@PutMapping("/user/{userId}/{status}")
	public ResponseEntity<List<UserDto>>updateAccount(@PathVariable ("userId")Integer userId,@PathVariable("status")String status){
	    logger.debug("User Account update process Start....");
 this.accountService.changAccStatus(userId, status);
 logger.debug("User Account update process started ");
 logger.info("User Account status updated successfully");
 List<UserDto> allUSer = accountService.getAllUSer();
		return new ResponseEntity<>(allUSer,HttpStatus.OK);	
	}
	
	//unlock Account
	
	@PostMapping("/unlock")
	public ResponseEntity<String> unlockAccount( @RequestBody UnlockFormDto unlockForm) {
		if(unlockForm.getConformPassword().equals(unlockForm.getNewPassword())) {
			boolean unlockAccount = this.accountService.unlockAccount(unlockForm);
			if(unlockAccount) {	
				return  ResponseEntity.ok("Successful unlocked");
			}else {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Something Went Wrong");
			}
		}
		else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("newPassword && conformpassword not match");
		}
	}

}
