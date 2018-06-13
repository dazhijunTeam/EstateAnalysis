package com.dazhijunteam.estate.repository;

import com.dazhijunteam.estate.bean.HouseTypeInfos;
import com.dazhijunteam.estate.dataobject.DistrictEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HouseTypeInfosRepository extends JpaRepository<HouseTypeInfos,String> {
    List<HouseTypeInfos> findByHouseId(String communityid);
}
