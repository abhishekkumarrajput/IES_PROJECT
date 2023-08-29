package com.example.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Binding.DashboardDto;
import com.example.Binding.LoginFormDto;
import com.example.Binding.UserDto;
import com.example.Service.AccountService;
import com.example.Service.UserService;



@RestController
//@RequestMapping("")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private AccountService accountService;
	
	
	//login Account
	@PostMapping("login")
	public String loginUser(@RequestBody LoginFormDto loginForm) {
		String status = userService.login(loginForm);
		if(status.contains("Success")) {	
			return "redirect:/dashboard?email="+loginForm.getEmail();       //agar successfully login huaa hai toh Dashboard wale page per redirect kar de;
		}
		else {
			return status;
		}
	}
	
	
	//getDashboard
	@GetMapping("/dashboard")	
public ResponseEntity<DashboardDto>bulidDashboard(@RequestParam("email")String email){
	UserDto user = userService.getUserByEmail(email);	
DashboardDto dashBoardCard = this.userService.fetchDashboardInfor();
dashBoardCard.setUserDto(user);
return new ResponseEntity<DashboardDto>(dashBoardCard,HttpStatus.OK);
	
	}
	
	//Forgot Password
	@PostMapping("/forgotpassword")
	public String forgotPwdPage( @RequestParam("email") String email,Model model) {
	 boolean status = this.userService.forgotPwd(email);	
		if(status) {
			model.addAttribute("succMsg","Password Sent Successfully To Your Email");
		}else {	
			model.addAttribute("errMsg", "Invalid msg");
		}	
  return "forgotPwd";
	}	
}
