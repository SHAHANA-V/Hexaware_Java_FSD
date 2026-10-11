package com.FastX.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@ComponentScan(basePackages = "com.FastX")
@EnableTransactionManagement
public class AppConfig {

    @Bean
    public DataSource getdataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/fastx");
        dataSource.setUsername("root");
        dataSource.setPassword("Shahana@30");
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        return dataSource;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean getEntityManagerFactory(){
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean =
                new LocalContainerEntityManagerFactoryBean();

        // Datasource added
        entityManagerFactoryBean.setDataSource(getdataSource());

        // Showing location of all entity classes to hibernate
        entityManagerFactoryBean.setPackagesToScan("com.helpdesk.model");

        // Adding JpaVendorAdaptor
        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        entityManagerFactoryBean.setJpaVendorAdapter(vendorAdapter);

        // Set the properties - hibernate specific
        Properties properties = new Properties();
        // This property tells hibernate to update the DB when the entity class is created or
        // any field adding is done in the class.
        properties.setProperty("hibernate.hbm2ddl.auto","update");

        entityManagerFactoryBean.setJpaProperties(properties);

        return entityManagerFactoryBean;
    }

    @Bean
    public PlatformTransactionManager getTransactionManager(){
        return new JpaTransactionManager(getEntityManagerFactory().getObject());
    }


}
