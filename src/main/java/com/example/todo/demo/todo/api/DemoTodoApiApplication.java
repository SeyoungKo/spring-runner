package com.example.todo.demo.todo.api;

import com.example.todo.demo.todo.api.web.model.SiteProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@ConfigurationPropertiesScan
public class DemoTodoApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoTodoApiApplication.class, args);
	}

	// 빈 등록하기
//	@Bean
//	public SiteProperties siteProperties(){
//		return new SiteProperties();
//	}
}
