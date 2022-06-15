package com.virtualmarathon.ApiGateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;

import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@SpringBootApplication
public class ApiGateway {

	@Bean
	public CorsWebFilter corsWebFilter() {
		final CorsConfiguration corsConfig = new CorsConfiguration();
		corsConfig.setAllowedOrigins(Arrays.asList("http://localhost:4200","https://virtual-marathon-frontend-2-urtjok3rza-wl.a.run.app"));
		corsConfig.setMaxAge(3600L);
		corsConfig.addAllowedHeader("*");
		corsConfig.setAllowedMethods(Arrays.asList("GET", "POST","PUT"));

		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", corsConfig);

		return new CorsWebFilter(source);
	}
	public static void main(String[] args) {
		SpringApplication.run(ApiGateway.class, args);
	}

}