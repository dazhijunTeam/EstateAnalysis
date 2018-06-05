package com.dazhijunteam.estate.serviceimpl;

import com.dazhijunteam.estate.dataobject.CommunityEntity;
import com.dazhijunteam.estate.service.CommunityService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Slf4j
public class CommunityServiceImplTest {

    @Autowired
    private CommunityService communityService;

    @Test
    public void findByCommunityCityidandIscheap() {
        byte b=1;
        List<CommunityEntity> unsortComm= communityService.findByCommunityCityidandIscheap("1",b);

        System.out.println(unsortComm);

    }
}