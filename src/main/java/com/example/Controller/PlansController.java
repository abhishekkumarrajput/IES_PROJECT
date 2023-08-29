package com.example.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.example.Model.PlansEntity;

import com.example.Service.PlanService;

@RestController
@RequestMapping("/plans")
public class PlansController {

	@Autowired
	private PlanService planService;
	
	
	@GetMapping("/AllPlans")
	ResponseEntity<List<PlansEntity>>getAllPlans(){
		return ResponseEntity.ok(this.planService.getAllPlans());
	}
	
	@PostMapping("/SavePlan")
	ResponseEntity<PlansEntity>saveplans(@RequestBody PlansEntity plans){
		PlansEntity createPlan = this.planService.createPlan(plans);
		return new ResponseEntity<PlansEntity>(createPlan,HttpStatus.CREATED);
	}
	
	@GetMapping("/{planId}")
	ResponseEntity<PlansEntity>getPlan(@PathVariable Integer planId){
		PlansEntity planById = this.planService.getPlanById(planId);
		return new ResponseEntity<PlansEntity>(planById,HttpStatus.OK);
	}
	
	@PutMapping("/{planId}")
	ResponseEntity<PlansEntity>updatePlan(@RequestBody PlansEntity plans,@PathVariable Integer planId){
		PlansEntity updatePlan = this.planService.updatePlan(plans, planId);
		return new ResponseEntity<PlansEntity>(updatePlan,HttpStatus.OK);
	}
	
	@DeleteMapping("/{planId}")
	void deleteplan(@PathVariable Integer planId) {
		this.planService.deletePlan(planId);
	}
	
}
