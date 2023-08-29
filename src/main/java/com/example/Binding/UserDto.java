package com.example.Binding;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserDto {

	private String fullName;
	private String email;
	private Integer mobileNumber;
	private String gender;
	private Date dob;
	private Integer ssn;
	
	
	
}
