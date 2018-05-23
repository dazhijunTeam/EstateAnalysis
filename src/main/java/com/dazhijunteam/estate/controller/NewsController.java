package com.dazhijunteam.estate.controller;

import com.dazhijunteam.estate.dataobject.CityEntity;
import com.dazhijunteam.estate.dataobject.NewsEntity;
import com.dazhijunteam.estate.service.CityService;
import com.dazhijunteam.estate.service.NewsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/news")
public class NewsController {
    @Autowired
    private NewsService newsService;

    @Autowired
    private CityService cityService;


    @GetMapping("/index")
    public ModelAndView index(@RequestParam(name = "page",defaultValue = "1") Integer page,
                              @RequestParam(value = "size",defaultValue = "9") Integer size,
                              @RequestParam(value = "cityId",defaultValue = "1") String cityId,
                              Map<String,Object> map){
        PageRequest pageRequest=new PageRequest(page-1,size);
        Page<NewsEntity> newsEntities=newsService.findListByCityId(pageRequest,cityId);
        List<CityEntity> cityEntities=cityService.findAll();
        map.put("cityId",cityId);
        map.put("currentPage",page);
        map.put("newsEntities",newsEntities);
        map.put("cityEntities",cityEntities);
        return new ModelAndView("news/index",map);
    }


    @GetMapping("/detail")
    public ModelAndView detail(@RequestParam(name = "newsId") String newsId,
                               Map<String,Object> map){
        NewsEntity newsEntity=newsService.findByNewsId(newsId);
        map.put("newsEntity",newsEntity);
        return new ModelAndView("news/detail",map);
    }
}
