package com.dazhijunteam.estate.crawler;

import com.dazhijunteam.estate.VO.HotNewsVo;
import com.dazhijunteam.estate.crawlerbean.NewsCrawlerBean;
import com.dazhijunteam.estate.dataobject.NewsEntity;
import com.dazhijunteam.estate.enums.AjkNewsTemplate;
import com.dazhijunteam.estate.enums.CityEnum;
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
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.lang.reflect.Type;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/estate")
public class EstateNewsCrawler {
    private static int maxsize=1000;
    private static HashMap<String,String> citys=new HashMap<>();

    @Autowired
    private NewsService service;

    @RequestMapping("/craw")
    public void crawlerHotNews(@RequestParam(name = "code") String code) {
        for(CityEnum cityEnum:CityEnum.values()){
            citys.put(cityEnum.code,cityEnum.cityFirst);
        }
        String hoturl = AjkNewsTemplate.HOTNEWSTEMPLATEURL.getMessage();
        maxsize=testMaxsize(hoturl);
        Document doc=null;
        for (int i=2;i<maxsize;i++){
            hoturl=hoturl.replace("%s",citys.get(code));
            hoturl=hoturl.replace("%p", i+"");
            try {
                doc = Jsoup.connect(hoturl).get();
            } catch (IOException e) {
                e.printStackTrace();
            }
            String json = doc.text();
            Gson gson = new Gson();
            Type type = new TypeToken<HotNewsVo<List<NewsCrawlerBean>>>(){}.getType();
            HotNewsVo<List<NewsCrawlerBean>> hotNewsVo = gson.fromJson(json, type);
            saveAll(hotNewsVo.getList(),code);
        }


    }

    public void saveAll(List<NewsCrawlerBean> newsCrawlerBeans,String cityId){
        Document content = null;
        for (int i = 0; i < newsCrawlerBeans.size(); i++) {
            NewsEntity newsEntity =new NewsEntity();
            NewsCrawlerBean newsCrawlerBean=newsCrawlerBeans.get(i);
            BeanUtils.copyProperties(newsCrawlerBean, newsEntity);
            newsEntity.setNewsId(KeyUtil.genUniqueKey());
            newsEntity.setNewsCityid(cityId);
            newsEntity.setNewsTypeid("3");
            newsEntity.setNewsData(Date.valueOf(newsCrawlerBean.getNewsData()));
            try {
                content = Jsoup.connect(newsCrawlerBean.getNews_url()).get();
            } catch (IOException e) {
                e.printStackTrace();
            }
            String newscontent = content.select("div.news-mod").html();
            newsEntity.setNewsContent(newscontent);
            service.save(newsEntity);
        }
    }

    public static int testMaxsize(String url){
        url=url.replace("%s","nc");
        url=url.replace("%p", maxsize+"");
        Document doc=null;
        try {
            doc = Jsoup.connect(url).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String json = doc.text();
        Gson gson = new Gson();
        Type type = new TypeToken<HotNewsVo<List<NewsCrawlerBean>>>(){}.getType();
        HotNewsVo<List<NewsCrawlerBean>> hotNewsVo = gson.fromJson(json, type);
        return hotNewsVo.getTotal()/20;
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
