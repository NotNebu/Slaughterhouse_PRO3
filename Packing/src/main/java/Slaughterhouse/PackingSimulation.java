package Slaughterhouse;

import Slaughterhouse.Entities.Part;
import Slaughterhouse.Entities.Product;
import Slaughterhouse.Repository.ProductRepository;
import Slaughterhouse.Service.PackingService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PackingSimulation implements CommandLineRunner {

    private final ProductRepository productRepository;
    private final PackingService packingService;

    public PackingSimulation(ProductRepository productRepository, PackingService packingService) {
        this.productRepository = productRepository;
        this.packingService = packingService;
    }

    @Override
    public void run(String... args) {
        // Simulerer at hente dele for et specifikt dyr
        Integer animalId = 1; // Test ID
        List<Part> parts = packingService.getPartsByAnimal(animalId);

        if (!parts.isEmpty()) {
            // Simulerer at skabe et produkt baseret på dele
            Product product = new Product();
            product.setDescription("Product created from parts of Animal ID: " + animalId);
            product.setStatus(Product.ProductStatus.ACTIVE);

            // Gem produktet
            productRepository.save(product);

            System.out.println("Packing simulation completed with parts from Cutting Service.");
        } else {
            System.out.println("No parts found for the given animal ID in Cutting Service.");
        }
    }
}
