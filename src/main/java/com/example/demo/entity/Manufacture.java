package com.example.demo.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table
@Getter
@Setter
public class Manufacture {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;
    private String name;
    private String address;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "manufacture",fetch=FetchType.LAZY)
    private final Set<Phone> phone=new HashSet<Phone>();


    //создать table
    public Manufacture() {}

    public Manufacture(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public Set<Phone> getPhone() {
        return phone;
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
