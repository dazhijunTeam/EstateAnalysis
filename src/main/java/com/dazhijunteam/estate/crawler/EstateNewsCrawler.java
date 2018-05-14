package com.dazhijunteam.estate.crawler;

import com.dazhijunteam.estate.VO.HotNewsVo;
import com.dazhijunteam.estate.crawlerbean.NewsCrawlerBean;
import com.dazhijunteam.estate.dataobject.NewsEntity;
import com.dazhijunteam.estate.enums.AjkNewsTemplate;
import com.dazhijunteam.estate.service.NewsService;
import com.dazhijunteam.estate.util.KeyUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.hibernate.query.criteria.internal.expression.function.AggregationFunction;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.lang.reflect.Type;
import java.sql.Date;
import java.util.List;

@Component
public class EstateNewsCrawler {
    private static String maxsize="1000";

    @Autowired
    static NewsService service;

    public static void crawlerHotNews() {
        String hoturl = AjkNewsTemplate.HOTNEWSTEMPLATEURL.getMessage();
        hoturl.replace("%s","nc");
        hoturl.replace("%p", maxsize);
        Document doc=null;
        try {
            doc = Jsoup.connect(hoturl).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String json = doc.text();
        Gson gson = new Gson();
        Type h = new TypeToken<HotNewsVo<List<NewsCrawlerBean>>>() {
        }.getType();
        HotNewsVo<List<NewsCrawlerBean>> vv = gson.fromJson(json, h);
        for (int i = 0; i < vv.getList().size(); i++) {
            NewsEntity ne = new NewsEntity();
            BeanUtils.copyProperties(vv.getList().get(i), ne);
            System.out.println(ne.getNewsImage());
            ne.setNewsId(KeyUtil.genUniqueKey());
            ne.setNewsCityid("1");
            ne.setNewsTypeid("1");
            ne.setNewsData(Date.valueOf("2015-9-8"));
            Document cont = Jsoup.connect(vv.getList().get(i).getNews_url()).get();
            String el = cont.select("div.news-mod").html();
            ne.setNewsContent(el);
            System.out.println(ne);
            service.save(ne);


        }
    }
    public static void main(String[] args){
        int a=0;
        try {
            a=10;
        }catch (Exception e){

        }
        System.out.println(a);
    }
}
