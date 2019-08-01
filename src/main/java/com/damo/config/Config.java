package com.damo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@ComponentScan("com.damo")
@PropertySource("classpath:db.properties")
public class Config {

    @Autowired
    Environment environment;

    private final String URL = "url";
    private final String USER = "dbuser";
    private final String PWD = "dbpassword";
    private final String DRIVER = "driver";

    @Bean
    DataSource dataSource (){
        DriverManagerDataSource source = new DriverManagerDataSource();
        source.setDriverClassName(environment.getProperty(DRIVER));
        source.setUrl(environment.getProperty(URL));
        source.setUsername(environment.getProperty(USER));
        source.setPassword(environment.getProperty(PWD));
        return source;
    }



}
