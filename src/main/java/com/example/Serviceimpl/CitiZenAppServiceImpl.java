package com.example.Serviceimpl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Exception.ResourceNotFoundException;
import com.example.Model.CitizenApplication;
import com.example.Model.UserEntity;
import com.example.Repository.CitizenApplicationRepo;
import com.example.Repository.UserRepository;
import com.example.Service.CitiZenAppService;

@Service
public class CitiZenAppServiceImpl implements CitiZenAppService {

	@Autowired
	private CitizenApplicationRepo citiApplicationRepo;
	
	@Autowired
private UserRepository userRepo;;

//saveCitiZenApplication

	@Override
	public CitizenApplication saveCitiZenApp(CitizenApplication citiZpplication, Integer userId) {
		UserEntity user = this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("user", "userId",userId));
      CitizenApplication citizen = new CitizenApplication(); 
     citizen.setCityName("Brictial");
     citizen.setStateName("Rodhe Island");
     citizen.setHouseName("House No 13 ");
//     citizen.setCreateDate(new LocalDate());
//     citizen.setCreateBy(user.getCreateBy());
//     citizen.setUser(user);
     CitizenApplication citizenApplication = this.citiApplicationRepo.save(citizen);
		return citizenApplication;
	}

}
