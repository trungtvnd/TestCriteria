package com.example.test_criterial1.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

@Entity
@Data
@Getter
@Setter
public class Address {
    @Id
    private String id;

    private String line1;

    private String line2;

    private String city;

    @Enumerated(EnumType.STRING)
    private STATE state;

    private String pincode;

    public String getId() {
        return id;
    }

    public String getLine1() {
        return line1;
    }

    public String getLine2() {
        return line2;
    }

    public String getCity() {
        return city;
    }

    public STATE getState() {
        return state;
    }

    public String getPincode() {
        return pincode;
    }
}