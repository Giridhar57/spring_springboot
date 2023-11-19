package com.infy.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.infy.repository.InsuranceRepository;
import com.infy.repository.InsuranceRepositoryImpl;
import com.infy.service.InsuranceService;
import com.infy.service.InsuranceServiceImpl;

@Configuration
public class SpringConfig {
	@Bean
	public InsuranceServiceImpl insuranceService() {
		return new InsuranceServiceImpl();
	}
	
	@Bean
	public InsuranceRepositoryImpl insuranceRepository() {
		return new InsuranceRepositoryImpl();
	}
}