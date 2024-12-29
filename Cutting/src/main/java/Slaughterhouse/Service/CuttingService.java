package Slaughterhouse.Service;

import Slaughterhouse.Entities.Animal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class CuttingService {

    private final RestTemplate restTemplate;

    @Autowired
    public CuttingService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Animal getAnimalById(Integer animalId) {
        String url = "http://localhost:8080/api/animals/" + animalId; // Endpoint fra AnimalRestController
        return restTemplate.getForObject(url, Animal.class);
    }
}


