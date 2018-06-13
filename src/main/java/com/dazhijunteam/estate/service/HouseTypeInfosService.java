package com.dazhijunteam.estate.service;

import com.dazhijunteam.estate.bean.HouseTypeInfos;

import java.util.List;

public interface HouseTypeInfosService {
    List<HouseTypeInfos> findByHouseId(String communityid);
}
