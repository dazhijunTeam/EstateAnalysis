package com.dazhijunteam.estate.crawler;

import com.dazhijunteam.estate.dataobject.DistrictEntity;
import com.dazhijunteam.estate.repository.DistrictRepository;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.xml.bind.PrintConversionEvent;
import java.io.IOException;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Slf4j
public class CommunityCrawlerTest {

    @Autowired
    DistrictRepository districtRepository;


    String s="nanchangxian honggutan gaoxinkaifaqu xihu xinjianqu qingshanhu wanli jingkaiqu qingyunpu donghu jinxianxian sanghaijingjikaifaqu nanchangzhoubian changbei";
    String cs="南昌县 红谷滩 高新开发区 西湖 新建区 青山湖 湾里 经开区 青云谱 东湖 进贤县 桑海经济开发区 南昌周边 昌北";
    @Test
    public void saved(){
        String[] ss=s.split(" ");
        String[] css=cs.split(" ");
        System.out.println(ss.length+"  "+css.length);
        for (int i=110;i<ss.length+110;i++){
            DistrictEntity districtEntiy=new DistrictEntity();
            districtEntiy.setDistrictCityid("8");
            districtEntiy.setDistrictId(i+"");
            districtEntiy.setDistrictName(css[i-110]);
            districtEntiy.setDistrictEname(ss[i-110]);
            System.out.println(districtEntiy.getDistrictEname());
            districtRepository.save(districtEntiy);
        }
    }

    @Test
    public void crawSpan() throws IOException {
        String url="https://bj.fang.anjuke.com/loupan/daxing/";
        Document document= Jsoup.connect(url).get();
        Elements eles=document.select("div.tag-panel");
        System.out.println(eles.get(3).text());
        System.out.println(document.select("div.list-page span em").text());
        System.out.println(document.select("div.list-page span em").text());
        for (Element e:eles) {
            String str=e.select("p.price").text();
            if (str.equals("")){
                str=e.select("p.price-txt").text();
            }
            //System.out.println(str);

        }


    }

    @Test
    public void crawone(){
        new CommunityCrawler().craw("https://bj.fang.anjuke.com/loupan/fengtai/p1","12");
    }

    @Test
    public void substring(){
        String price="周边均价19832元/m起";
        int start=price.indexOf("价");
        int end=price.indexOf("元");
        int p=Integer.parseInt(price.substring(start+1,end));
        System.out.println(p);
    }
}