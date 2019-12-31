package application.config;

import application.implementation.CustomerServiceImpl;
import lombok.AllArgsConstructor;
import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.ws.Endpoint;

@Configuration
public class EndpointConfig {

    @Bean
    public Endpoint customerEndpoint() {
        EndpointImpl endpoint = new EndpointImpl(springBus(), new CustomerServiceImpl());  //todo имплементация сервиса
        endpoint.publish("/customer");
        return endpoint;
    }

    @Bean
    public SpringBus springBus() {
        return new SpringBus();
    }

}
