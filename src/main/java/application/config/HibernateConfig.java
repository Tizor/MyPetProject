package application.config;


import application.entity.Customer;
import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Properties;

@Configuration
@EnableTransactionManagement
public class HibernateConfig {

//    @Value("${hibernate.properties.dialect}")
//    private String dialect;
//
//    @Value("${hibernate.properties.showQSL}")
//    private String showQSL;
//
//    @Value("${hibernate.properties.formatSQL}")
//    private String formatSQL;

    @Bean
//    @ConfigurationProperties(prefix = "spring.datasource")
    public DriverManagerDataSource getDataSource() {
        DriverManagerDataSource DS = new DriverManagerDataSource();
        DS.setUrl("jdbc:postgresql://localhost:5432/onlineshop5");
        DS.setUsername("postgres");
        DS.setPassword("root");
        DS.setDriverClassName("org.postgresql.Driver");
        return DS;
    }

    @Bean
    public LocalSessionFactoryBean entityManagerFactory(){
        LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
        localSessionFactoryBean.setDataSource(getDataSource());

        Properties properties = new Properties();
        properties.setProperty(Environment.DIALECT, "org.hibernate.dialect.PostgreSQL10Dialect");
        properties.setProperty(Environment.SHOW_SQL, "true");
        properties.setProperty(Environment.FORMAT_SQL, "true");

        localSessionFactoryBean.setHibernateProperties(properties);
        localSessionFactoryBean.setAnnotatedClasses(Customer.class);

        return localSessionFactoryBean;
    }

    @Bean
    public HibernateTransactionManager getTransactionalManager(){
        HibernateTransactionManager hibernateTransactionManager = new HibernateTransactionManager();
        hibernateTransactionManager.setSessionFactory(entityManagerFactory().getObject());
        return hibernateTransactionManager;
    }
}
