package com.example.Exception;

import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.Getter;
import lombok.Setter;

@RestControllerAdvice
public class ResourceNotFoundException extends RuntimeException {
	@Getter
	@Setter
	String resourceName;
	String fieldname;
	long fieldValue;
	public ResourceNotFoundException(String resourceName, String fieldname, long fieldValue) {
		super(String.format("%s not found with %s :%s",resourceName,fieldname,fieldValue));
		this.resourceName = resourceName;
		this.fieldname = fieldname;
		this.fieldValue = fieldValue;
	
	
	
	}

}
