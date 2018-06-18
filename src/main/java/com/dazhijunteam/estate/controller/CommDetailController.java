package com.dazhijunteam.estate.controller;

import com.dazhijunteam.estate.bean.HouseInfos;
import com.dazhijunteam.estate.bean.HouseTypeInfos;
import com.dazhijunteam.estate.bean.UserComment;
import com.dazhijunteam.estate.dataobject.CommunityEntity;
import com.dazhijunteam.estate.exception.CommNullPointerException;
import com.dazhijunteam.estate.repository.HouseInfosRepository;
import com.dazhijunteam.estate.repository.HouseTypeInfosRepository;
import com.dazhijunteam.estate.repository.UserCommentRepository;
import com.dazhijunteam.estate.service.CommunityService;
import com.dazhijunteam.estate.service.HouseInfoService;
import com.dazhijunteam.estate.service.HouseTypeInfosService;
import com.dazhijunteam.estate.service.UserCommentService;
import com.dazhijunteam.estate.util.CookiesUtil;
import com.dazhijunteam.estate.util.HouseTypeUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@Slf4j
@RequestMapping("/commdetail")
public class CommDetailController {

    @Autowired
    private StringRedisTemplate redisTemplate;

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
                              Map<String ,Object> map,
                              HttpServletRequest request){
        //通过cookie获取username
        String userName= CookiesUtil.getUserNameByRedisAndCookie(request,redisTemplate);

        HouseInfos houseInfos=houseInfoService.getByHouseId(communityid);
        CommunityEntity communityEntity=communityService.getOne(communityid);
        List<UserComment> userComments=userCommentService.getByHouseId(communityid);
        String[] urls=null;
        try {
            urls=houseInfos.getHouseImageUrl().split(",");
        }catch (NullPointerException e){
            throw new CommNullPointerException("该房产下无准确信息");
        }

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
        map.put("userName", userName);
        return new ModelAndView("commdetail/index",map);
    }


    @GetMapping("/housetype")
    public ModelAndView housetype(@RequestParam(name = "communityid") String communityid,
                                  @RequestParam(name = "type",defaultValue = "全部户型") String type,
                                  HttpServletRequest request,
                                  Map<String ,Object> map){
        //通过cookie获取username
        String userName= CookiesUtil.getUserNameByRedisAndCookie(request,redisTemplate);

        List<HouseTypeInfos> houseTypeInfos=houseTypeInfosService.findByHouseId(communityid);
        Map<String,List<HouseTypeInfos>> houseTypeMap= HouseTypeUtil.HouseTypeListToMap(houseTypeInfos);

        HouseInfos houseInfos=houseInfoService.getByHouseId(communityid);
        map.put("allTypeSum",houseTypeInfos.size());
        map.put("houseTypeMap",houseTypeMap);
        map.put("houseInfos",houseInfos);
        if (type.equals("全部户型")) {
            map.put("houseTypeInfos", houseTypeInfos);
        }else {
            map.put("houseTypeInfos", houseTypeMap.get(type));
        }
        map.put("isinDetail",false);
        map.put("userName", userName);
        return new ModelAndView("commdetail/housetype",map);
    }

}
