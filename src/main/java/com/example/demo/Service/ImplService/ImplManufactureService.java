package com.example.demo.Service.ImplService;

import com.example.demo.Aspect.LogExecutionTime;
import com.example.demo.Service.EmailService;
import com.example.demo.Service.ManufactureService;
import com.example.demo.entity.Manufacture;
import com.example.demo.repositoies.ManufactureRep;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
@Slf4j
public class ImplManufactureService implements ManufactureService {

    @Autowired
    private ManufactureRep manufactureRep;
    @Autowired
    private EmailService emailService;




    @LogExecutionTime
    @Override
    public Manufacture addManufacture(String name, String address) {
        Manufacture manufacture=manufactureRep.findManufactureByName(name);
        if (manufacture==null){
            manufacture=new Manufacture(name,address);
            manufactureRep.save(manufacture);
            log.info("manufacture created");
            emailService.sendSimpleMessage("- "+manufacture.getName()+" created");
            return manufacture;
        }else {
            log.info("manufacture already exist");
            return null;
        }
    }

    //для 24 добавил, поэтому тут без приколов и проверок. Просто, чтобы было

    public  List<Manufacture> showAllManufacture() {
            return manufactureRep.findAllBy();
    }



    @Override
    @LogExecutionTime
    public boolean removeManufacture(String name) {
        if(manufactureRep.findManufactureByName(name)!=null) {
            Manufacture manufacture=manufactureRep.findManufactureByName(name);
            manufactureRep.deleteManufactureByName(name);
            log.info("manufacture deleted");
            emailService.sendSimpleMessage("manufacture - "+manufacture.getName()+" deleted");
            return true;
        }else{
            log.info("manufacture doesnt exist");
            return false;
        }
    }

}
