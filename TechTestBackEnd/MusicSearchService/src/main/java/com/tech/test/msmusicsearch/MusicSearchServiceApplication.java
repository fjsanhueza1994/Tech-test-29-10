package com.tech.test.msmusicsearch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class MusicSearchServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MusicSearchServiceApplication.class, args);
	}

}
