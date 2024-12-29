package Slaughterhouse.Controller;

import Slaughterhouse.Entities.Product;
import Slaughterhouse.Entities.Tray;
import Slaughterhouse.Repository.ProductRepository;
import Slaughterhouse.Repository.TrayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/packing")
public class PackingController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private TrayRepository trayRepository;

    // Create a new product
    @PostMapping("/products")
    public Product createProduct(@RequestBody Product product) {
        // Ensure all trays exist
        for (Tray tray : product.getTrays()) {
            trayRepository.findById(tray.getId())
                    .orElseThrow(() -> new RuntimeException("Tray not found: " + tray.getId()));
        }

        return productRepository.save(product);
    }

    // Get all products or filter by status
    @GetMapping("/products")
    public List<Product> getProducts(@RequestParam(required = false) Product.ProductStatus status) {
        if (status != null) {
            return productRepository.findByStatus(status);
        }
        return productRepository.findAll();
    }

    // Get product by ID
    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable Integer id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }

    // Recall products related to a specific animal
    @GetMapping("/products/recall/{animalId}")
    public List<Product> recallProductsByAnimal(@PathVariable Integer animalId) {
        return productRepository.findByAnimalId(animalId);
    }

    // Mark a specific product as recalled
    @PutMapping("/products/{id}/recall")
    public ResponseEntity<String> markProductRecalled(@PathVariable Integer id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        product.setStatus(Product.ProductStatus.RECALLED);
        productRepository.save(product);
        return ResponseEntity.ok("Product marked as recalled");
    }
}
