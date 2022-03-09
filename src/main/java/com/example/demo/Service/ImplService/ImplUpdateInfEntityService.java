package com.example.demo.Service.ImplService;


import com.example.demo.Service.UpdateInfEntityService;
import com.example.demo.repositoies.ManufactureRep;
import com.example.demo.repositoies.PhoneRep;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
@RequiredArgsConstructor
@Slf4j
public class ImplUpdateInfEntityService implements UpdateInfEntityService {

    @Autowired
    private ManufactureRep manufactureRep;
    @Autowired
    private PhoneRep phoneRep;

//    @Scheduled(cron ="*/30 * * * *")
//    for test
    @Scheduled(cron="0 * * * * *")
    @Transactional
    @Override
    public void saveEntities() {
        manufactureRep.saveManufacture();
        phoneRep.savePhone();
        log.info("Entities saved");
    }
}
