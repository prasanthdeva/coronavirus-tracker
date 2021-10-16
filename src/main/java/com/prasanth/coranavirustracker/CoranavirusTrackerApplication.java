package com.prasanth.coranavirustracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@EnableScheduling
public class CoranavirusTrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoranavirusTrackerApplication.class, args);
	}

}
