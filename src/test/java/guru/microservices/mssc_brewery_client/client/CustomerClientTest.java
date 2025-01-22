package guru.microservices.mssc_brewery_client.client;

import guru.microservices.mssc_brewery_client.web.model.BeerDTO;
import guru.microservices.mssc_brewery_client.web.model.CustomerDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CustomerClientTest {

    @Autowired
    private CustomerClient customerClient;

    @Test
    void getCustomerById() {
        CustomerDTO customerDTO = customerClient.getCustomerById(UUID.randomUUID());
        assertNotNull(customerDTO);
    }

    @Test
    void saveNewCustomer() {
        CustomerDTO customerDTO = CustomerDTO.builder().name("John Doe").build();
        URI response = customerClient.saveNewCustomer(customerDTO);
        assertNotNull(response);
    }

    @Test
    void updateCustomer() {
        CustomerDTO customerDTO = CustomerDTO.builder().name("Jane Doe").build();
        customerClient.updateCustomer(UUID.randomUUID(), customerDTO);
    }

    @Test
    void deleteCustomer() {
        customerClient.deleteCustomer(UUID.randomUUID());
    }
}