package com.example.hotels;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

@SpringBootApplication
@EnableJpaAuditing
public class Application {
	@PostConstruct
	void started() {
		// set JVM timezone as UTC
		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
	}


	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
