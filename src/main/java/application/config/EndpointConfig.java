package application.config;

import application.dao.CustomerRepo;
import application.implementation.CustomerServiceImpl;
import application.mapper.CustomerMapper;
import lombok.RequiredArgsConstructor;
import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.xml.ws.Endpoint;

@Configuration
@RequiredArgsConstructor
public class EndpointConfig {

    private final CustomerRepo customerRepo;
    private final CustomerMapper customerMapper;

    @Bean
    public Endpoint customerEndpoint() {
        Endpoint endpoint = new EndpointImpl(springBus(), new CustomerServiceImpl(customerRepo, customerMapper));
        endpoint.publish("/customer");
        return endpoint;
    }

    @Bean(name = Bus.DEFAULT_BUS_ID)
    public SpringBus springBus() {
        return new SpringBus();
    }

}
