package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table
public class Manufacture {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;
    private String name;
    private String address;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "manufacture",fetch=FetchType.LAZY)
    private Set<Phone> phone=new HashSet<Phone>();


    //создать table
    public Manufacture() {}

    public Manufacture(String name, String address) {
        this.name = name;
        this.address = address;
    }



    @Override
    public String toString() {
        return "Manufacture{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone=" + phone +
                '}';
    }
}
