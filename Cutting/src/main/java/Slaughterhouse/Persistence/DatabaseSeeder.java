package Slaughterhouse.Persistence;

import Slaughterhouse.Entities.Animal;
import Slaughterhouse.Entities.Part;
import Slaughterhouse.Entities.Tray;
import Slaughterhouse.Repository.PartRepository;
import Slaughterhouse.Repository.TrayRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DatabaseSeeder implements CommandLineRunner {

    private final PartRepository partRepository;
    private final TrayRepository trayRepository;

    public DatabaseSeeder(PartRepository partRepository, TrayRepository trayRepository) {
        this.partRepository = partRepository;
        this.trayRepository = trayRepository;
    }

    @Override
    public void run(String... args) {
        // Create dummy trays
        Tray legTray = new Tray();
        legTray.setType("Leg");
        legTray.setCapacity(100.0);
        legTray.setCurrentWeight(0.0);

        Tray wingTray = new Tray();
        wingTray.setType("Wing");
        wingTray.setCapacity(50.0);
        wingTray.setCurrentWeight(0.0);

        trayRepository.saveAll(List.of(legTray, wingTray));

        // Create dummy animals
        Animal animal1 = new Animal();
        animal1.setId(1);
        animal1.setRegistrationNumber("A01");
        animal1.setWeight(300.5);
        animal1.setArrivalDate("2024-11-01");
        animal1.setOrigin("Farm A");

        Animal animal2 = new Animal();
        animal2.setId(2);
        animal2.setRegistrationNumber("A02");
        animal2.setWeight(400.0);
        animal2.setArrivalDate("2024-11-02");
        animal2.setOrigin("Farm B");

        // Create dummy parts
        Part leg1 = new Part();
        leg1.setType("Leg");
        leg1.setWeight(25.0);
        leg1.setAnimal(animal1);

        Part wing1 = new Part();
        wing1.setType("Wing");
        wing1.setWeight(10.0);
        wing1.setAnimal(animal1);

        Part leg2 = new Part();
        leg2.setType("Leg");
        leg2.setWeight(30.0);
        leg2.setAnimal(animal2);

        partRepository.saveAll(List.of(leg1, wing1, leg2));

        System.out.println("Cutting Service database seeded with dummy data.");
    }
}
