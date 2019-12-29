package application.config;

import application.implementation.CustomerServiceImpl;
import lombok.AllArgsConstructor;
import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.ws.Endpoint;

@Configuration
public class EndpointConfig {

    private CustomerServiceImpl customerService;
    private Bus bus;

    public EndpointConfig(CustomerServiceImpl customerService, Bus bus) {
        this.customerService = customerService;
        this.bus = bus;
    }

    @Bean
    public Endpoint customerEndpoint() {
        EndpointImpl endpoint = new EndpointImpl(bus, customerService);  //todo имплементация сервиса
        endpoint.publish("/customer");
        return endpoint;
    }


}
