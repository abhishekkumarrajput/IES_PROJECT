package com.example.Service;

import java.util.List;

import com.example.Binding.PlanDto;
import com.example.Model.PlansEntity;

public interface PlanService {

	//createPlane
	public Boolean createPlan(PlanDto PlanDto);
	
	//getAllPlans
	public List<PlanDto>getAllPlans();
	
	//getPlanById
	public PlanDto getPlanById(Integer planId);
	
	//active deactive plan
	
	public String planStatus(Integer planId,String status);
	
}
