package com.mastery.java.task.config;

import com.mastery.java.task.service.EmployeeService;
import com.mastery.java.task.service.EmployeeServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.sql.DataSource;

@SpringBootApplication
@ComponentScan(basePackages = {"com.mastery.java.task.rest","com.mastery.java.task.dao"})
public class AppConfiguration implements WebMvcConfigurer {

    @Bean
    public JdbcTemplate getJdbcTemplate() {
        return new JdbcTemplate(getDataSource());
    }

    @Bean
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/employeedb?useSll=false");
        dataSource.setUsername("postgres");
        dataSource.setPassword("4773");
        return dataSource;
    }

    @Bean
    public EmployeeService getEmployeeService() {
        return new EmployeeServiceImpl();
    }

    public static void main(String[] args) {
        SpringApplication.run(AppConfiguration.class, args);
    }
}
