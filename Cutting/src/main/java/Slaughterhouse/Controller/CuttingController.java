package Slaughterhouse.Controller;

import Slaughterhouse.Entities.Part;
import Slaughterhouse.Entities.Tray;
import Slaughterhouse.Repository.PartRepository;
import Slaughterhouse.Repository.TrayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cutting")
public class CuttingController {

    @Autowired
    private PartRepository partRepository;

    @Autowired
    private TrayRepository trayRepository;

    // Register a new part
    @PostMapping("/parts")
    public Part registerPart(@RequestBody Part part) {
        return partRepository.save(part);
    }

    // Assign a part to a tray
    @PutMapping("/parts/{partId}/assign-tray/{trayId}")
    public Part assignPartToTray(@PathVariable Integer partId, @PathVariable Integer trayId) {
        Part part = partRepository.findById(partId)
                .orElseThrow(() -> new RuntimeException("Part not found"));

        Tray tray = trayRepository.findById(trayId)
                .orElseThrow(() -> new RuntimeException("Tray not found"));

        // Check if the tray has enough capacity
        if (tray.getCurrentWeight() + part.getWeight() > tray.getCapacity()) {
            throw new RuntimeException("Tray capacity exceeded");
        }

        // Assign the part to the tray and update the tray's weight
        part.setTray(tray);
        tray.setCurrentWeight(tray.getCurrentWeight() + part.getWeight());

        // Save changes
        trayRepository.save(tray);
        return partRepository.save(part);
    }

    // Retrieve all parts for a specific animal
    @GetMapping("/parts/animal/{animalId}")
    public List<Part> getPartsByAnimal(@PathVariable Integer animalId) {
        return partRepository.findByAnimalId(animalId);
    }

    // Retrieve all trays of a specific type
    @GetMapping("/trays")
    public List<Tray> getTraysByType(@RequestParam String type) {
        return trayRepository.findByType(type);
    }

    // Create a new tray
    @PostMapping("/trays")
    public Tray createTray(@RequestBody Tray tray) {
        return trayRepository.save(tray);
    }
}

