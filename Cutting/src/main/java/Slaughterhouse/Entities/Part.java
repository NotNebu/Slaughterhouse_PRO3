package Slaughterhouse.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "parts")
public class Part {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String type;

    private Double weight;

    @ManyToOne
    @JoinColumn(name = "tray_id", nullable = false)
    private Tray tray;

    @ManyToOne
    @JoinColumn(name = "animal_id", nullable = false)
    private Animal animal;

    // Getters and setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Tray getTray() {
        return tray;
    }

    public void setTray(Tray tray) {
        this.tray = tray;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }
}
