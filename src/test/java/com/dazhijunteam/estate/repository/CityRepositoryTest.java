package com.dazhijunteam.estate.repository;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Slf4j
public class CityRepositoryTest {

    @Autowired
    private CityRepository repository;

    @Test
    public void getByCityId() {
        System.out.println(repository.findOne("1").getCityName().length());
    }

    @Test
    public void getOne() {
    }
}