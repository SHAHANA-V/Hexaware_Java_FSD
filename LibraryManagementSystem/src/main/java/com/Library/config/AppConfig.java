package com.Library.config;

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
import java.net.PortUnreachableException;
import java.util.Properties;

@Configuration
@ComponentScan(basePackages = "com.Library")
@EnableTransactionManagement
public class AppConfig {

    @Bean
    public DataSource getDataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/library");
        dataSource.setUsername("root");
        dataSource.setPassword("Shahana@30");
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        return dataSource;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean getEntityManagerFactory(){
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();

        //Add datasource
        entityManagerFactoryBean.setDataSource(getDataSource());

        //show location of all entity classes to hibernate
        entityManagerFactoryBean.setPackagesToScan("com.Library.model");

        //Add JpaVendor
        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        entityManagerFactoryBean.setJpaVendorAdapter(vendorAdapter);

        //set properties specific to hibernate
        Properties properties = new Properties();
        //this property tells the hibernate to update the db when the entity class is created or any field adding is done in the class
        properties.setProperty("hibernate.hbm2ddl.auto","update");
        entityManagerFactoryBean.setJpaProperties(properties);

        return entityManagerFactoryBean;
    }

    @Bean
    public PlatformTransactionManager gettransactionManager(){
        return new JpaTransactionManager(getEntityManagerFactory().getObject());
    }
}
