package com.reboot.yourself;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.reboot.yourself.dao.AppConfigDAO;
import com.reboot.yourself.service.AppConfigService;
import com.reboot.yourself.service.AppConfigServiceImpl;

@SpringBootApplication(scanBasePackages = {"com.reboot.yourself"})
public class RebootYourselfApplication {

	public static void main(String[] args) {
		SpringApplication.run(RebootYourselfApplication.class, args);
	}
	
	@Bean
	public AppConfigService appConfigService() {
		return new AppConfigServiceImpl();
	}
	
	@Bean
	public AppConfigDAO appConfigDAO() {
		return new AppConfigDAO();
	}
	
}
