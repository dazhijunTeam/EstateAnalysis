package com.dazhijunteam.estate.repository.mapper;

import com.dazhijunteam.estate.dataobject.CommunityEntity;
import com.dazhijunteam.estate.service.CityService;
import com.dazhijunteam.estate.service.DistrictService;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Slf4j
public class CommunityMapperTest {

    @Autowired
    private DistrictService districtService;

    @Autowired
    private CommunityMapper mapper;

    @Autowired
    private MapperService mapperService;


    @Test
    public void findByYouLike() {
        Map<String,Object> map=new HashMap<>();
        List<String> CityEntity=districtService.getdistrictIdByCityId("2");
        Integer lowPrice=1000;
        Integer highPrice=1000000;
        Integer lowTotalPrice=2000000;
        map.put("llll",CityEntity);
        map.put("lowPrice",lowPrice);
        map.put("highPrice",highPrice);
        map.put("lowTotalPrice",lowTotalPrice);
        List<CommunityEntity> communityEntities=mapper.findByYouLike(map);
        System.out.println(communityEntities.size());

    }

    @Test
    public void findByYouLike1(){
        PageInfo<CommunityEntity> fin=mapperService.findByYouLike("1",10000,12000,2000000,2,10);
        System.out.println(fin.getPageSize());
    }
}