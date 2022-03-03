package com.example.demo.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data
@Table
public class Phone {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;
    private String name;
    private String creationYear;


    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "manufactor_id")
    private Manufacture manufacture;

    public Phone() {
    }

    public Phone(String name, String creationYear) {
        this.name = name;
        this.creationYear = creationYear;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCreationYear() {
        return creationYear;
    }

    public Manufacture getManufacture() {
        return manufacture;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCreationYear(String creationYear) {
        this.creationYear = creationYear;
    }

    public void setManufacture(Manufacture manufacture) {
        this.manufacture = manufacture;
    }
}
