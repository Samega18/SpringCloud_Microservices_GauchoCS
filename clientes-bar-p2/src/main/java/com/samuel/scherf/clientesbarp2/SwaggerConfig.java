package com.samuel.scherf.clientesbarp2;

import java.util.ArrayList;

import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration.EnableWebMvcConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.config.ResourceHandlerRegistry;

import static springfox.documentation.builders.PathSelectors.regex;

import io.swagger.annotations.Contact;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@EnableWebFlux
public class SwaggerConfig{

	@Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)  
          .select()                                  
          .apis(RequestHandlerSelectors.any())              
          .paths(PathSelectors.any())                          
          .build()
          .apiInfo(metaData());                                          
    }

	private ApiInfo metaData() {
		return new ApiInfo(
                "Clientes REST API",
                "Rest API para cadastramento de clientes",
                "1.0",
                "Terms of Service",
                new springfox.documentation.service.Contact("Samuel Nascimento e Vitor Scherf", "samuel.nascimento@maisunifacisa.com.br",
                        "vitor.scherf@maisunifacisa.com.br"),
                "Apache License Version 2.0",
                "https://www.apache.org/licesen.html", new ArrayList<VendorExtension>()
        );
	}
	
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
	    registry.addResourceHandler("swagger-ui.html")
	      .addResourceLocations("classpath:/META-INF/resources/");

	    registry.addResourceHandler("/webjars/**")
	      .addResourceLocations("classpath:/META-INF/resources/webjars/");
	}
	
}

//link: http://localhost:8000/spring-security-rest/api/v2/api-docs
//link2: http://localhost:8080/your-app-root/swagger-ui/
//link3: http://localhost:8080/spring-security-rest/api/swagger-ui/