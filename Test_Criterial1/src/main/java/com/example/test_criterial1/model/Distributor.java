package com.example.test_criterial1.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
@Data
@Getter
@Setter
public class Distributor {
    @Id
    private String id;

    private String name;

    @OneToOne
    private Address address;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }
}
