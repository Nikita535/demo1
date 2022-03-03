package com.example.demo.repositoies;

import com.example.demo.entity.Manufacture;
import com.example.demo.entity.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ManufactureRep extends JpaRepository<Manufacture,Long>{

    Manufacture findManufactureByName(String name);
    List<Manufacture> findAllBy();

    @Transactional
    void deleteManufactureByName(String name);

}
