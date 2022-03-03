package com.example.demo.Controllers;

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
    private ManufactureRep manufactureRep;
    @Autowired
    private PhoneRep phoneRep;

    @GetMapping("/manufacture/{name}/{address}")
    public String addManufacture(@PathVariable String name, @PathVariable String address) {
        if (manufactureRep.findManufactureByName(name) == null) {
            Manufacture manufacture = new Manufacture(name, address);
            manufactureRep.save(manufacture);
            return "Manufacture created";
        } else {
            return "This manufacture already exists";
        }
    }


    @GetMapping("/phone/{manufacture}/{name}/{creationYear}")
    public String addPhone(@PathVariable String name, @PathVariable String manufacture, @PathVariable String creationYear) {
        Phone phone = new Phone(name, creationYear);
        if (manufactureRep.findManufactureByName(manufacture) != null) {
            phone.setManufacture(manufactureRep.findManufactureByName(manufacture));
            phoneRep.save(phone);
            return "Phone added";
        } else {
            return "This phone already exists";
        }

    }
}
