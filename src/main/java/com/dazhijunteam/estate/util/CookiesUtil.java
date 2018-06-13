package com.dazhijunteam.estate.util;

import com.dazhijunteam.estate.constant.SessionConstant;
import org.springframework.data.redis.core.StringRedisTemplate;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

public class CookiesUtil {
    public static void setCookie(HttpServletResponse response,
                                 String name,
                                 String value,
                                 int maxAge){
        Cookie cookie=new Cookie(name,value);
        cookie.setPath("/");
        cookie.setMaxAge(maxAge);
        response.addCookie(cookie);
    }

    public static Cookie getCookie(HttpServletRequest request,String name){
        Map<String,Cookie> cookieMap=getCookieMap(request);
        if (cookieMap.containsKey(name)){
            return cookieMap.get(name);
        }else {
            return null;
        }
    }

    public static Map<String,Cookie> getCookieMap(HttpServletRequest request){
        Map<String,Cookie> cookieMap=new HashMap<>();
        Cookie[] cookies=request.getCookies();
        if (cookies!=null){
            for (Cookie cookie:cookies){
                cookieMap.put(cookie.getName(),cookie);
            }
        }
        return cookieMap;
    }

    public static String getUserNameByRedisAndCookie(HttpServletRequest request,
                                                     StringRedisTemplate redisTemplate){
        //得到浏览器的cookie，其中保存了存在redis中的标识符
        Cookie cookie=getCookie(request, SessionConstant.COOKIETOKEN);
        if (cookie==null){
            return null;
        }
        String redisKey=String.format(SessionConstant.REDIS_TOKEN_PREFIX,cookie.getValue());
        String userName=redisTemplate.opsForValue().get(redisKey);
        return userName;
    }
}
