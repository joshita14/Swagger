package com.demo.swagger.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.mangofactory.swagger.configuration.SpringSwaggerConfig;
import com.mangofactory.swagger.models.dto.ApiInfo;
import com.mangofactory.swagger.plugin.EnableSwagger;
import com.mangofactory.swagger.plugin.SwaggerSpringMvcPlugin;

@Configuration
@EnableWebMvc
@EnableSwagger
@ComponentScan("com.demo.swagger")
public class CustomJavaPluginConfig {

	private SpringSwaggerConfig springSwaggerConfig;

	@Autowired
	public void setSpringSwaggerConfig(SpringSwaggerConfig springSwaggerConfig) {
		this.springSwaggerConfig = springSwaggerConfig;
	}

	@Bean
	// Don't forget the @Bean annotation
	public SwaggerSpringMvcPlugin customImplementation() {
		return new SwaggerSpringMvcPlugin(this.springSwaggerConfig)
				.apiInfo(apiInfo()).includePatterns(".*api.*")
				.swaggerGroup("testgroup");
	}

	private ApiInfo apiInfo() {
		ApiInfo apiInfo = new ApiInfo("Application",
				"Api Docs For Application", "My Apps API terms of service",
				"My Apps API Contact Email", "My Apps API Licence Type",
				"My Apps API License URL");
		return apiInfo;
	}
}