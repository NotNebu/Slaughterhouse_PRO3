package Slaughterhouse;

import Slaughterhouse.Entities.Product;
import Slaughterhouse.Entities.Recall;
import Slaughterhouse.Repository.RecallRepository;
import Slaughterhouse.Service.PackingService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class RecallSimulation implements CommandLineRunner {

    private final RecallRepository recallRepository;
    private final PackingService packingService;

    public RecallSimulation(RecallRepository recallRepository, PackingService packingService) {
        this.recallRepository = recallRepository;
        this.packingService = packingService;
    }

    @Override
    public void run(String... args) {
        // Simulér en recall baseret på et animal ID
        Integer testAnimalId = 1;

        // Hent produkter relateret til animal ID fra Packing Service
        List<Product> affectedProducts = packingService.getProductsByAnimal(testAnimalId);

        if (!affectedProducts.isEmpty()) {
            // Markér produkter som recalled
            affectedProducts.forEach(product -> packingService.markProductRecalled(product.getId()));

            // Gem recall i databasen
            Recall recall = new Recall();
            recall.setAnimalId(testAnimalId);
            recall.setDateInitiated(LocalDate.now().toString());
            recall.setAffectedProducts(
                    affectedProducts.stream()
                            .map(product -> product.getId().toString())
                            .reduce((id1, id2) -> id1 + "," + id2)
                            .orElse("")
            );

            recallRepository.save(recall);

            System.out.println("Recall simulation completed for animal ID: " + testAnimalId);
        } else {
            System.out.println("No products found for recall simulation.");
        }
    }
}
