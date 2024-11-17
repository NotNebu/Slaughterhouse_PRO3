package Slaughterhouse.Repository;

import Slaughterhouse.Entities.Tray;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrayRepository extends JpaRepository<Tray, Integer> {

    // Find all trays of a specific type
    List<Tray> findByType(String type);
}

