package com.samuel.scherf.clientesbarp2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ClientesBarP2Application {

	public static void main(String[] args) {
		SpringApplication.run(ClientesBarP2Application.class, args);
	}

}
