package com.dazhijunteam.estate.enums;

import lombok.Data;
import lombok.Getter;

@Getter
public enum AjkNewsTemplate {

    //https://%s.news.anjuke.com/toutiao/ajax/toutiaoajax/?page=%p&type=%t
    HOTNEWSTEMPLATEURL(0,"https://%s.news.anjuke.com/toutiao/ajax/toutiaoajax/?page=%p&type=3"),
    SPECIALNEWSTEMPLATEURL(1,"https://%s.news.anjuke.com/topic/?from=leading_navi_topic");

    private Integer code;
    private String message;

    AjkNewsTemplate(int code,String message){
        this.code=code;
        this.message=message;
    }
}
