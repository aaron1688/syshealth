package com.bosch.si;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SyshealthApplication {

	public static void main(String[] args) {
		SpringApplication.run(SyshealthApplication.class, args);
	}
}
