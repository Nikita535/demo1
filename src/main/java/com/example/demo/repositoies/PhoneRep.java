package com.example.demo.repositoies;

import com.example.demo.entity.Manufacture;
import com.example.demo.entity.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface PhoneRep extends JpaRepository<Phone,Long> {

    Phone findPhoneByName(String name);
    List<Phone> findAllBy();
    @Transactional
    void deletePhoneByName(String name);
}
