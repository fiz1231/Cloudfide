package com.example.Cloudfide;

import org.springframework.boot.SpringApplication;

public class TestCloudfideApplication {

	public static void main(String[] args) {
		SpringApplication.from(CloudfideApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
