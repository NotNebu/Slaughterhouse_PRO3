package Slaughterhouse.Service;

import Slaughterhouse.Entities.Part;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class CuttingService {

    private final RestTemplate restTemplate;

    public CuttingService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Part> getPartsByAnimal(Integer animalId) {
        String url = "http://cutting-service:8081/api/cutting/parts/animal/" + animalId;
        ResponseEntity<List<Part>> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Part>>() {}
        );
        return response.getBody();
    }
}

