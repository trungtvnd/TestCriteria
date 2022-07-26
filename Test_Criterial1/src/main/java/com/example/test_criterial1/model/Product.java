package com.example.test_criterial1.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Data
@Getter
@Setter
public class Product {
    @Id
    private String id;

    private String name;

    private Double price;

    private LocalDateTime manufacturingDate;

    @ManyToOne
    private Address manufacturingPlace;

    private Double weight;

    @Embedded
    private Dimension dimension;

    @ManyToOne
    private Distributor distributor;

    @Enumerated(EnumType.STRING)
    private Category category;

    @Embeddable
    @EqualsAndHashCode
    @Getter
    @Setter
    public static class Dimension implements Serializable {
        private Double height;

        private Double width;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public LocalDateTime getManufacturingDate() {
        return manufacturingDate;
    }

    public Address getManufacturingPlace() {
        return manufacturingPlace;
    }

    public Double getWeight() {
        return weight;
    }

    public Dimension getDimension() {
        return dimension;
    }

    public Distributor getDistributor() {
        return distributor;
    }

    public Category getCategory() {
        return category;
    }
}
