package com.dazhijunteam.estate.controller;

import com.dazhijunteam.estate.bean.HouseInfos;
import com.dazhijunteam.estate.bean.HouseTypeInfos;
import com.dazhijunteam.estate.bean.UserComment;
import com.dazhijunteam.estate.dataobject.CommunityEntity;
import com.dazhijunteam.estate.repository.HouseInfosRepository;
import com.dazhijunteam.estate.repository.HouseTypeInfosRepository;
import com.dazhijunteam.estate.repository.UserCommentRepository;
import com.dazhijunteam.estate.service.CommunityService;
import com.dazhijunteam.estate.service.HouseInfoService;
import com.dazhijunteam.estate.service.HouseTypeInfosService;
import com.dazhijunteam.estate.service.UserCommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@Slf4j
@RequestMapping("/commdetail")
public class CommDetailController {

    @Autowired
    private CommunityService communityService;

    @Autowired
    private HouseInfoService houseInfoService;

    @Autowired
    private HouseTypeInfosService houseTypeInfosService;

    @Autowired
    private UserCommentService userCommentService;

    @GetMapping("/index")
    public ModelAndView index(@RequestParam(name = "communityid") String communityid,
                              Map<String ,Object> map){
        HouseInfos houseInfos=houseInfoService.getByHouseId(communityid);
        CommunityEntity communityEntity=communityService.getOne(communityid);
        List<HouseTypeInfos> houseTypeInfos=houseTypeInfosService.findByHouseId(communityid);
        List<UserComment> userComments=userCommentService.getByHouseId(communityid);

        String[] urls=houseInfos.getHouseImageUrl().split(",");
        Map<String,String> infoAndimg=new HashMap<>();
        for (String url:urls){
            String[] infoanimgArray=url.split("-");
            infoanimgArray[1]=infoanimgArray[1].replace("86x63","457x385");
            infoAndimg.put(infoanimgArray[0],infoanimgArray[1]);
        }
        map.put("houseInfos",houseInfos);
        map.put("communityEntity",communityEntity);
        map.put("infoAndimg",infoAndimg);
        map.put("userComments",userComments);
        map.put("isinDetail",true);
        return new ModelAndView("commdetail/index",map);
    }


    @GetMapping("/housetype")
    public ModelAndView housetype(@RequestParam(name = "communityid") String communityid,
                              Map<String ,Object> map){
        HouseInfos houseInfos=houseInfoService.getByHouseId(communityid);
        CommunityEntity communityEntity=communityService.getOne(communityid);
        List<HouseTypeInfos> houseTypeInfos=houseTypeInfosService.findByHouseId(communityid);
        List<UserComment> userComments=userCommentService.getByHouseId(communityid);

        String[] urls=houseInfos.getHouseImageUrl().split(",");
        Map<String,String> infoAndimg=new HashMap<>();
        for (String url:urls){
            String[] infoanimgArray=url.split("-");
            infoanimgArray[1]=infoanimgArray[1].replace("86x63","457x385");
            infoAndimg.put(infoanimgArray[0],infoanimgArray[1]);
        }
        map.put("houseInfos",houseInfos);
        map.put("communityEntity",communityEntity);
        map.put("infoAndimg",infoAndimg);
        map.put("userComments",userComments);
        map.put("isinDetail",false);
        return new ModelAndView("commdetail/index",map);
    }

}
