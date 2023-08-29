package com.example.Binding;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DashboardDto {
	
	private Long plansCnt;
	private Long approvedCnt;
	private Long deniedCnt;
	private Double beniftAmtGiven;
    private UserDto userDto;   //which is used to Represent the user data when they are Login Successfully

}
