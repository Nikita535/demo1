package com.example.demo.Controllers;

import com.example.demo.Service.ManufactureService;
import com.example.demo.Service.PhoneService;
import com.example.demo.repositoies.ManufactureRep;
import com.example.demo.repositoies.PhoneRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/delete")
public class RemovingController {

    @Autowired
    private ManufactureService manufactureService;
    @Autowired
    private PhoneService phoneService;


    @GetMapping("/manufacture/{name}")
    public String removeManufacture(@PathVariable String name){
        if(manufactureService.removeManufacture(name)){
            return "This manufacture was deleted";
        }else{
            return "This manufacture not found";
        }
    }

    @GetMapping("/phone/{name}")
    public String removePhone(@PathVariable String name){
        if(phoneService.removePhone(name)){
            return "This phone was deleted";
        }else{
            return "This phone not found";
        }
    }

}
