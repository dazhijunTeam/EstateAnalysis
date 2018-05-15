package com.dazhijunteam.estate.serviceimpl;

import com.dazhijunteam.estate.dataobject.CityEntity;
import com.dazhijunteam.estate.enums.CityEnum;
import com.dazhijunteam.estate.service.CityService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Slf4j
public class CityServiceImplTest {
    @Autowired
    private CityService cityService;

    @Test
    public void getByCityId() {
        System.out.println(cityService.getByCityId("1").getCityName());
    }

    @Test
    public void savecity(){
        CityEntity cityEntity=new CityEntity();
        for(CityEnum cityEnum:CityEnum.values()){
            cityEntity.setCityFirst(cityEnum.cityFirst);
            cityEntity.setCityId(cityEnum.code);
            cityService.save(cityEntity);
        }
    }
}