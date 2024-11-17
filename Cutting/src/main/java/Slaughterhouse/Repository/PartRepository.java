package Slaughterhouse.Repository;

import Slaughterhouse.Entities.Part;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PartRepository extends JpaRepository<Part, Integer> {

    // Find all parts of a specific animal
    List<Part> findByAnimalId(Integer animalId);

    // Find all parts of a specific type
    List<Part> findByType(String type);
}
