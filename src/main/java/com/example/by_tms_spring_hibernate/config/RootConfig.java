package com.example.by_tms_spring_hibernate.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@ComponentScan("com.example")
@EnableTransactionManagement
@PropertySource(value = "classpath:hibernate.properties")
@EnableJpaRepositories("com.example.by_tms_spring_hibernate.repository")
public class RootConfig implements WebMvcConfigurer {

    private Environment environment;

    @Autowired
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    /*@Bean
    public LocalSessionFactoryBean sessionFactory(){

        LocalSessionFactoryBean sessionFac =
                new LocalSessionFactoryBean();

        sessionFac.setPackagesToScan("com.example.by_tms_spring_hibernate.entity");
        sessionFac.setDataSource(dataSource());
        sessionFac.setHibernateProperties(properties());

        return sessionFac;
    }*/

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource());
        em.setPackagesToScan("com.example.by_tms_spring_hibernate.entity");

        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        em.setJpaProperties(properties());

        return em;
    }

    @Bean
    public DataSource dataSource(){

        DriverManagerDataSource dataSour =
                new DriverManagerDataSource();

        dataSour.setUrl(environment.getRequiredProperty("hibernate.url"));
        dataSour.setUsername(environment.getRequiredProperty("hibernate.username"));
        dataSour.setPassword(environment.getRequiredProperty("hibernate.password"));
        dataSour.setDriverClassName(environment.getRequiredProperty("hibernate.driver"));

        return dataSour;
    }

    /*@Bean
    public HibernateTransactionManager transactionManager(){

        HibernateTransactionManager transactionManager =
                new HibernateTransactionManager();

        transactionManager.setSessionFactory(sessionFactory().getObject());

        return transactionManager;
    }*/

    @Bean
    public PlatformTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());

        return transactionManager;
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation(){
        return new PersistenceExceptionTranslationPostProcessor();
    }

    private Properties properties(){
        Properties properties = new Properties();

        properties.put("hibernate.dialect",environment.getRequiredProperty("hibernate.dialect"));
        properties.put("hibernate.show_sql",environment.getRequiredProperty("hibernate.show_sql"));
        properties.put("hibernate.format_sql",environment.getRequiredProperty("hibernate.format_sql"));
        properties.put("hibernate.hbm2ddl.auto",environment.getRequiredProperty("hibernate.hbm2ddl.auto"));

        return properties;
    }
}
