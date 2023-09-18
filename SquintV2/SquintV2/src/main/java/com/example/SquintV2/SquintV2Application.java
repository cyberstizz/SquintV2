package com.example.SquintV2;

import java.nio.file.Path;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.cassandra.CqlSessionBuilderCustomizer;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.ComponentScan;

import com.example.SquintV2.connection.DataStaxAstraProperties;

// import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

//https://lucid.app/lucidspark/1d8557dc-94c4-4412-89b2-130e8e8aeb39/edit?invitationId=inv_ad4e5510-e56c-4009-a2a7-a55868bf8200

@SpringBootApplication
@EnableConfigurationProperties(DataStaxAstraProperties.class)
public class SquintV2Application {

	public static void main(String[] args) {
		SpringApplication.run(SquintV2Application.class, args);
	}


	 /**
     * This is necessary to have the Spring Boot app use the Astra secure bundle 
     * to connect to the database - a quote from java brains
     */
    @Bean
    public CqlSessionBuilderCustomizer sessionBuilderCustomizer(DataStaxAstraProperties astraProperties) {
        Path bundle = astraProperties.getSecureConnectBundle().toPath();
        return builder -> builder.withCloudSecureConnectBundle(bundle);
    }

}
