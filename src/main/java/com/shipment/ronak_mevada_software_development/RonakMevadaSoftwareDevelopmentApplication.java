package com.shipment.ronak_mevada_software_development;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RonakMevadaSoftwareDevelopmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(RonakMevadaSoftwareDevelopmentApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}
}
