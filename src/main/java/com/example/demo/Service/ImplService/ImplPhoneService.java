package com.example.demo.Service.ImplService;

import com.example.demo.Aspect.LogExecutionTime;
import com.example.demo.Service.EmailService;
import com.example.demo.Service.PhoneService;
import com.example.demo.entity.Phone;
import com.example.demo.repositoies.ManufactureRep;
import com.example.demo.repositoies.PhoneRep;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ImplPhoneService implements PhoneService {

    @Autowired
    private PhoneRep phoneRep;
    @Autowired
    private ManufactureRep manufactureRep;
    @Autowired
    private EmailService emailService;

    @LogExecutionTime
    @Override
    public Phone addPhone(String name, String manufacture, String creationYear) {
        Phone phone = phoneRep.findPhoneByName(name);
        if(phone==null){
            phone=new Phone(name,creationYear);
            phone.setManufacture(manufactureRep.findManufactureByName(manufacture));
            phoneRep.save(phone);
            log.info("phone created");
            emailService.sendSimpleMessage("phone - "+phone.getName()+" added");
            return phone;
        } else {
            log.info("phone already exist");
            return null;
        }
    }

    @LogExecutionTime
    @Override
    public boolean removePhone(String name) {
        if(phoneRep.findPhoneByName(name) != null){
            Phone phone=phoneRep.findPhoneByName(name);
            phoneRep.deletePhoneByName(name);
            log.info("phone deleted");
            emailService.sendSimpleMessage("phone - "+phone.getName()+" deleted");
            return true;
        } else {
            log.info("phone doesnt exist");
            return false;
        }
    }
}
