package com.example.test_criterial2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    @Id
    private String id;

    private String line1;

    private String line2;

    private String city;

    @Enumerated(EnumType.STRING)
    private STATE state;

    private String pincode;
}
