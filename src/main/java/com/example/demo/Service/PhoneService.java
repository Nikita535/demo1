package com.example.demo.Service;

import com.example.demo.entity.Manufacture;
import com.example.demo.entity.Phone;

import java.util.List;


public interface PhoneService{
    Phone addPhone(String name,String Manufacture,String creationYear);
    boolean removePhone(String name);
}
