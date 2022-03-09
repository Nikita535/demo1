package com.example.demo.repositoies;

import com.example.demo.entity.Manufacture;
import com.example.demo.entity.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.*;

@Repository
public interface ManufactureRep extends JpaRepository<Manufacture,Long>{

    Manufacture findManufactureByName(String name);
    List<Manufacture> findAllBy();
    @Transactional
    void deleteManufactureByName(String name);

    @Modifying
    @Query(value = "COPY postgres.jpa.manufacture " +
            "TO 'C:\\Users\\user\\Desktop\\demo\\src\\main\\resources\\EntityInf\\manufacture.csv'" +
            "delimiter ',' " +
            "csv header encoding 'UTF-8'", nativeQuery = true)
    void saveManufacture();

}
