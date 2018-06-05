package com.cgs.contact;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.scheduling.annotation.EnableScheduling;


@Configuration
@EnableScheduling
@SpringBootApplication
@ImportResource("classpath:application-context.xml")
public class ContactApplication {
	private static final Logger log = LoggerFactory.getLogger(ContactApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ContactApplication.class, args);
	}
}
