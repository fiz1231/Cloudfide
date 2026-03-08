package com.example.Cloudfide;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

import com.example.Cloudfide.Service.Getter;

@Import(TestcontainersConfiguration.class)
@SpringBootTest
class CloudfideApplicationTests {

	@Test
	void contextLoads() {
	}
	
}
