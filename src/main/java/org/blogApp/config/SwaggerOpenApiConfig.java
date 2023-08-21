package org.blogApp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;

@Configuration
public class SwaggerOpenApiConfig {

	private static final String SCHEME_NAME = "Authorization";
    private static final String SCHEME = "Bearer";    
	
	    @Bean
	    OpenAPI usersMicroserviceOpenAPI() {
	        return new OpenAPI()
	        		.components(new Components()
	                        .addSecuritySchemes(SCHEME_NAME, createSecurityScheme()))
	                .addSecurityItem(new SecurityRequirement().addList(SCHEME_NAME))
	                .info(new Info().title("Blogging Application Backend")
	                                 .description("This project is developed and managed by: Prakhar Kumar Srivastava")
	                                 .version("2.0")
	                                 .contact(new Contact()
	                                		 .name("Prakhar Kumar Srivastava")
	                                		 .email("prakharsrivastav1110@gmail.com")
	                                		 .url("https://www.linkedin.com/in/prakhar-kumar-srivastava-99b36a137/"))
	                                 .termsOfService("Terms of Service")
	                                 .license(new License()
	                                		 .name("Swagger 2.0")
	                                		 .url("https://swagger.io/license/"))
	                                 );
	    }
	    
	    private SecurityScheme createSecurityScheme() {
	        return new SecurityScheme()
	                .name(SCHEME_NAME)
	                .type(SecurityScheme.Type.HTTP)
	                .bearerFormat("JWT")
	                .scheme(SCHEME);
	    }
	    
// Getting some error in authorization on swagger
/*
	     private SecurityScheme createAPIKeyScheme() {
        return new SecurityScheme()
        	.type(SecurityScheme.Type.HTTP)
            .bearerFormat("JWT")
            .scheme("Bearer");
    }
    
    @Bean
    OpenAPI usersMicroserviceOpenAPI() {
        return new OpenAPI()
            .addSecurityItem(new SecurityRequirement()
            .addList("Bearer Authentication"))
            .components(new Components()
                .addSecuritySchemes("JWT Bearer Authentication", createAPIKeyScheme()))
            .info(new Info().title("Blogging Application Backend")
                    .description("This project is developed and managed by: Prakhar Kumar Srivastava")
                    .version("2.0")
                    .contact(new Contact()
                   		 .name("Prakhar Kumar Srivastava")
                   		 .email("prakharsrivastav1110@gmail.com")
                   		 .url("https://www.linkedin.com/in/prakhar-kumar-srivastava-99b36a137/"))
                    .termsOfService("Terms of Service")
                    .license(new License()
                   		 .name("Swagger 2.0")
                   		 .url("https://swagger.io/license/"))
                    );
    }

*/

}