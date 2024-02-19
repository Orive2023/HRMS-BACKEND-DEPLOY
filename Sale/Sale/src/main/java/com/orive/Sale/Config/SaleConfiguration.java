package com.orive.Sale.Config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SaleConfiguration {

	@Bean
	public ModelMapper modelMapper()
	{
		return new ModelMapper();
	}
}
