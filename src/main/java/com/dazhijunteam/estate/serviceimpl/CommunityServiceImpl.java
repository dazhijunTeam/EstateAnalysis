package com.dazhijunteam.estate.serviceimpl;

import com.dazhijunteam.estate.dataobject.CommunityEntity;
import com.dazhijunteam.estate.repository.CommunityRepository;
import com.dazhijunteam.estate.service.CommunityService;
import com.dazhijunteam.estate.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class CommunityServiceImpl implements CommunityService{

    @Autowired
    private CommunityRepository communityRepository;

    @Autowired
    private DistrictService districtService;

    @Override
    public CommunityEntity getOne(String communityid) {
        return communityRepository.getOne(communityid);
    }

    @Override
    public Page<CommunityEntity> findByCommunityCityid(Pageable pageable,String cityid) {
        List<String> districtIds=districtService.getdistrictIdByCityId(cityid);
        Page<CommunityEntity> communityEntities=communityRepository.findCommunityEntityByCommunityDistrictidIn(pageable,districtIds);
        return communityEntities;
    }

    @Override
    public Page<CommunityEntity> findByCommunityDistrictid(Pageable pageable,String districtid) {
        return communityRepository.findByCommunityDistrictid(pageable,districtid);
    }

    @Override
    public List<CommunityEntity> findByCommunityCityidandIscheap(String cityid, Byte b) {
        List<String> districtIds=districtService.getdistrictIdByCityId(cityid);
        List<CommunityEntity> communityEntities=communityRepository.findCommunityEntityByCommunityDistrictidInAndIsCheap(districtIds,b);
        Collections.shuffle(communityEntities);
        List<CommunityEntity> unsortComm=new ArrayList<>();
        for (int i=0;i<10;i++){
            unsortComm.add(communityEntities.get(i));
        }
        return unsortComm;
    }

    @Override
    public List<CommunityEntity> findAll() {
        return communityRepository.findAll();
    }
}
