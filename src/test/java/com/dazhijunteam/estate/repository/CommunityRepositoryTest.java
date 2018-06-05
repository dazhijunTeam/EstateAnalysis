package com.dazhijunteam.estate.repository;

import com.dazhijunteam.estate.dataobject.CommunityEntity;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Slf4j
public class CommunityRepositoryTest {

    @Autowired
    private CommunityRepository communityRepository;

    @Test
    public void findByCommunityDistrictid() {
        for (int i=1;i<=123;i++){
            if (communityRepository.findByCommunityDistrictid(new PageRequest(0,1000),i+"").getContent().size()==0){
                System.out.println(i+"==null");
            }
        }
    }

    @Test
    public void findCommunityEntityByCommunityDistrictidIn(){
        List<String> strings=new ArrayList<>();
        strings.add("1");
        strings.add("2");
        PageRequest p=new PageRequest(0,1000);
        List<CommunityEntity> entities=communityRepository.findCommunityEntityByCommunityDistrictidIn(p,strings).getContent();

        System.out.println(entities.size());
    }

    @Test
    public void findCommunityEntityByCommunityDistrictidInAndIsCheap(){
        List<String> strings=new ArrayList<>();
        strings.add("10");
        strings.add("2");
        PageRequest p=new PageRequest(0,1000);
        Byte b=1;
        List<CommunityEntity> entities=communityRepository.findCommunityEntityByCommunityDistrictidInAndIsCheap(strings,b);
        System.out.println(entities.size());
    }
}