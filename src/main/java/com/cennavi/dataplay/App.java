package com.cennavi.dataplay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;



@ServletComponentScan
@SpringBootApplication
public class App extends SpringBootServletInitializer {
	public static void main(String[] args) {

		SpringApplication.run(App.class, args);
	}
	
	@Bean
	public WebMvcConfigurer corsConfigurer(){
		
		return new WebMvcConfigurerAdapter() {

			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**");
			}
			
			
		};
	}

}
