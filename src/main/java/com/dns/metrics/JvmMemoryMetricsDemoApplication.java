package com.dns.metrics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class JvmMemoryMetricsDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(JvmMemoryMetricsDemoApplication.class, args);
	}

}
