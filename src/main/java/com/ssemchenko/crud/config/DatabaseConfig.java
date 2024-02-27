package com.ssemchenko.crud.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableJpaRepositories("com.ssemchenko.crud.repository")
@EnableTransactionManagement
@PropertySource({"classpath:database.properties", "classpath:hibernate.properties"})
public class DatabaseConfig {
    @Autowired
    Environment env;

    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getRequiredProperty("database.driver"));
        dataSource.setUrl(env.getRequiredProperty("database.url"));
        dataSource.setUsername(env.getRequiredProperty("database.username"));
        dataSource.setPassword(env.getRequiredProperty("database.password"));
        return dataSource;
    }
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(){
        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        adapter.setShowSql(true);
        LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactory.setDataSource(dataSource());
        entityManagerFactory.setPackagesToScan("com.ssemchenko.crud.entity");
        entityManagerFactory.setJpaVendorAdapter(adapter);
        entityManagerFactory.setJpaProperties(getHimernateProperties());
        return entityManagerFactory;
    }

    @Bean
    public PlatformTransactionManager transactionManager(){
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
        return transactionManager;
    }


    private Properties getHimernateProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.dialect", env.getRequiredProperty("hibernate.dialect"));
        return properties;
    }

}
