package application.config;

import liquibase.integration.spring.SpringLiquibase;
import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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

    @Value("${spring.basePackage}")
    private String basePackage;

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource getDataSource() {
        return DataSourceBuilder.create().build();
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
        factoryBean.setPackagesToScan(basePackage);
        return factoryBean;
    }

    @Bean
    public HibernateTransactionManager transactionManager() {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(entityManagerFactory().getObject());
        return transactionManager;
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.liquibase")
    public LiquibaseProperties liquibaseProperties() {
        return new LiquibaseProperties();
    }

    @Bean
    public SpringLiquibase liquibase() {
        return springLiquibase(getDataSource(), liquibaseProperties());
    }

    private SpringLiquibase springLiquibase(DataSource dataSource, LiquibaseProperties properties) {
        SpringLiquibase liquibase = new SpringLiquibase();
        liquibase.setDataSource(dataSource);
        liquibase.setChangeLog(properties.getChangeLog());
        liquibase.setContexts(properties.getContexts()); // Контексты Liquibase для выполнения, которые могут быть разделены ",", если требуется несколько контекстов. Если контекст не указан, тогда будут выполняться ВСЕ контексты.
        liquibase.setDefaultSchema(properties.getDefaultSchema()); // Следует ли игнорировать имя схемы
        liquibase.setDropFirst(properties.isDropFirst()); // Следует ли выполнить удаление базы данных перед выполнением изменения. Значение по умолчанию : false.
        liquibase.setShouldRun(properties.isEnabled()); // Отключение Liquibase на старте
        liquibase.setLabels(properties.getLabels()); // Метки Liquibase для выполнения, которые могут быть разделены ",", если требуется несколько меток или более сложное выражение. Если метка не указана, тогда ВСЕ все будут выполнены.
        liquibase.setChangeLogParameters(properties.getParameters()); // Параметры ChangeLog
        liquibase.setRollbackFile(properties.getRollbackFile()); // Сыылка из .yaml на rollback file. У меня такой ссылки нет
        return liquibase;
    }

}
