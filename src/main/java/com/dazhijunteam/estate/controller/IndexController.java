package com.dazhijunteam.estate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/index")
public class IndexController {
    @GetMapping("/index")
    public ModelAndView index(){
        return new ModelAndView("redirect:/community/indexofcity");
    }
}
