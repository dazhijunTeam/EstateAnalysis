package com.dazhijunteam.estate.enums;

import lombok.Data;
import lombok.Getter;

@Getter
public enum AjkNewsTemplate {

    //https://%s.news.anjuke.com/toutiao/ajax/toutiaoajax/?page=%p&type=%t
    HOTNEWSTEMPLATEURL(0,"https://%s.news.anjuke.com/toutiao/ajax/toutiaoajax/?page=%p&type=3"),
    COMMUNITYURL(1,"https://%s.fang.anjuke.com/loupan/%d"),

    COMMUNITYURL2(2,"https://%s.fang.anjuke.com/loupan/%d/p%n/"),
    //%s表示城市简写,%d表示区号简写,%n表示页数
    COMMUNITYHOTURL(3,"https://%s.fang.anjuke.com/loupan/all/y1/");


    private Integer code;
    private String message;

    AjkNewsTemplate(int code,String message ){
        this.code=code;
        this.message=message;
    }
}
