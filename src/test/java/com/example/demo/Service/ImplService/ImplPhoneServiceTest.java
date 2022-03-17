package com.example.demo.Service.ImplService;

import com.example.demo.Service.ManufactureService;
import com.example.demo.Service.PhoneService;
import com.example.demo.entity.Manufacture;
import com.example.demo.entity.Phone;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class ImplPhoneServiceTest {

    @Autowired
    private PhoneService phoneService;

    @Test
    void addPhone() {
        boolean isCreated;
        Phone phoneTest=phoneService.addPhone("iphone","apple","2021");
        if (phoneTest!=null){
            isCreated=true;
        }else {isCreated=false;}
        Assertions.assertTrue(isCreated);

    }

    @Test
    void removePhone() {
        Assertions.assertTrue(phoneService.removePhone("iphone"));
    }
}