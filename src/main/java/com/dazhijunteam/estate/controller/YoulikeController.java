package com.dazhijunteam.estate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
@RequestMapping("/youlike")
public class YoulikeController {
    @GetMapping("index")
    public ModelAndView index(Map<String,Object> map){
        map.put("msg","登录了");
        map.put("url","");
        return new ModelAndView("common/error",map);
    }

}
