package guru.microservices.mssc_brewery_client.client;

import guru.microservices.mssc_brewery_client.web.model.BeerDTO;
import guru.microservices.mssc_brewery_client.web.model.CustomerDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.UUID;

@Component
public class CustomerClient {

    private final String CUSTOMER_PATH_V1 = "/api/v1/customer/";
    private final RestTemplate restTemplate;
    @Value("${sfw.brewery.api-host}")
    private String apiHost;

    public CustomerClient(RestTemplateBuilder restTemplateBuilder){
        this.restTemplate = restTemplateBuilder.build();
    }

    public CustomerDTO getCustomerById(UUID customerId){
        return restTemplate.getForObject(apiHost+CUSTOMER_PATH_V1+customerId.toString(), CustomerDTO.class);
    }
    public URI saveNewCustomer(CustomerDTO customerDTO){
        return restTemplate.postForLocation(apiHost+CUSTOMER_PATH_V1, customerDTO);
    }
    public void updateCustomer(UUID customerId, CustomerDTO customerDTO){
        restTemplate.put(apiHost+CUSTOMER_PATH_V1+customerId.toString(), customerDTO);
    }
    public void deleteCustomer(UUID customerId){
        restTemplate.delete(apiHost+CUSTOMER_PATH_V1+customerId.toString());
    }
}
