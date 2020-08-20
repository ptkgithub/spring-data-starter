package com.datastax.examples;

import java.nio.file.Paths;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.cassandra.CqlSessionBuilderCustomizer;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableConfigurationProperties(DataStaxAstraProperties.class)
public class SpringDataCassandraApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDataCassandraApplication.class, args);
    }

    @Bean
    public CqlSessionBuilderCustomizer sessionBuilderCustomizer(DataStaxAstraProperties astraProperties) {
        return builder -> builder.withCloudSecureConnectBundle(astraProperties.getSecureConnectBundle());
    }
}

