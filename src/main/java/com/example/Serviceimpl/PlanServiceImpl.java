package com.example.Serviceimpl;

import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Binding.PlanDto;
import com.example.Exception.ResourceNotFoundException;
import com.example.Model.PlansEntity;
import com.example.Repository.PlansRepository;
import com.example.Service.PlanService;
import com.fasterxml.jackson.annotation.JsonCreator.Mode;

@Service
public class PlanServiceImpl implements PlanService {
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private PlansRepository plansRepository;

	@Override
	public Boolean createPlan(PlanDto PlanDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PlanDto> getAllPlans() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PlanDto getPlanById(Integer planId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String planStatus(Integer planId, String status) {
		// TODO Auto-generated method stub
		return null;
	}

//	@Autowired
//	private PlansRepository plansRepository; 
//	
//	@Override
//	public PlansEntity createPlan(PlansEntity plans) {
//	PlansEntity savePlans = this.plansRepository.save(plans);
//		return savePlans;
//	}
//
//	@Override
//	public List<PlansEntity> getAllPlans() {
//		List<PlansEntity> findAllPlans = this.plansRepository.findAll();
//		return findAllPlans;
//	}
//
//	@Override
//	public PlansEntity getPlanById(Integer planId) {
//		PlansEntity plan = this.plansRepository.findById(planId).orElseThrow(()->new ResourceNotFoundException("plan", "planId", planId));
//		return plan;
//	}
//
//	@Override
//	public PlansEntity updatePlan(PlansEntity plans, Integer planId) {
//	PlansEntity updatePlan = this.plansRepository.findById(planId).orElseThrow(()->new ResourceNotFoundException("plan", "planId", planId));
////	updatePlan.setActiveswitch(false);
//	updatePlan.setCategory(plans.getCategory());
//	updatePlan.setCreateBy(plans.getCreateBy());
//	updatePlan.setCreateDate(new Date());
//	updatePlan.setEndDate(new Date());
//	updatePlan.setPlansName(plans.getPlansName());
//	updatePlan.setStartDate(new Date());
//	updatePlan.setStatus(plans.getStatus());
//	updatePlan.setUpdateBy(plans.getUpdateBy());
//	updatePlan.setUpdateDate(new Date());
//	
//	PlansEntity savePlan = this.plansRepository.save(updatePlan);
//	return savePlan ;
//	}
//
//	@Override
//	public void deletePlan(Integer planId) {
//	
//		this.plansRepository.findById(planId).orElseThrow(()->new ResourceNotFoundException("plans", "planId", planId));
//	}
	
	
	

}
