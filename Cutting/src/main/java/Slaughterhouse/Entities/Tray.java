package Slaughterhouse.Entities;

import Slaughterhouse.Entities.Part;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "trays")
public class Tray {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "capacity", nullable = false)
    private double capacity;

    @Column(name = "current_weight", nullable = false)
    private double currentWeight = 0;

    @OneToMany(mappedBy = "tray", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Part> parts = new ArrayList<>();

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

    public double getCapacity() {
        return capacity;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }

    public double getCurrentWeight() {
        return currentWeight;
    }

    public void setCurrentWeight(double currentWeight) {
        if (currentWeight > this.capacity) {
            throw new IllegalArgumentException("Current weight cannot exceed capacity.");
        }
        this.currentWeight = currentWeight;
    }

    public List<Part> getParts() {
        return parts == null ? new ArrayList<>() : parts;
    }

    public void setParts(List<Part> parts) {
        this.parts = parts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tray tray = (Tray) o;
        return id != null && id.equals(tray.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
