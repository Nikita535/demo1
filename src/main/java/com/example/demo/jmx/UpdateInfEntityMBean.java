package com.example.demo.jmx;


import com.example.demo.Service.UpdateInfEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Component;

@Component
@ManagedResource(description = "App for saving DataBase")
public class UpdateInfEntityMBean {

    @Autowired
    private UpdateInfEntityService updateInfEntityService;


    @ManagedOperation(description = "Save all entities in .csv files on server machine")
    public void save(){updateInfEntityService.saveEntities();}
}
