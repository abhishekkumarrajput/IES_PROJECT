package com.example.Serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Exception.ResourceNotFoundException;
import com.example.Model.CitizenApplication;
import com.example.Model.EducationDetails;
import com.example.Repository.CitizenApplicationRepo;
import com.example.Repository.EducationRepo;
import com.example.Service.EducationService;


@Service
public class EducationServicesimpl implements EducationService {

	@Autowired
	private EducationRepo educationRepo;
	
	@Autowired
	private CitizenApplicationRepo citizenApplicationRepo;
	
	
	//saveEducation
	
	@Override
	public EducationDetails saveEduction(EducationDetails educationDetails, Integer caseNumber) {
	CitizenApplication presentCitizen = this.citizenApplicationRepo.findById(caseNumber).orElseThrow(()->new ResourceNotFoundException("caseNumber", "caseNumberId", caseNumber));
	
	EducationDetails education= new EducationDetails();
	
	education.setCiti(presentCitizen);
	EducationDetails save = this.educationRepo.save(education);
	return save;

	}
}
