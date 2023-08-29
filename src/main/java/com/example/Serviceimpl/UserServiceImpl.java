package com.example.Serviceimpl;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Binding.DashboardDto;
import com.example.Binding.LoginFormDto;
import com.example.Binding.UserDto;
import com.example.Constant.AppConstant;
import com.example.Model.EligibilityDetails;
import com.example.Model.UserEntity;
import com.example.Repository.EligibilityRepository;
import com.example.Repository.PlansRepository;
import com.example.Repository.UserRepository;
import com.example.Service.UserService;
import com.example.utils.EmailUtils;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private EmailUtils emailUtils;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PlansRepository planRepository;
	
	@Autowired
	private EligibilityRepository eligibilityRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public String login(LoginFormDto loginFormDto) {
	UserEntity user = this.userRepository.findByEmailAndPassword(loginFormDto.getEmail(), loginFormDto.getPassword());
	if(user==null) {
		return AppConstant.invalid_User;
	}
	if(user.getActiveSwitch().equalsIgnoreCase("Y") && user.getStatus().equalsIgnoreCase("Unlocked")) {
		return AppConstant.Success;		
	}else 
	{
	return AppConstant.account_Locked;
	}
	}

	@Override
	public boolean forgotPwd(String email) {
	UserEntity entity = this.userRepository.findByEmail(email);
	if(null==entity) {
		return false;
	}else {
		String subject= "Recover password";
		String body= readEmailBody("FORGOT_PASSWORD_EMAIL_BODY.txt", entity);
		emailUtils.sendEmail(email, subject, body);
		return true;
	}
	}

	@Override
	public DashboardDto fetchDashboardInfor() {
	 long plansCount = planRepository.count();
		
	 List<EligibilityDetails> eliList = eligibilityRepo.findAll();
	 
	 long AproveCount = eliList.stream().filter(ed->ed.getPlansStatus().equals(AppConstant.approve)).count();
	 long deniedCount = eliList.stream().filter(e->e.getPlansStatus().equals(AppConstant.declined)).count();
     double benefitAmount = eliList.stream().mapToDouble(ed->ed.getBenefitAmmount()).sum();
	
	 DashboardDto dasDto= new DashboardDto();
	 dasDto.setPlansCnt(plansCount);
	 dasDto.setDeniedCnt(deniedCount);
	 dasDto.setBeniftAmtGiven(benefitAmount);
	 dasDto.setApprovedCnt(AproveCount);
		return dasDto;
	}

	@Override
	public UserDto getUserByEmail(String email) {
		UserEntity userEntity = userRepository.findByEmail(email);
		UserDto userDto = this.modelMapper.map(userEntity, UserDto.class);
		return userDto;
	}
	
	//read Data from The the file
	private String readEmailBody(String filename,UserEntity user) {
		StringBuilder sb= new StringBuilder();
		try(Stream<String>lines=Files.lines(Paths.get(filename))) {
			lines.forEach(line->{
				line.replace(AppConstant.FNAME, user.getFullName());
				line.replace(AppConstant.PWD, user.getPassword());
				line.replace(AppConstant.EMAIL, user.getEmail());
				sb.append(line);
			});
		}catch (Exception e) {
		e.printStackTrace();
		}
		return sb.toString();	
	}
	

//	//login
//
//	@Override
//	public String login(LoginFormDto loginForm) {
////		User user = this.userRepository.findByEmailAndPassword(loginForm.getEmail(), loginForm.getPassword());
////		if(user==null) {
////			return "invaild user";
////		}
////		if(user.getStatus().equalsIgnoreCase("Locked")) {
////			return "your Account is Successful created";
////		}
////	
//////		Create Session and User Store data in session
////		session.setAttribute("userId",user.getUserId());	
//		return "success";
//	}
//	
//	
//	
//	//unlocked
//
//	@Override
////	public boolean unlockAccount(UnlockFormDto unlockForm) {
////		User user = this.userRepository.findByEmail(unlockForm.getEmail());
////		if(user.getPassword().equals(unlockForm.getTempPwd())) {
////			user.setPassword(unlockForm.getNewPassword());
////			user.setStatus("UnLocked");
////			this.userRepository.save(user);
////			return true;
////		}else {
////			return false;
////		}	
////	}
//
//	@Override
//	public boolean forgotPwd(String email) {
////	User entity = this.userRepository.findByEmail(email);
////	
////	if(entity==null) {
////		
////		return false;
////	}else {
////		
////		String subject= "Recover password";
////		String body= "Your Password :: "+ entity.getPassword();
////		emailUtils.sendEmail(email, subject, body);
//		return true;
////	}
////	
//	}


}
