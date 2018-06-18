package com.dazhijunteam.estate.service;

import com.dazhijunteam.estate.dataobject.CityEntity;
import com.dazhijunteam.estate.dataobject.CommunityEntity;
import com.dazhijunteam.estate.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CityService {

    CityEntity findByCityName(String name);

    CityEntity getByCityId(String s);

    List<CityEntity> findAll();

    CityEntity save(CityEntity cityEntity);

}
