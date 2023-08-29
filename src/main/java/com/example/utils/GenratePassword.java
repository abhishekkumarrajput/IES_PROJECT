package com.example.utils;

import java.util.function.Supplier;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Component;

public class GenratePassword {
	public static String temporyPwd() {
		
		String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		String pwd = RandomStringUtils.random( 6, characters );  //password length
		System.out.println( pwd );
		return pwd;
	}		
}
