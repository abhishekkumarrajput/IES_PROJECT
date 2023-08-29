package com.example.Model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
public class EligibilityDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer traceId;
	private String planName;
	private String plansStatus;
	private LocalDate startDate;
	private LocalDate endDate;
	private Long benefitAmmount;
	private String denialReason;
	private LocalDate createDate;
	
	@JoinColumn(name="caseNumber")
	@OneToOne
	private CitizenApplication cititizenEligi;
	
	
	
	
	

}
