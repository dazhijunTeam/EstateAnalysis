package com.dazhijunteam.estate.serviceimpl;

import com.dazhijunteam.estate.bean.HouseTypeInfos;
import com.dazhijunteam.estate.repository.HouseTypeInfosRepository;
import com.dazhijunteam.estate.service.HouseTypeInfosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HouseTypeInfosServiceImpl implements HouseTypeInfosService{
    @Autowired
    private HouseTypeInfosRepository houseTypeInfosRepository;

    @Override
    public List<HouseTypeInfos> findByHouseId(String communityid) {
        return houseTypeInfosRepository.findByHouseId(communityid);
    }
}
