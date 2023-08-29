package com.example.Model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {
	@Id 
@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer userId;
	private String fullName;
	private String Email;
	private String password;
	private Long phoneNumber;
	private String Gender;
	private LocalDate Dob;
	private Long ssnNumber; 
	private String status;
	private String activeSwitch;;

	
	
@OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
private List<PlansEntity>plans; 

	
}
