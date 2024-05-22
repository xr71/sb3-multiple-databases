package com.xuren.multipledatabases1;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.simple.JdbcClient;

import javax.sql.DataSource;

@SpringBootApplication
public class MultipleDatabases1Application {

    public static void main(String[] args) {
        SpringApplication.run(MultipleDatabases1Application.class, args);
    }

    @Bean
    JdbcClient sqlServerJdbcClient(
            @Qualifier("sqlServerDataSource") DataSource dataSource
            ) {
        return JdbcClient.create(dataSource);
    }

    @Bean
    JdbcClient psqlJdbcClient(
            @Qualifier("psqlDataSource") DataSource dataSource
    ) {
        return JdbcClient.create(dataSource);
    }
}
