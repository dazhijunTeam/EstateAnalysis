package com.dazhijunteam.estate.controller;

import com.dazhijunteam.estate.dataobject.CityEntity;
import com.dazhijunteam.estate.dataobject.NewsEntity;
import com.dazhijunteam.estate.service.CityService;
import com.dazhijunteam.estate.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.data.domain.AbstractPageRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
                              @RequestParam(value = "size",defaultValue = "10") Integer size,
                              Map<String,Object> map){
        PageRequest pageRequest=PageRequest.of(page-1,size);
        Page<NewsEntity> newsEntities=newsService.findList(pageRequest);
        List<CityEntity> cityEntities=cityService.findAll();
        map.put("news",newsEntities.getContent());
        map.put("cityEntities",cityEntities);
        return new ModelAndView("news/index",map);
    }

}
