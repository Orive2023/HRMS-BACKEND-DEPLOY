package com.orive.Event.Configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EventConfig {

	@Bean
	public ModelMapper modelMapper() {
		
		return new ModelMapper();
	}
}
