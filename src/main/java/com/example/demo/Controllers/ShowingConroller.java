package com.example.demo.Controllers;

import com.example.demo.entity.Manufacture;
import com.example.demo.entity.Phone;
import com.example.demo.repositoies.ManufactureRep;
import com.example.demo.repositoies.PhoneRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/show")
public class ShowingConroller {

    @Autowired
    private ManufactureRep manufactureRep;
    @Autowired
    private PhoneRep phoneRep;

    @GetMapping("/manufacture")
    public List<Manufacture> showManufacture(){
        return manufactureRep.findAllBy();
    }

    @GetMapping("/manufacture/{name}")
    public List<Phone> showManufacturePhone(@PathVariable String name){

        return phoneRep.findAllBy();
    }

}

