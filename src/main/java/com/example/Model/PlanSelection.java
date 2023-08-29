package com.example.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PlanSelection {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer planSecletionId;

	//case number foreign key
	@JoinColumn(name="caseNumber")
	@ManyToOne()
	private CitizenApplication citizen;
	
	//plan Id  //foreign key
	@JoinColumn(name="planId")
	@OneToOne()
	private PlansEntity plans;
	
	

}
