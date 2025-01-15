package guru.microservices.mssc_brewery_client.client;

import guru.microservices.mssc_brewery_client.web.model.BeerDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.UUID;

@Component
public class BreweryClient {

    private final String BEER_PATH_V1 = "/api/v1/beer/";
    private final RestTemplate restTemplate;
    @Value("${sfw.brewery.api-host}")
    private String apiHost;

    public BreweryClient(RestTemplateBuilder restTemplateBuilder){
        this.restTemplate = restTemplateBuilder.build();
    }

    public BeerDTO getBeerById(UUID beerId){
        return restTemplate.getForObject(apiHost+BEER_PATH_V1+beerId.toString(), BeerDTO.class);
    }
    public URI saveNewBeer(BeerDTO beerDTO){
        return restTemplate.postForLocation(apiHost+BEER_PATH_V1, beerDTO);
    }



}
