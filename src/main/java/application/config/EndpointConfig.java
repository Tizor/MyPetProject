package application.config;

import application.implementation.CustomerServiceImpl;
import application.implementation.FinalOrderServiceImpl;
import application.implementation.ProductServiceImpl;
import application.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.xml.ws.Endpoint;

@Configuration
@RequiredArgsConstructor
public class EndpointConfig {

   private final CustomerServiceImpl customerServiceImpl;
   private final FinalOrderServiceImpl finalOrderService;
   private final ProductService productService;

    @Bean
    public Endpoint customerEndpoint() {
        Endpoint endpoint = new EndpointImpl(springBus(), customerServiceImpl);
        endpoint.publish("/customer");
        return endpoint;
    }

    @Bean
    public Endpoint orderEndpoint() {
        Endpoint endpoint = new EndpointImpl(springBus(), finalOrderService);
        endpoint.publish("/order");
        return endpoint;
    }

    @Bean
    public Endpoint productEndpoint() {
        Endpoint endpoint = new EndpointImpl(springBus(), productService);
        endpoint.publish("/product");
        return endpoint;
    }


    @Bean(name = Bus.DEFAULT_BUS_ID)
    public SpringBus springBus() {
        return new SpringBus();
    }

}
