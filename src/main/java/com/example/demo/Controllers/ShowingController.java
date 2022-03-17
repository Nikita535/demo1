package com.example.demo.Controllers;

import com.example.demo.Service.ManufactureService;
import com.example.demo.entity.Manufacture;
import com.example.demo.repositoies.ManufactureRep;
import com.example.demo.repositoies.PhoneRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;


@RestController
@RequestMapping("/show")
public class ShowingController {

    @Autowired
    private ManufactureRep manufactureRep;
    @Autowired
    ManufactureService manufactureService;


    @GetMapping("/manufacture")
    public String showManufacture(){
        return manufactureService.showAllManufacture().toString();
    }

    @GetMapping("/manufacture/{name}")
    public String showManufacturePhone(@PathVariable String name){
        return manufactureRep.findManufactureByName(name).toString();
    }

}

