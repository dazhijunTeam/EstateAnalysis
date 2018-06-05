package com.dazhijunteam.estate.repository;

import com.dazhijunteam.estate.dataobject.CommunityEntity;
import org.hibernate.validator.constraints.Email;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommunityRepository extends JpaRepository<CommunityEntity,String>{
    Page<CommunityEntity> findCommunityEntityByCommunityDistrictidIn(Pageable pageable,List<String> districtids);

    Page<CommunityEntity> findByCommunityDistrictid(Pageable pageable,String districtid);

    List<CommunityEntity> findCommunityEntityByCommunityDistrictidInAndIsCheap(List<String> districtids,Byte ischeap);
}
