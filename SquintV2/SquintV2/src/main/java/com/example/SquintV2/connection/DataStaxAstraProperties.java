package com.example.SquintV2.connection;

import java.io.File;

import org.springframework.boot.context.properties.ConfigurationProperties;


@ConfigurationProperties(prefix = "datastax.astra")
public class DataStaxAstraProperties {
    
    private File secureConnectBundle;

    public File getSecureConnectBundle() {
        return secureConnectBundle;
    }

    
}
