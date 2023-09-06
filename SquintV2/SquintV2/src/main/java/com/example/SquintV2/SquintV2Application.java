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
