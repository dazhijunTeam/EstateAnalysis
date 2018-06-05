package com.dazhijunteam.estate.serviceimpl;

import com.dazhijunteam.estate.dataobject.DistrictEntity;
import com.dazhijunteam.estate.repository.DistrictRepository;
import com.dazhijunteam.estate.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DistrictServiceImpl implements DistrictService{

    @Autowired
    private DistrictRepository repository;

    @Override
    public List<DistrictEntity> getByDistrictCityid(String id) {
        return repository.getByDistrictCityid(id);
    }

    @Override
    public List<String> getdistrictIdByCityId(String s){
        List<DistrictEntity> districtEntities=getByDistrictCityid(s);
        List<String> districtIds=new ArrayList<>();
        for (DistrictEntity districtEntity:districtEntities){
            districtIds.add(districtEntity.getDistrictId());
        }
        return districtIds;
    }

    @Override
    public String getCityIdBydistrictId(String districtId) {
        return repository.getByDistrictId(districtId).getDistrictCityid();
    }
}
