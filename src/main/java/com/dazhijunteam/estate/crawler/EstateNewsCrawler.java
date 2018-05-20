package com.dazhijunteam.estate.crawler;

import com.dazhijunteam.estate.VO.HotNewsVo;
import com.dazhijunteam.estate.crawlerbean.NewsCrawlerBean;
import com.dazhijunteam.estate.dataobject.NewsEntity;
import com.dazhijunteam.estate.enums.AjkNewsTemplate;
import com.dazhijunteam.estate.enums.CityEnum;
import com.dazhijunteam.estate.service.NewsService;
import com.dazhijunteam.estate.util.KeyUtil;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class EstateNewsCrawler {
    private static int maxsize=1000;
    private static HashMap<String,String> citys=new HashMap<>();
    private static int flag=0;
    @Autowired
    private NewsService service;

    @RequestMapping("/craw")
    public void crawlerHotNews() {
        for(CityEnum cityEnum:CityEnum.values()){
            citys.put(cityEnum.code,cityEnum.cityFirst);
        }
        String hoturl = null;
        for(CityEnum cityEnum:CityEnum.values()){
            if (cityEnum.code.equals("1")||cityEnum.code.equals("2")||cityEnum.code.equals("3")){
                continue;
            }
            hoturl = AjkNewsTemplate.HOTNEWSTEMPLATEURL.getMessage();
            maxsize=testMaxsize(hoturl,cityEnum.code);
            Document doc=null;
            for (int i=1;i<maxsize;i++){
                hoturl = AjkNewsTemplate.HOTNEWSTEMPLATEURL.getMessage();
                hoturl=hoturl.replace("%s",citys.get(cityEnum.code));
                hoturl=hoturl.replace("%p", i+"");
                System.out.println(hoturl);
                try {
                    doc = Jsoup.connect(hoturl).get();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                String json = doc.text();
                Gson gson = new Gson();
                Type type = new TypeToken<HotNewsVo<List<NewsCrawlerBean>>>(){}.getType();
                HotNewsVo<List<NewsCrawlerBean>> hotNewsVo;
                try {
                    hotNewsVo = gson.fromJson(json, type);
                }catch (JsonSyntaxException e){
                    System.out.println("失败一次");
                    continue;
                }
                saveAll(hotNewsVo.getList(),cityEnum.code);
            }
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
            Date date=null;
            try {
                date=Date.valueOf(newsCrawlerBean.getNewsData());
            }
            catch (IllegalArgumentException e){
                date=Date.valueOf("2020-1-1");
            }
            newsEntity.setNewsData(date);
            try {
                content = Jsoup.connect(newsCrawlerBean.getNews_url()).get();
            } catch (IOException e) {
                e.printStackTrace();
            }
            String newscontent = content.select("div.news-mod").html();
            newsEntity.setNewsContent(newscontent);
            if ((flag++)%1000==0){
                System.out.println("*************flag="+flag+"*************");
            }
            service.save(newsEntity);
        }
    }

    public static int testMaxsize(String url,String code){
        url=url.replace("%s",citys.get(code));
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
        System.out.println("当城市code为"+code+"时，一共有"+hotNewsVo.getTotal()+"条数据，分成"+hotNewsVo.getTotal()/20+"页,共"+((hotNewsVo.getTotal()/20)*20-20)+"条数据");
        log.error("当城市code为"+code+"时，一共有"+hotNewsVo.getTotal()+"条数据，分成"+hotNewsVo.getTotal()/20+"页,共"+((hotNewsVo.getTotal()/20)*20-20)+"条数据");
        return hotNewsVo.getTotal()/20;
    }
}
