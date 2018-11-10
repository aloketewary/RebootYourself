package com.reboot.yourself.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reboot.yourself.model.ApplicationConfiguration;
import com.reboot.yourself.service.AppConfigService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@RestController
@RequestMapping(value="/api")
@Api(value="AppConfig", description="Operations pertaining to products in Online Store")


public class AppConfigController {

	@Autowired
	private AppConfigService appConfigService;
	
	@ApiOperation(value = "View Default Api Version", response = ApplicationConfiguration.class)
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "Successfully retrieved list"),
	        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
	        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
	        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	}
	)
	@GetMapping(value="/${config.default-api-version}/config")
	public Map<String,String> getConfig() {
		List<ApplicationConfiguration> appConfigList = new ArrayList<>();
		return appConfigService.getConfigList();
		//return new ApplicationConfiguration(1, "APP_NAME", "RebootYourself");
	}
	
	@ApiOperation(value = "View Api Version", response = String.class)
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "Successfully retrieved list"),
	        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
	        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
	        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	}
	)
	@GetMapping(value="/${config.api-version-one}/config")
	public String getV1Config() {
		return "v1 config";
	}
	
//	@PostMapping
}
