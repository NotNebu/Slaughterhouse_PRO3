package Slaughterhouse.Controller;

import Slaughterhouse.Entities.Animal;
import Slaughterhouse.Entities.Part;
import Slaughterhouse.Entities.Tray;
import Slaughterhouse.Repository.AnimalRepository;
import Slaughterhouse.Repository.PartRepository;
import Slaughterhouse.Repository.TrayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/cutting")
public class CuttingController {

    @Autowired
    private PartRepository partRepository;

    @Autowired
    private TrayRepository trayRepository;

    @Autowired
    private AnimalRepository animalRepository; // Tilføjet for at hente dyredata direkte

    // Register a new part with reference to an animal
    @PostMapping("/parts")
    public Part registerAndAssignPart(@RequestBody Part part, @RequestParam Integer animalId) {
        Animal animal = animalRepository.findById(animalId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Animal not found"));

        part.setAnimal(animal);

        // Find en passende tray
        Tray tray = trayRepository.findAll().stream()
                .filter(t -> t.getCapacity() >= t.getCurrentWeight() + part.getWeight())
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No suitable tray found"));

        // Tildel delen til bakken
        part.setTray(tray);
        tray.setCurrentWeight(tray.getCurrentWeight() + part.getWeight());

        trayRepository.save(tray); // Opdater bakken
        return partRepository.save(part); // Gem delen
    }


    // Retrieve all parts for a specific animal
    @GetMapping("/parts/animal/{animalId}")
    public List<Part> getPartsByAnimal(@PathVariable Integer animalId) {
        // Hent dele fra databasen baseret på dyrets ID
        return partRepository.findByAnimalId(animalId);
    }

    // Retrieve all trays of a specific type
    @GetMapping("/trays")
    public List<Tray> getTraysByType(@RequestParam String type) {
        // Hent bakker af en bestemt type
        return trayRepository.findByType(type);
    }

    // Create a new tray
    @PostMapping("/trays")
    public Tray createTray(@RequestBody Tray tray) {
        tray.setCurrentWeight(0.0); // Initial vægt
        return trayRepository.save(tray);
    }
}
