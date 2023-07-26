package com.example.SquintV2.Connect;

import java.io.File;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

// import jakarta.annotation.PostConstruct;


@Configuration
@ConfigurationProperties(prefix = "datastax.astra")
@Primary
public class DataStaxAstraProperties {

    private File secureConnectBundle;

    

    //  // Add this method for debugging
    //  @PostConstruct
    //  public void logProperties() {
    //      System.out.println("Secure Connect Bundle Path: " + secureConnectBundle);
    //  }


    public File getSecureConnectBundle() {
        return secureConnectBundle;
    }



    public void setSecureConnectBundle(File secureConnectBundle) {
        this.secureConnectBundle = secureConnectBundle;
    }

    
}
