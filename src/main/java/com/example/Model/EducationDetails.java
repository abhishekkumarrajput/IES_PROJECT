package com.example.Model;

import java.util.Date;

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

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EducationDetails {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer educationId;
	private String highestDegree;
	private Date graducation_year;
	private String university;
	
	//case Number  FK
	@JoinColumn(name="caseNumber")
	@OneToOne()
	private CitizenApplication citi;
	
}
