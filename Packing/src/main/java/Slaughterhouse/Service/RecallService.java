package Slaughterhouse.Service;

import Slaughterhouse.Entities.Animal;
import Slaughterhouse.Entities.Part;
import Slaughterhouse.Entities.Product;
import Slaughterhouse.Entities.Recall;
import Slaughterhouse.Repository.RecallRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecallService {

    @Autowired
    private RecallRepository recallRepository;

    @Autowired
    private CuttingService cuttingService;

    @Autowired
    private PackingService packingService;

    public Recall initiateRecall(Integer animalId) {
        // Fetch the animal details from CuttingService
        Animal animal = cuttingService.getAnimalById(animalId);
        if (animal == null) {
            throw new RuntimeException("Animal not found with ID: " + animalId);
        }

        // Find all affected products via PackingService
        List<Product> affectedProducts = packingService.getProductsByAnimal(animalId);

        // Mark all related products as recalled
        affectedProducts.forEach(product -> packingService.markProductRecalled(product.getId()));

        // Save recall details to the database
        Recall recall = new Recall();
        recall.setAnimalId(animalId);
        recall.setDateInitiated(LocalDate.now().toString());
        recall.setAffectedProducts(
                affectedProducts.stream()
                        .map(product -> product.getId().toString())
                        .collect(Collectors.joining(","))
        );
        return recallRepository.save(recall);
    }
}
