package com.dazhijunteam.estate.repository;

import com.dazhijunteam.estate.bean.HouseInfos;
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
public class HouseInfosRepositoryTest {
    @Autowired
    private HouseInfosRepository houseInfosRepository;

    @Autowired
    private HouseTypeInfosRepository houseTypeInfosRepository;

    @Autowired
    private UserCommentRepository userCommentRepository;

    @Test
    public void save(){
        HouseInfos infos=new HouseInfos();

    }
}