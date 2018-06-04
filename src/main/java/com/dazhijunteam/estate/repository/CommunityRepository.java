package com.dazhijunteam.estate.repository;

import com.dazhijunteam.estate.dataobject.CommunityEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommunityRepository extends JpaRepository<CommunityEntity,String>{
    List<CommunityEntity> findByCommunityDistrictid(String districtid);
}
