package Slaughterhouse.Repository;

import Slaughterhouse.Entities.Recall;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecallRepository extends JpaRepository<Recall, Integer> {
}
