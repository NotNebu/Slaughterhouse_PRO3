package Slaughterhouse.Repository;

import Slaughterhouse.Entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findByStatus(Product.ProductStatus status);

    @Query("SELECT p FROM Product p JOIN p.trays t JOIN t.parts pt WHERE pt.animal.id = :animalId")
    List<Product> findByAnimalId(@Param("animalId") Integer animalId);
}
