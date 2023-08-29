package com.example.Property;

import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

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
@Component
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "admin")   //so where configuration property are start
public class AppProperty {

	//so any message which we are configure those message can be loaded our configuration property 

	//this is Responsible for load the messages;
	
	private Map<String, String>messages=new HashedMap<>();
	
	
}
