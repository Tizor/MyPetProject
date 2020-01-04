package application.config;


import application.dto.CustomerDto;
import application.entity.Customer;
import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@EnableConfigurationProperties
public class HibernateConfig {

    @Value("${hibernate.properties.dialect}")
    private String dialect;

    @Value("${hibernate.properties.showSQL}")
    private String showSQL;

    @Value("${hibernate.properties.formatSQL}")
    private String formatSQL;

    @Bean
    public DataSource getDataSource() {
        return new DriverManagerDataSource();
    }

    @Bean
    public LocalSessionFactoryBean entityManagerFactory() {
        LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
        factoryBean.setDataSource(getDataSource());

        Properties props=new Properties();
        props.setProperty(Environment.DIALECT, dialect);
        props.setProperty(Environment.SHOW_SQL, showSQL);
        props.setProperty(Environment.FORMAT_SQL, formatSQL);
        factoryBean.setHibernateProperties(props);
        factoryBean.setAnnotatedClasses(Customer.class, CustomerDto.class);
        return factoryBean;
    }

    @Bean
    public HibernateTransactionManager getTransactionManager() {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(entityManagerFactory().getObject());
        return transactionManager;
    }

}
