package com.dazhijunteam.estate.controller;

import com.dazhijunteam.estate.bean.HouseCraw;
import com.dazhijunteam.estate.bean.HouseInfos;
import com.dazhijunteam.estate.bean.HouseTypeInfos;
import com.dazhijunteam.estate.bean.UserComment;
import com.dazhijunteam.estate.dataobject.CommunityEntity;
import com.dazhijunteam.estate.repository.CommunityRepository;
import com.dazhijunteam.estate.repository.HouseInfosRepository;
import com.dazhijunteam.estate.repository.HouseTypeInfosRepository;
import com.dazhijunteam.estate.repository.UserCommentRepository;
import com.dazhijunteam.estate.service.CommunityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/infos")
@Slf4j
public class HouseInfoUtilController {

    @Autowired
    private CommunityRepository communityRepository;

    @Autowired
    private CommunityService communityService;

    @Autowired
    private HouseInfosRepository houseInfosRepository;

    @Autowired
    private HouseTypeInfosRepository houseTypeInfosRepository;

    @Autowired
    private UserCommentRepository userCommentRepository;

    @GetMapping("/get")
    public void get(){
        List<String> houseIds=new ArrayList<>();
        List<String> itemsNameUrls=new ArrayList<>();
        Byte b=1;
        List<CommunityEntity> communityEntities=communityRepository.findByIsCheap(b);
        System.out.println(communityEntities.size());
        int max=communityEntities.size();
        for (int i=0;i<max;i++){
            houseIds.add(communityEntities.get(i).getCommunityId());
            itemsNameUrls.add(communityEntities.get(i).getCommunityInfourl());
        }
        HouseCraw houseCraw=new HouseCraw();
        try {
            houseCraw=HouseInfoUtil.getAllHouseInfos(houseIds,itemsNameUrls);
        } catch (Exception e) {
            e.printStackTrace();
        }
        for(int h=0;h<houseCraw.getHouseInfos().size();h++){
            HouseInfos houseInfos=houseCraw.getHouseInfos().get(h);
            houseInfosRepository.save(houseInfos);
        }

        for(int T=0;T<houseCraw.getHouseTypeInfos().size();T++){
            HouseTypeInfos houseTypeInfos=houseCraw.getHouseTypeInfos().get(T);
            houseTypeInfosRepository.save(houseTypeInfos);
        }
        for(int u=0;u<houseCraw.getUserComments().size();u++){
            UserComment userComment=houseCraw.getUserComments().get(u);
            userCommentRepository.save(userComment);
        }
        log.error("全部爬取完");

    }
}
