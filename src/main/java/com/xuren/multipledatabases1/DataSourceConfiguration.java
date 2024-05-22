package com.xuren.multipledatabases1;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration(proxyBeanMethods = false)
public class DataSourceConfiguration {

    @Bean
    @Primary
    @ConfigurationProperties("app.datasource.sqlserver")
    public DataSourceProperties sqlServerDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    @Primary
    public HikariDataSource sqlServerDataSource(@Qualifier("sqlServerDataSourceProperties") DataSourceProperties sqlServerDataSourceProperties) {
        return sqlServerDataSourceProperties.initializeDataSourceBuilder()
                .type(HikariDataSource.class)
                .build();
    }


    //    secondary data source
    @Bean
    @ConfigurationProperties("app.datasource.psql")
    public DataSourceProperties psqlDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    public HikariDataSource psqlDataSource(@Qualifier("psqlDataSourceProperties") DataSourceProperties psqlDataSourceProperties) {
        return psqlDataSourceProperties.initializeDataSourceBuilder()
                .type(HikariDataSource.class)
                .build();
    }
}
