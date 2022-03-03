package com.example.demo.Service.ImplService;

import com.example.demo.Service.ManufactureService;
import com.example.demo.entity.Manufacture;
import com.example.demo.repositoies.ManufactureRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ImplManufactureService implements ManufactureService {

    @Autowired
    private ManufactureRep manufactureRep;

    @Override
    public Manufacture addManufacture(String name, String address) {
        Manufacture manufacture=manufactureRep.findManufactureByName(name);
        if (manufacture==null){
            manufacture=new Manufacture(name,address);
            manufactureRep.save(manufacture);
            return manufacture;
        }
        return null;
    }

    @Override
    public boolean removeManufacture(String name) {
        if(manufactureRep.findManufactureByName(name)!=null) {
            manufactureRep.deleteManufactureByName(name);
            return true;
        } return false;
    }

}
