package com.reboot.yourself;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.reboot.yourself"})
public class RebootYourselfApplication {

	public static void main(String[] args) {
		SpringApplication.run(RebootYourselfApplication.class, args);
	}
}
