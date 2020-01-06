package com.voter.app.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.integration.config.EnableIntegration;

@SpringBootApplication
@EnableIntegration
@ImportResource({"classpath*:/voter-consumer-app-configuration.xml"})
public class VoterConsumerAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(VoterConsumerAppApplication.class, args);
	}

}
