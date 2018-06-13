package com.dazhijunteam.estate.service;

import com.dazhijunteam.estate.bean.HouseInfos;

public interface HouseInfoService {
    //通过communityid来得到房子的详细的信息
    HouseInfos getByHouseId(String communityid);
}
