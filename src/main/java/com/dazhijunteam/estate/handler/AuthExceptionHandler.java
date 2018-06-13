package com.dazhijunteam.estate.handler;

import com.dazhijunteam.estate.exception.UnLoginException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
@Slf4j
public class AuthExceptionHandler {

    @ExceptionHandler(value = UnLoginException.class)
    public ModelAndView handlerUnLoginException(){
        Map<String ,Object> map =new HashMap<>();
        map.put("msg","未登录，无法使用此功能");
        map.put("url","/EstateAnalysis/community/indexofcity");
        return new ModelAndView("common/error",map);
    }
}
