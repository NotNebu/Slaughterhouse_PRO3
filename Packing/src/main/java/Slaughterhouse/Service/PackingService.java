package Slaughterhouse.Service;

import Slaughterhouse.Entities.Part;
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

    // Fetch parts related to a specific animal from Cutting Service
    public List<Part> getPartsByAnimal(Integer animalId) {
        String url = "http://localhost:8081/api/cutting/parts/animal/" + animalId; // Endpoint for Cutting Service
        ResponseEntity<List<Part>> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Part>>() {}
        );
        return response.getBody();
    }

    // Fetch products related to a specific animal
    public List<Product> getProductsByAnimal(Integer animalId) {
        String url = "http://localhost:8082/api/packing/products/recall/" + animalId; // Endpoint for fetching products
        ResponseEntity<List<Product>> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Product>>() {}
        );
        return response.getBody();
    }

    // Mark a product as recalled
    public void markProductRecalled(Integer productId) {
        String url = "http://localhost:8082/api/packing/products/" + productId + "/recall";
        restTemplate.put(url, null); // PUT request to update product status
    }
}
