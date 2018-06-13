package com.dazhijunteam.estate.service;

import com.dazhijunteam.estate.dataobject.CommunityEntity;
import com.dazhijunteam.estate.dataobject.NewsEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CommunityService {
    //通过房产的id来查询
    CommunityEntity getOne(String communityid);

    //通过城市的id来显示房地产信息
    public Page<CommunityEntity> findByCommunityCityid(Pageable pageable, String cityid);

    //通过区号的id来显示房地产信息
    public Page<CommunityEntity> findByCommunityDistrictid(Pageable pageable, String districtid);

    //通过城市的id乱序的取出固定十个优惠楼盘
    public List<CommunityEntity> findByCommunityCityidandIscheap(String cityid, Byte b);

    //查找所有的房产信息
    public List<CommunityEntity> findAll();
}
