package com.example.demo.Service.ImplService;

import com.example.demo.Service.ManufactureService;
import com.example.demo.entity.Manufacture;
import com.example.demo.repositoies.ManufactureRep;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.swing.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ImplManufactureServiceTest {

    @Autowired
    private ManufactureService manufactureService;

    @Test
    void addManufacture() {
        boolean isCreated;
        Manufacture manufacture1=manufactureService.addManufacture("apple","UZ");
        if (manufacture1!=null){
            isCreated=true;
        }else {isCreated=false;}
        Assertions.assertTrue(isCreated);

    }

    @Test
    void showAllManufacture() {
        List<Manufacture> list=manufactureService.showAllManufacture();
        Assertions.assertEquals(1,list.size());
    }


    @Test
    void removeManufacture() {
        Assertions.assertTrue(manufactureService.removeManufacture("apple1"));
    }
}