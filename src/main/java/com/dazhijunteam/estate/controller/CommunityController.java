package com.dazhijunteam.estate.controller;

import com.dazhijunteam.estate.dataobject.CityEntity;
import com.dazhijunteam.estate.dataobject.CommunityEntity;
import com.dazhijunteam.estate.dataobject.DistrictEntity;
import com.dazhijunteam.estate.dataobject.twoComm;
import com.dazhijunteam.estate.service.CityService;
import com.dazhijunteam.estate.service.CommunityService;
import com.dazhijunteam.estate.service.DistrictService;
import com.dazhijunteam.estate.util.CovertCommToList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/community")
public class CommunityController {

    @Autowired
    private CommunityService communityService;

    @Autowired
    private DistrictService districtService;

    @Autowired
    private CityService cityService;


    @GetMapping("/indexofcity")
    public ModelAndView getListCommunityEntityofcity(@RequestParam(value = "cityId",defaultValue = "1") String cityId,
                                               @RequestParam(value = "page",defaultValue = "1") Integer page,
                                               @RequestParam(value = "size",defaultValue = "10") Integer size,
                                               Map<String,Object> map){
        PageRequest pageRequest=new PageRequest(page-1,size);
        Page<CommunityEntity> communityEntityPage=communityService.findByCommunityCityid(pageRequest,cityId);
        List<DistrictEntity> districtEntities=districtService.getByDistrictCityid(cityId);
        List<CityEntity> cityEntities=cityService.findAll();
        byte ischeap=1;
        List<CommunityEntity> unSortComm=communityService.findByCommunityCityidandIscheap(cityId,ischeap);
        List<CommunityEntity> sortComm=communityEntityPage.getContent();
        List<twoComm> commAndUnsort= CovertCommToList.covertwithTwolist(sortComm,unSortComm);

        map.put("commAndUnsort",commAndUnsort);
        map.put("districtEntities",districtEntities);
        map.put("currentDistrictId","0");
        map.put("cityEntities",cityEntities);
        map.put("currentCityId",cityId);
        map.put("currentPage",page);//当前页数
        map.put("totalPage",communityEntityPage.getTotalPages());

        return new ModelAndView("community/indexofcity");
    }

    @GetMapping("/indexofdis")
    public ModelAndView getListCommunityEntityofdis(@RequestParam(value = "districtId",defaultValue = "1") String districtId,
                                               @RequestParam(value = "page",defaultValue = "1") Integer page,
                                               @RequestParam(value = "size",defaultValue = "10") Integer size,
                                               Map<String,Object> map){
        PageRequest pageRequest=new PageRequest(page-1,size);

        String cityId=districtService.getCityIdBydistrictId(districtId);
        //下面包括了该区号下的房产信息和该区号所属城市下的cheap房产信息
        Page<CommunityEntity> communityEntityPage=communityService.findByCommunityDistrictid(pageRequest,districtId);
        byte ischeap=1;
        List<CommunityEntity> unSortComm=communityService.findByCommunityCityidandIscheap(cityId,ischeap);
        List<twoComm> commAndUnsort=CovertCommToList.covertwithTwolist(communityEntityPage.getContent(),unSortComm);

        //区名列表
        List<DistrictEntity> districtEntities=districtService.getByDistrictCityid(cityId);
        List<CityEntity> cityEntities=cityService.findAll();

        map.put("commAndUnsort",commAndUnsort);
        map.put("districtEntities",districtEntities);
        map.put("currentDistrictId",districtId);
        map.put("cityEntities",cityEntities);
        map.put("currentCityId",cityId);
        map.put("currentPage",page);//当前页数
        map.put("totalPage",communityEntityPage.getTotalPages());

        return new ModelAndView("community/indexofcity");
    }

}
