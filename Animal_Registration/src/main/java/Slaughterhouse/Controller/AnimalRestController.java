package Slaughterhouse.Controller;

import Slaughterhouse.Entities.Animal;
import Slaughterhouse.Repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/animals")
public class AnimalRestController {

    @Autowired
    private AnimalRepository animalRepository;

    // Endpoint to register a new animal
    @PostMapping
    public Animal registerAnimal(@RequestBody Animal animal) {
        return animalRepository.save(animal);
    }

    // Endpoint to retrieve a specific animal by ID
    @GetMapping("/{id}")
    public Optional<Animal> getAnimal(@PathVariable Integer id) {
        return animalRepository.findById(id);
    }

    @GetMapping
    public List<Animal> getAnimalsByDateOrOrigin(
            @RequestParam(required = false) String date,
            @RequestParam(required = false) String origin) {
        if (date != null) {
            return animalRepository.findByArrivalDate(date);
        } else if (origin != null) {
            return animalRepository.findByOrigin(origin);
        }
        return animalRepository.findAll();
    }
}
