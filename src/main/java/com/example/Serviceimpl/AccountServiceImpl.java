package com.example.Serviceimpl;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Binding.UserDto;
import com.example.Binding.LoginFormDto;
import com.example.Binding.UnlockFormDto;
import com.example.Exception.ResourceNotFoundException;
import com.example.Model.UserEntity;
import com.example.Repository.UserRepository;
import com.example.Service.AccountService;
import com.example.utils.EmailUtils;
import com.example.utils.GenratePassword;

import ch.qos.logback.core.model.Model;
import jakarta.persistence.Entity;
import jakarta.servlet.http.HttpSession;

@Service
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private UserRepository userRepository;
	
	
	@Autowired
	private EmailUtils emailUtils;
	
	@Override
	public boolean createUser(UserDto userFormDto) {
	
		//copy data binding object to entity data
		UserEntity userEntity = this.modelMapper.map(userFormDto, UserEntity.class);
		
		//set random password
		userEntity.setPassword(genratePwd());
		
		//set account Status
		userEntity.setStatus("LOCKED");
		userEntity.setActiveSwitch("Y");
	
		this.userRepository.save(userEntity);
		
		//send email
	String subject="Unlocked The Account";
	String body=readEmailBody("REG_EMAIL_BODY.txt", userEntity);
	boolean sendEmail = emailUtils.sendEmail(userFormDto.getEmail(), subject,body.toString());
return sendEmail;
		
	}

	@Override
	public List<UserDto> getAllUSer() {
		List<UserEntity> findAll = this.userRepository.findAll();
	List<UserDto> userDto = findAll.stream().map(s->this.modelMapper.map(findAll, UserDto.class)).collect(Collectors.toList());
		return userDto;
	}

	@Override
	public UserDto getUserById(Integer userId) {
		UserEntity userEntity = this.userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("user", "userId", userId));
	UserDto userdto = this.modelMapper.map(userEntity, UserDto.class);
		return userdto;
	}

	@Override
	public String changAccStatus(Integer userId, String status) {
		// Two way to implements the records 1 one by custom Query 2nd one is findById mthod get record and update status
		
		Integer count = this.userRepository.updateStatus(userId, status);
		if(count>0) {
			return "Status changed";	
		}else {
			return "Failed To change"; 
		}
	}

	@Override
	public boolean unlockAccount(UnlockFormDto unlockFormDto) {
	 UserEntity user = this.userRepository.findByEmail(unlockFormDto.getEmail());
	if(user.getPassword().equals(unlockFormDto.getTempPwd())) {
		user.setPassword(unlockFormDto.getNewPassword());
		user.setStatus("UnLocked");
		this.userRepository.save(user);
		return true;
	}else {
		return false;
	}
	}

private String genratePwd() {
	
    // create a string of uppercase and lowercase characters and numbers
    String upperAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    String lowerAlphabet = "abcdefghijklmnopqrstuvwxyz";
    String numbers = "0123456789";

    // combine all strings
    String alphaNumeric = upperAlphabet + lowerAlphabet + numbers;

    // create random string builder
    StringBuilder sb = new StringBuilder();

    // create an object of Random class
    Random random = new Random();

    // specify length of random string
    int length = 6;

    for(int i = 0; i < length; i++) {

      // generate random index number
      int index = random.nextInt(alphaNumeric.length());

      // get character specified by index
      // from the string
      char randomChar = alphaNumeric.charAt(index);

      // append the character to string builder
      sb.append(randomChar);
    }

    String randomString = sb.toString();
    System.out.println("Random String is: " + randomString);
	return randomString;
}
	
//read Data from The the file
	private String readEmailBody(String filename,UserEntity user) {
		StringBuilder sb= new StringBuilder();
		try(Stream<String>lines=Files.lines(Paths.get(filename))) {
			lines.forEach(line->{
				line.replace("${FNAME}", user.getFullName());
				line.replace("${TEMP_PWD}", user.getPassword());
				line.replace("${EMAIL}", user.getEmail());
				sb.append(line);
			});
		}catch (Exception e) {
		e.printStackTrace();
		}
		return sb.toString();	
	}
	

//	@Autowired
//	private UserRepository userRepository;
//
//	@Autowired
//	private EmailUtils emailUtils;
//
//	@Autowired
//	private HttpSession session;
//
//	// createAccount
//	@Override
//	public String createUser(CreateUserDto userForm) {
//		UserEntity user = new UserEntity();
//		BeanUtils.copyProperties(userForm, user);
////		User presentUser = this.userRepository.findByEmail(userForm.getEmail());
////		if(presentUser != null) {
////			return "User already present";
////		}else {
////		
////			user.setCreateDate(new Date());
////			user.setUpdateDate(new Date());
////			user.setCreateBy("Abhishek Rajput");
////			user.setUpdateBy("Abhishek rajput");
////			user.setStatus("Locked");
////			user.setActiveSwitch(true);
////			String temporyPwd = GenratePassword.temporyPwd();
////			user.setPassword(temporyPwd);
////			 User save = this.userRepository.save(user);
////			 
////			 //GenrateEmail
////			 
////			String to = userForm.getEmail();
////			String subject="Unlocked The Account";
////			
////			StringBuilder body= new StringBuilder();
////			
////			body.append("<h1> Use below temporary pwd to unlock your account </h1>");
////			body.append("Teampory password : "+ temporyPwd);
////	        body.append("<br/>");
////	        body.append("<a href=\"http://localhost:9003/unlock?email="+ to +"\"> Click Here To Unlock Account </a>");
////			emailUtils.sendEmail(to, subject,body.toString());
////			
//		return "Successful";
////		}
//
//	}
//
//	// getAllUser
//
//	@Override
//	public List<CreateUserDto> getAllUSer() {
//		List<UserEntity> findAllUser = this.userRepository.findAll();
//		return findAllUser;
//	}
//
//	// getUserById
//
//	@Override
//	public UserEntity getUserById(Integer userId) {
//		UserEntity user = this.userRepository.findById(userId)
//				.orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
//		return user;
//	}
//
//	// updateUser
//	@Override
//	public UserEntity updateUser(UserEntity user, Integer userId) {
//
//		UserEntity user1 = this.userRepository.findById(userId)
//				.orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
//
//	//	user1.setActiveSwitch(false);	
//		user1.setCreateBy(user.getCreateBy());
//		user1.setCreateDate(user.getCreateDate());
//		user1.setDob(user.getDob());
//		user1.setEmail(user.getEmail());
//		user1.setFullName(user.getFullName());
//		user1.setGender(user.getGender());
//		user1.setPassword(user.getPassword());
//		user1.setPhoneNumber(user.getPhoneNumber());
//		user1.setSsnNumber(user.getSsnNumber());
//		user1.setStatus(user.getStatus());
//		user1.setUpdateBy(user.getUpdateBy());
//		user1.setUpdateDate(user.getUpdateDate());
//		user1.setUserId(user.getUserId());
//		user1.setUserRole(user.getUserRole());
//		this.userRepository.save(user1);
//		return user1;
//	}
//
//	// deleteUser
//	@Override
//	public void deleteUser(Integer userId) {
//		UserEntity deleteUser = this.userRepository.findById(userId)
//				.orElseThrow(() -> new ResourceNotFoundException("User", "userId", userId));
//		this.userRepository.delete(deleteUser);
//
//	}
	
	
	
	
	
	

}
