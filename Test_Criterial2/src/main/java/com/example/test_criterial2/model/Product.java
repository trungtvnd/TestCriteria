package com.example.test_criterial2.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
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
    @Getter
    @Setter
    public static class Dimension {
        private Double height;

        private Double width;
    }


}