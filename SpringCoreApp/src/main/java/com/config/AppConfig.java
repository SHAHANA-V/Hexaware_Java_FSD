package com.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import javax.xml.crypto.Data;
import java.time.Clock;

@Configuration
@ComponentScan(basePackages = "com.*")
public class AppConfig {
//    static {
//        System.out.println("App Config Loads..");
//    }
          @Bean
          public Clock getClockConfig(){
        return Clock.systemUTC();
    }
    @Bean
    public DataSource getDataSource(){
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:mysql://127.0.0.1:3306/hexaware_practice");
        config.setUsername("root");
        config.setPassword("Shahana@30");
        config.setDriverClassName("com.mysql.cj.jdbc.Driver");
        return new HikariDataSource(config);
    }


    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource){
              return new JdbcTemplate(dataSource);
    }


}
