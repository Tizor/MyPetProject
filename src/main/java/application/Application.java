package application;

import application.dto.CustomerDto;
import application.implementation.CustomerServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//        (exclude = HibernateJpaAutoConfiguration.class)
//@EnableAutoConfiguration
//@Configuration
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

    }
}
