package com.example.demo.Service;

import com.example.demo.entity.Manufacture;

import java.util.List;

public interface ManufactureService {
    Manufacture addManufacture(String name,String address);
    boolean removeManufacture(String name);
    List<Manufacture> showAllManufacture();


}
