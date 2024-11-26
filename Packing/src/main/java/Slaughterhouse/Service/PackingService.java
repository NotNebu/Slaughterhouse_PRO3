package Slaughterhouse.Service;

import Slaughterhouse.Entities.Product;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class PackingService {

    private final RestTemplate restTemplate;

    public PackingService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Product> getProductsByAnimal(Integer animalId) {
        String url = "http://packing-service:8082/api/packing/products/recall/" + animalId;
        ResponseEntity<List<Product>> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Product>>() {}
        );
        return response.getBody();
    }

    public void markProductRecalled(Integer productId) {
        String url = "http://packing-service:8082/api/packing/products/" + productId + "/recall";
        restTemplate.put(url, null);
    }
}
