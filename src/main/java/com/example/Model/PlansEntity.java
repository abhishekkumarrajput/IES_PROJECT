package com.example.Model;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
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


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class PlansEntity {	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer plansId;
	private String plansName;
	private String category;
	private LocalDate startDate;
	private LocalDate endDate;
	private String activeSwitch;

	//planSelection
	@OneToOne(mappedBy ="plans",cascade = CascadeType.ALL)
	private PlanSelection planSelection;

	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="userId")
	private UserEntity user;
}
