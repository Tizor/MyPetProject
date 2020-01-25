package application.config;


import application.dto.CustomerDto;
import application.entity.Customer;
import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EntityScan(basePackages = "application", basePackageClasses = Jsr310JpaConverters.class)
@EnableJpaRepositories(basePackages = "application", basePackageClasses = Jsr310JpaConverters.class)
@EnableTransactionManagement
@EnableConfigurationProperties
public class HibernateConfig {

    @Value("${hibernate.properties.dialect}")
    private String dialect;

    @Value("${hibernate.properties.showSQL}")
    private String showSQL;

    @Value("${hibernate.properties.formatSQL}")
    private String formatSQL;

//    @Bean
//    @ConfigurationProperties(prefix = "spring.datasource")
//    public DataSource getDataSource() {
//        return DataSourceBuilder.create().build();
//    }

    @Bean(name = "dataSource")
    public DataSource getDataSource() {
        DriverManagerDataSource  dataSourceBuilder = new DriverManagerDataSource ();
        dataSourceBuilder.setDriverClassName("org.postgresql.Driver");
        dataSourceBuilder.setUrl("jdbc:postgresql://localhost:5432/onlineshop");
        dataSourceBuilder.setUsername("postgres");
        dataSourceBuilder.setPassword("root");
        return dataSourceBuilder;
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
        transactionManager.setDataSource(getDataSource());
        return transactionManager;
    }

}
