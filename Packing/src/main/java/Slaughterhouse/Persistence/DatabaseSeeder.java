package Slaughterhouse.Persistence;

import Slaughterhouse.Entities.Product;
import Slaughterhouse.Entities.Tray;
import Slaughterhouse.Repository.ProductRepository;
import Slaughterhouse.Repository.TrayRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DatabaseSeeder implements CommandLineRunner {

    private final ProductRepository productRepository;
    private final TrayRepository trayRepository;

    public DatabaseSeeder(ProductRepository productRepository, TrayRepository trayRepository) {
        this.productRepository = productRepository;
        this.trayRepository = trayRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Seed trays
        Tray legTray = new Tray();
        legTray.setType("Leg");
        legTray.setCapacity(100.0);
        legTray.setCurrentWeight(55.0);

        Tray wingTray = new Tray();
        wingTray.setType("Wing");
        wingTray.setCapacity(50.0);
        wingTray.setCurrentWeight(20.0);

        trayRepository.saveAll(List.of(legTray, wingTray));

        // Seed products
        Product product1 = new Product();
        product1.setDescription("Pack of 2 Legs");
        product1.setTrays(List.of(legTray));
        product1.setStatus(Product.ProductStatus.ACTIVE); // Set default status

        Product product2 = new Product();
        product2.setDescription("Pack of Wings");
        product2.setTrays(List.of(wingTray));
        product2.setStatus(Product.ProductStatus.ACTIVE); // Set default status

        productRepository.saveAll(List.of(product1, product2));

        System.out.println("Packing Service database seeded with dummy data.");
    }
}
