package com.samuel.scherf.servicediscoveryp2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ServiceDiscoveryP2Application {

	public static void main(String[] args) {
		SpringApplication.run(ServiceDiscoveryP2Application.class, args);
	}

}
