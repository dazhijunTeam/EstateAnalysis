package com.dazhijunteam.estate.repository;

import com.dazhijunteam.estate.bean.HouseInfos;
import com.dazhijunteam.estate.dataobject.DistrictEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HouseInfosRepository extends JpaRepository<HouseInfos,String> {
    HouseInfos getByHouseId(String communityid);
}
