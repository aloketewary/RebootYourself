/**
 * 
 */
package com.reboot.yourself.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author AlokeT
 *
 */
@Configuration
@PropertySource("classpath:application.properties")
@ConfigurationProperties(prefix = "config")
@Component
public class ConfigProvider implements WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> {
	public String apiVersionOne;
	public String defaultApiVersion;
	public String projectName;
	public String schemaName;

	public String getApiVersionOne() {
		return apiVersionOne;
	}

	public void setApiVersionOne(String apiVersionOne) {
		this.apiVersionOne = apiVersionOne;
	}

	public String getDefaultApiVersion() {
		return defaultApiVersion;
	}

	public void setDefaultApiVersion(String defaultApiVersion) {
		this.defaultApiVersion = defaultApiVersion;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getSchemaName() {
		return schemaName;
	}

	public void setSchemaName(String schemaName) {
		this.schemaName = schemaName;
	}

	@Override
	public void customize(ConfigurableServletWebServerFactory factory) {
		factory.setContextPath(this.projectName);
		factory.setPort(8083);
	}

}
