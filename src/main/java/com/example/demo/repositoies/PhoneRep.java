package com.example.demo.repositoies;

import com.example.demo.entity.Manufacture;
import com.example.demo.entity.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface PhoneRep extends JpaRepository<Phone,Long> {

    Phone findPhoneByName(String name);
    List<Phone> findAllById(Long id);
    @Transactional
    void deletePhoneByName(String name);


    @Modifying
    @Query(value = "COPY postgres.jpa.phone " +
            "TO 'C:\\Users\\user\\Desktop\\demo\\src\\main\\resources\\EntityInf\\phone.csv'" +
            "delimiter ',' " +
            "csv header encoding 'UTF-8'", nativeQuery = true)
    void savePhone();
}
