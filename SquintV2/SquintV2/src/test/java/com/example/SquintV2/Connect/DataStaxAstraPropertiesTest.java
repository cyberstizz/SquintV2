package com.example.SquintV2.Connect;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.SquintV2.connection.DataStaxAstraProperties;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
public class DataStaxAstraPropertiesTest {

    @Autowired
    private DataStaxAstraProperties dataStaxAstraProperties;

    @Test
    void testSecureConnectBundle() {
        assertThat(dataStaxAstraProperties.getSecureConnectBundle()).isNotNull();
    }



}
