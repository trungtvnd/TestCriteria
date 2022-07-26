package com.example.test_criterial2.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
@Data
public class Distributor {
    @Id
    private String id;

    private String name;

    @OneToOne
    private Address address;

}