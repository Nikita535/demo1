package com.example.demo.Controllers;

import com.example.demo.Service.ManufactureService;
import com.example.demo.Service.PhoneService;
import com.example.demo.entity.Manufacture;
import com.example.demo.entity.Phone;
import com.example.demo.repositoies.ManufactureRep;
import com.example.demo.repositoies.PhoneRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/add")
public class AddingController {

    @Autowired
    private ManufactureService manufactureService;
    @Autowired
    private PhoneService phoneService;

    @GetMapping("/manufacture/{name}/{address}")
    public String addManufacture(@PathVariable String name, @PathVariable String address) {
        if (manufactureService.addManufacture(name, address)!=null) {
            return "Manufacture created";
        } else {
            return "This manufacture already exists";
        }
    }


    @GetMapping("/phone/{manufacture}/{name}/{creationYear}")
    public String addPhone(@PathVariable String name, @PathVariable String manufacture, @PathVariable String creationYear) {
        if (phoneService.addPhone(name,manufacture,creationYear) != null) {
            return "Phone added";
        } else {
            return "This phone already exists";
        }

    }
}
