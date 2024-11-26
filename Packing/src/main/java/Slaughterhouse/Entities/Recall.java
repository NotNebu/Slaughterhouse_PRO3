package Slaughterhouse.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "recalls")
public class Recall {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "animal_id", nullable = false)
    private Integer animalId;

    @Column(name = "date_initiated", nullable = false)
    private String dateInitiated;

    @Column(name = "affected_products")
    private String affectedProducts;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAnimalId() {
        return animalId;
    }

    public void setAnimalId(Integer animalId) {
        this.animalId = animalId;
    }

    public String getDateInitiated() {
        return dateInitiated;
    }

    public void setDateInitiated(String dateInitiated) {
        this.dateInitiated = dateInitiated;
    }

    public String getAffectedProducts() {
        return affectedProducts;
    }

    public void setAffectedProducts(String affectedProducts) {
        this.affectedProducts = affectedProducts;
    }
}

