package com.dazhijunteam.estate.serviceimpl;

import com.dazhijunteam.estate.dataobject.CityEntity;
import com.dazhijunteam.estate.repository.CityRepository;
import com.dazhijunteam.estate.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements CityService{
    @Autowired
    private CityRepository repository;

    @Override
    public CityEntity findByCityName(String name) {
        return repository.findByCityName(name);
    }

    @Override
    public CityEntity getByCityId(String s) {
        return repository.getByCityId(s);
    }

    @Override
    public List<CityEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public CityEntity save(CityEntity cityEntity) {
        return repository.save(cityEntity);
    }


}
