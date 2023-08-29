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

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class KidsDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer kidsId;
	private String kidsName;
	private Date dob;
	private Long kidSsnNumber;
	
	
	//case numer    forgein key
	@JoinColumn(name="caseNumber")
	@OneToOne()
	private CitizenApplication kidsCase;
	

}
