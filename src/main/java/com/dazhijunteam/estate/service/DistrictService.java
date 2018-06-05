package com.dazhijunteam.estate.service;

import com.dazhijunteam.estate.dataobject.DistrictEntity;

import java.util.List;

public interface DistrictService {

    //通过cityid得到所有区号
    List<DistrictEntity> getByDistrictCityid(String id);

    List<String> getdistrictIdByCityId(String s);

    //通过districtCityId来得到cityId信息
    String getCityIdBydistrictId(String districtId);

}