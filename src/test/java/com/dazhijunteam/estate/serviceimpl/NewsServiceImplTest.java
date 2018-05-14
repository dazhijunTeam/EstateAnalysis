package com.dazhijunteam.estate.serviceimpl;

import com.dazhijunteam.estate.VO.HotNewsVo;
import com.dazhijunteam.estate.crawlerbean.NewsCrawlerBean;
import com.dazhijunteam.estate.dataobject.NewsEntity;
import com.dazhijunteam.estate.enums.AjkNewsTemplate;
import com.dazhijunteam.estate.service.NewsService;
import com.dazhijunteam.estate.util.KeyUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.lang.reflect.Type;
import java.sql.Date;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Slf4j
public class NewsServiceImplTest {

    @Autowired
    private NewsService service;
    @Test
    public void save() {
        NewsEntity ne=new NewsEntity();
        ne.setNewsData(Date.valueOf("2015-9-10"));
        ne.setNewsId(KeyUtil.genUniqueKey());
        ne.setNewsTypeid("1");
        ne.setNewsContent("1");
        ne.setNewsCityid("1");
        service.save(ne);
    }

    @Test
    public void craw(){
        String hoturl= AjkNewsTemplate.HOTNEWSTEMPLATEURL.getMessage();
        try {
            Document doc = Jsoup.connect(hoturl).get();
            String json=doc.text();
            Gson gson=new Gson();
            Type h=new TypeToken<HotNewsVo<List<NewsCrawlerBean>>>(){}.getType();
            HotNewsVo<List<NewsCrawlerBean>> vv=gson.fromJson(json, h);
            for (int i=0;i<vv.getList().size();i++){
                NewsEntity ne=new NewsEntity();
                BeanUtils.copyProperties(vv.getList().get(i),ne);
                System.out.println(ne.getNewsImage());
                ne.setNewsId(KeyUtil.genUniqueKey());
                ne.setNewsCityid("1");
                ne.setNewsTypeid("1");
                ne.setNewsData(Date.valueOf("2015-9-8"));
                Document cont = Jsoup.connect(vv.getList().get(i).getNews_url()).get();
                String el=cont.select("div.news-mod").html();
                ne.setNewsContent(el);
                System.out.println(ne);
                service.save(ne);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}