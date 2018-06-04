package com.dazhijunteam.estate.repository;

import com.dazhijunteam.estate.dataobject.DistrictEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;


public interface DistrictRepository extends JpaRepository<DistrictEntity,String>{

    List<DistrictEntity> getByDistrictCityid(String id);


}
