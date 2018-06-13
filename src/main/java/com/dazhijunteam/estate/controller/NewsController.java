package com.dazhijunteam.estate.controller;

import com.dazhijunteam.estate.constant.SessionConstant;
import com.dazhijunteam.estate.dataobject.CityEntity;
import com.dazhijunteam.estate.dataobject.NewsEntity;
import com.dazhijunteam.estate.service.CityService;
import com.dazhijunteam.estate.service.NewsService;
import com.dazhijunteam.estate.util.CookiesUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/news")
public class NewsController {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private NewsService newsService;

    @Autowired
    private CityService cityService;


    @GetMapping("/index")
    public ModelAndView index(@RequestParam(name = "page",defaultValue = "1") Integer page,
                              @RequestParam(value = "size",defaultValue = "9") Integer size,
                              @RequestParam(value = "cityId",defaultValue = "1") String cityId,
                              HttpServletRequest request,
                              Map<String,Object> map){
        PageRequest pageRequest=new PageRequest(page-1,size);
        Page<NewsEntity> newsEntities=newsService.findListByCityId(pageRequest,cityId);
        List<CityEntity> cityEntities=cityService.findAll();

        //通过cookie获取username
        String userName=CookiesUtil.getUserNameByRedisAndCookie(request,redisTemplate);

        map.put("cityId",cityId);
        map.put("currentPage",page);
        map.put("newsEntities",newsEntities);
        map.put("cityEntities",cityEntities);
        map.put("userName", userName);
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
