package com.example.Binding;

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
public class UnlockFormDto {

	private String tempPwd;
	private String newPassword;
	private String conformPassword;
	private String email;
	
}
