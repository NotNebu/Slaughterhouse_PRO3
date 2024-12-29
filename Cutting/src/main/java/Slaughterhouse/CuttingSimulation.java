package Slaughterhouse;

import Slaughterhouse.Entities.Animal;
import Slaughterhouse.Entities.Part;
import Slaughterhouse.Repository.PartRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
@Profile("cutting-simulation")
public class CuttingSimulation implements CommandLineRunner {

    private final RestTemplate restTemplate;
    private final PartRepository partRepository;

    public CuttingSimulation(RestTemplate restTemplate, PartRepository partRepository) {
        this.restTemplate = restTemplate;
        this.partRepository = partRepository;
    }

    @Override
    public void run(String... args) {
        // Fetch animals from Animal Registration
        String animalServiceUrl = "http://localhost:8080/api/animals";
        Animal[] animals = restTemplate.getForObject(animalServiceUrl, Animal[].class);

        if (animals != null) {
            for (Animal animal : animals) {
                // Simulate cutting process
                Part leg = new Part();
                leg.setType("Leg");
                leg.setWeight(animal.getWeight() * 0.2); // Example: 20% of animal's weight
                leg.setAnimal(animal);

                Part wing = new Part();
                wing.setType("Wing");
                wing.setWeight(animal.getWeight() * 0.1); // Example: 10% of animal's weight
                wing.setAnimal(animal);

                // Save parts to the database
                partRepository.saveAll(List.of(leg, wing));
            }
        }

        System.out.println("Cutting simulation completed at startup.");
    }
}
