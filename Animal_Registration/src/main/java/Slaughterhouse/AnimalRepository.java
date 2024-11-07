package Slaughterhouse;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Integer> {
    List<Animal> findByArrivalDate(LocalDate date);
    List<Animal> findByOrigin(String origin);
}
