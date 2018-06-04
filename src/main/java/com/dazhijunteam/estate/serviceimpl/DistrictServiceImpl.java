package com.dazhijunteam.estate.serviceimpl;

import com.dazhijunteam.estate.dataobject.DistrictEntity;
import com.dazhijunteam.estate.repository.DistrictRepository;
import com.dazhijunteam.estate.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistrictServiceImpl implements DistrictService{

    @Autowired
    private DistrictRepository repository;

    @Override
    public List<DistrictEntity> getByDistrictCityid(String id) {
        return repository.getByDistrictCityid(id);
    }
}
