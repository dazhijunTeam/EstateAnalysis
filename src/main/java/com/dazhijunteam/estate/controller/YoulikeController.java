package com.dazhijunteam.estate.controller;

import com.dazhijunteam.estate.constant.SessionConstant;
import com.dazhijunteam.estate.dataobject.CityEntity;
import com.dazhijunteam.estate.dataobject.CommunityEntity;
import com.dazhijunteam.estate.dataobject.User;
import com.dazhijunteam.estate.dataobject.twoComm;
import com.dazhijunteam.estate.repository.mapper.MapperService;
import com.dazhijunteam.estate.service.CityService;
import com.dazhijunteam.estate.service.CommunityService;
import com.dazhijunteam.estate.service.UserService;
import com.dazhijunteam.estate.util.CookiesUtil;
import com.dazhijunteam.estate.util.CovertCommToList;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/youlike")
public class YoulikeController {

    @Autowired
    private MapperService mapperService;

    @Autowired
    private CityService cityService;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private UserService userService;

    @Autowired
    private CommunityService communityService;

    @GetMapping("index")
    public ModelAndView index(Map<String,Object> map,
                              HttpServletRequest request,
                              @RequestParam(value = "page",defaultValue = "1") Integer page,
                              @RequestParam(value = "size",defaultValue = "10") Integer size){
        String UserName=CookiesUtil.getUserNameByRedisAndCookie(request, redisTemplate);
        User user=userService.getOne(UserName);
        System.out.println("该用户的所在城市为:"+user.getCity());
        System.out.println("该用户所期待的房价平均价格为:"+user.getHprice());

        int lowPrice=userService.getMayLowPrice(user);
        int highPrice=userService.getMayHighPrice(user);
        int totalPrice=highPrice*85;//伪装成85平米
        CityEntity cityEntity=cityService.findByCityName(user.getCity());
        String cityId=cityEntity.getCityId();

        //进行分页查询
        PageInfo<CommunityEntity> communityEntityPageInfo=mapperService.findByYouLike(cityId,lowPrice,highPrice,totalPrice,page,size);

        //将查询到的猜你喜欢的房产数据和优惠楼盘的数据结合在一起
        byte ischeap=1;
        List<CommunityEntity> unSortComm=communityService.findByCommunityCityidandIscheap(cityId,ischeap);
        List<CommunityEntity> sortComm=communityEntityPageInfo.getList();
        List<twoComm> commAndUnsort= CovertCommToList.covertwithTwolist(sortComm,unSortComm);

        map.put("communityEntityPageInfo",communityEntityPageInfo);
        map.put("commAndUnsort",commAndUnsort);
        map.put("currentPage",page);//当前页数
        map.put("totalPage",communityEntityPageInfo.getPages());
        map.put("userName", user.getUsername());
        return new ModelAndView("youlike/index",map);
    }

}
