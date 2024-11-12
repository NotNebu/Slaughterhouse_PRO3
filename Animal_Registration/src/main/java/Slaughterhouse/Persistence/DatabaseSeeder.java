package Slaughterhouse.Persistence;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import Slaughterhouse.Entities.Animal;
import Slaughterhouse.Repository.AnimalRepository;

import java.util.List;

@Component
public class DatabaseSeeder implements CommandLineRunner {

    private final AnimalRepository animalRepository;

    public DatabaseSeeder(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    @Override
    public void run(String... args) {
        // Check if the database is empty before seeding
        if (animalRepository.count() == 0) {
            seedAnimals();
        }
    }

    private void seedAnimals() {
        Animal animal1 = new Animal();
        animal1.setRegistrationNumber("A01");
        animal1.setWeight(300.5);
        animal1.setArrivalDate("2024-11-01");
        animal1.setOrigin("Farm A");

        Animal animal2 = new Animal();
        animal2.setRegistrationNumber("A02");
        animal2.setWeight(400.0);
        animal2.setArrivalDate("2024-11-01");
        animal2.setOrigin("Farm B");

        Animal animal3 = new Animal();
        animal3.setRegistrationNumber("A03");
        animal3.setWeight(250.75);
        animal3.setArrivalDate("2024-11-02");
        animal3.setOrigin("Farm A");

        // Save to the repository
        animalRepository.saveAll(List.of(animal1, animal2, animal3));

        System.out.println("Database seeding completed with dummy animal data.");
    }
}
