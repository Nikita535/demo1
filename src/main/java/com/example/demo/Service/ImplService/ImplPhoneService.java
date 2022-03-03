package com.example.demo.Service.ImplService;

import com.example.demo.Service.PhoneService;
import com.example.demo.entity.Phone;
import com.example.demo.repositoies.ManufactureRep;
import com.example.demo.repositoies.PhoneRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImplPhoneService implements PhoneService {

    @Autowired
    private PhoneRep phoneRep;
    @Autowired
    private ManufactureRep manufactureRep;

    @Override
    public Phone addPhone(String name, String manufacture, String creationYear) {
        Phone phone = phoneRep.findPhoneByName(name);
        if(phone==null){
            phone=new Phone(name,creationYear);
            phone.setManufacture(manufactureRep.findManufactureByName(manufacture));
            phoneRep.save(phone);
            return phone;
        }
        return null;
    }

    @Override
    public boolean removePhone(String name) {
        if(phoneRep.findPhoneByName(name) != null){
            phoneRep.deletePhoneByName(name);
            return true;
        }return false;
    }
}
