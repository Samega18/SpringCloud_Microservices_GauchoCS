package com.samuel.scherf.funcionariosbarp2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class FuncionariosBarP2Application {

	public static void main(String[] args) {
		SpringApplication.run(FuncionariosBarP2Application.class, args);
	}

}
