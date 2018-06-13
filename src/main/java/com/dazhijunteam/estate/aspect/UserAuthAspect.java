package com.dazhijunteam.estate.aspect;

import com.dazhijunteam.estate.exception.UnLoginException;
import com.dazhijunteam.estate.util.CookiesUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.UnlockSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

@Aspect
@Slf4j
@Component
public class UserAuthAspect {

    @Autowired
    private StringRedisTemplate template;

    @Before("execution(public * com.dazhijunteam.estate.controller.YoulikeController.*(..))")
    public void before() {
        ServletRequestAttributes attributes= (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request=attributes.getRequest();
        String userName=CookiesUtil.getUserNameByRedisAndCookie(request,template);
        if (userName==null){
            throw new UnLoginException();
        }
    }
}
