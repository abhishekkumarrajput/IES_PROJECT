package com.example.Model;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
public class CitizenApplication {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer caseNumber;
	private String fullName;
	private String Email;
	private String password;
	private Long phoneNumber;
	private String Gender;
	private Date Dob;
	private Long ssnNumber;
	private String cityName;
	private String stateName;
	private String houseName;
	private Integer createBy;
   private LocalDate createDate;



@OneToMany(mappedBy = "citizen",cascade = CascadeType.ALL)
@JsonBackReference
List<PlanSelection>planSecletion;

@OneToOne(mappedBy = "citi",cascade = CascadeType.ALL)
@JsonBackReference
private EducationDetails education;

@OneToOne(mappedBy ="kidsCase",cascade = CascadeType.ALL )
@JsonBackReference
private KidsDetails kidDetails;

@OneToOne(mappedBy = "incomeCitizen",cascade = CascadeType.ALL)
@JsonBackReference
private IncomeDetails incomeDetails;

@OneToOne(mappedBy = "cititizenEligi",cascade = CascadeType.ALL)
private EligibilityDetails eligibilityDetails;
}
