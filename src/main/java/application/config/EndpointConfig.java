package application.config;

import application.implementation.CustomerServiceImpl;
import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.ws.Endpoint;

@Configuration
public class EndpointConfig {

    @Bean
    public Endpoint customerEndpoint() {
        Endpoint endpoint = new EndpointImpl(springBus(), new CustomerServiceImpl());
        endpoint.publish("/customer");
        return endpoint;
    }

    @Bean(name = Bus.DEFAULT_BUS_ID)
    public SpringBus springBus() {
        return new SpringBus();
    }

}
