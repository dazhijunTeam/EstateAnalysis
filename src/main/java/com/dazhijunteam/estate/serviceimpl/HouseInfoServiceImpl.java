package com.dazhijunteam.estate.serviceimpl;

import com.dazhijunteam.estate.bean.HouseInfos;
import com.dazhijunteam.estate.repository.HouseInfosRepository;
import com.dazhijunteam.estate.service.HouseInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HouseInfoServiceImpl implements HouseInfoService{

    @Autowired
    private HouseInfosRepository houseInfosRepository;

    @Override
    public HouseInfos getByHouseId(String communityid) {
        return houseInfosRepository.getByHouseId(communityid);
    }
}
