package com.dazhijunteam.estate.repository.mapper;

import com.dazhijunteam.estate.dataobject.CommunityEntity;
import com.dazhijunteam.estate.service.DistrictService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MapperService {
    @Autowired
    private DistrictService districtService;

    @Autowired
    private CommunityMapper mapper;

    //取出固定分页，通过最高最低价格来智能筛选符合用户需求的房子
    public PageInfo<CommunityEntity> findByYouLike(String cityId,Integer lowPrice, Integer highPrice, Integer lowTotalPrice,Integer page,Integer size){
        Map<String,Object> map=new HashMap<>();
        List<String> CityEntity=districtService.getdistrictIdByCityId(cityId);
        map.put("list",CityEntity);
        map.put("lowPrice",lowPrice);
        map.put("highPrice",highPrice);
        map.put("lowTotalPrice",lowTotalPrice);
        PageHelper.startPage(page, size);
        List<CommunityEntity> communityEntities=mapper.findByYouLike(map);
        PageInfo<CommunityEntity> pageInfo=new PageInfo<>(communityEntities);
        return pageInfo;
    }
}
