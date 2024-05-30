package br.com.fabioalvaro.apicartelas;

import java.util.TimeZone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import jakarta.annotation.PostConstruct;


@SpringBootApplication


public class ApiCartelasApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiCartelasApplication.class, args);
	}

	@PostConstruct
	public void init() {
		TimeZone.setDefault(TimeZone.getTimeZone("Brazil/East"));
	}

}
