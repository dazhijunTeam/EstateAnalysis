package com.dazhijunteam.estate.controller;
import com.dazhijunteam.estate.constant.SessionConstant;
import com.dazhijunteam.estate.exception.RegisterException;
import com.dazhijunteam.estate.formbean.registerForm;
import com.dazhijunteam.estate.util.CookiesUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Controller
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @PostMapping("/register")
    public ModelAndView register(@Valid registerForm registerForm,
                                 BindingResult bindingResult,
                                 HttpServletResponse response){
        if (bindingResult.hasErrors()){
            log.error("【注册】 参数不正确,registerForm={}",registerForm);
            throw new RegisterException(bindingResult.getFieldError().getDefaultMessage());
        }
        //生成的Token
        String token= UUID.randomUUID().toString();
        Integer expir= SessionConstant.EXPIRE;
        String tokenName=String.format(SessionConstant.REDIS_TOKEN_PREFIX,token);
        redisTemplate.opsForValue().set(tokenName,registerForm.getUsername(),expir*60*60, TimeUnit.MILLISECONDS);

        //设置token到浏览器
        System.out.println(registerForm.getUsername());
        //给予网页session
        CookiesUtil.setCookie(response,SessionConstant.COOKIETOKEN,token,expir*60);


        return new ModelAndView("redirect:/community/indexofcity");
    }
}
