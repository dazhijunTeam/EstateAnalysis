package com.dazhijunteam.estate.crawler;

import com.dazhijunteam.estate.dataobject.CityEntity;
import com.dazhijunteam.estate.dataobject.CommunityEntity;
import com.dazhijunteam.estate.dataobject.DistrictEntity;
import com.dazhijunteam.estate.enums.AjkNewsTemplate;
import com.dazhijunteam.estate.repository.CommunityRepository;
import com.dazhijunteam.estate.service.CityService;
import com.dazhijunteam.estate.service.DistrictService;
import com.dazhijunteam.estate.util.KeyUtil;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/community")
@Slf4j
public class CommunityCrawler {

    static int num=1;

    @Autowired
    private CommunityRepository repository;

    @Autowired
    private CityService cityService;

    @Autowired
    private DistrictService districtService;


    //获取房子信息的url模板
    private final static String communityUrl= AjkNewsTemplate.COMMUNITYURL.getMessage();

    @GetMapping("/craw")
    public void Allcraw(){
        List<CityEntity> cityEntities=cityService.findAll();
        for (CityEntity cityEntity:cityEntities){
            crawThread crawThread = new crawThread(cityEntity);
            new Thread(crawThread).start();
        }

    }

    @GetMapping("/crawhot")
    public void Allcrawhot(){
        List<CityEntity> cityEntities=cityService.findAll();
        for (CityEntity cityEntity:cityEntities){
            crawhotThread crawThread = new crawhotThread(cityEntity);
            new Thread(crawThread).start();
        }

    }

    private class crawhotThread implements Runnable{
        private CityEntity cityEntity;

        public crawhotThread(CityEntity cityEntity){
            this.cityEntity=cityEntity;
        }

        @Override
        public void run() {


                for (int i=1;i<=1;i++){
                    String thisUrl=AjkNewsTemplate.COMMUNITYHOTURL.getMessage();

                    thisUrl=thisUrl.replace("%s",cityEntity.getCityFirst());

                    System.out.println("thisUrl="+thisUrl+"cityId="+cityEntity.getCityId()+"disId="+districtService.getdistrictIdByCityId(cityEntity.getCityId()).get(1));
                    //System.out.println("开始爬"+thisUrl+"里面的内容");
                    craw(thisUrl,districtService.getdistrictIdByCityId(cityEntity.getCityId()).get(1));

                }

            }

    }

    private class crawThread implements Runnable {
        private CityEntity cityEntity;

        public crawThread(CityEntity cityEntity) {
            this.cityEntity = cityEntity;
        }

        @Override
        public void run() {
            List<DistrictEntity> districtEntities = districtService.getByDistrictCityid(cityEntity.getCityId());
            for (DistrictEntity districtEntity : districtEntities) {
                System.out.println("在" + cityEntity.getCityName() + "这个城市爬取" + districtEntity.getDistrictEname() + "的房产信息");
                String testUrl = communityUrl;
                testUrl = testUrl.replace("%s", cityEntity.getCityFirst());
                testUrl = testUrl.replace("%d", districtEntity.getDistrictEname());
                //testUrl=testUrl.replace("%n","1");

                Document document = null;
                try {
                    document = Jsoup.connect(testUrl).timeout(30000).get();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (document == null) {
                    try {
                        document = Jsoup.connect(testUrl).timeout(30000).get();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                int TotalPage = 0;
                try {
                    String stotal = document.select("div.list-page span.total em").text().trim();
                    if (stotal.equals("")) {
                        TotalPage = Integer.parseInt(document.select("div.sort-condi span.result em").text().trim()) / 50;
                    } else {
                        TotalPage = Integer.parseInt(stotal) / 50;
                    }
                    if (TotalPage == 0) {
                        TotalPage++;
                    }

                } catch (NumberFormatException e) {
                    System.out.println("还会进来？");
                }

                System.out.println("testUrl=" + testUrl);
                //System.out.println("我们爬"+TotalPage+"页");

                for (int i = 1; i <= TotalPage; i++) {
                    String thisUrl = communityUrl;
                    if (TotalPage > 1) {
                        thisUrl = AjkNewsTemplate.COMMUNITYURL2.getMessage();
                    }

                    thisUrl = thisUrl.replace("%s", cityEntity.getCityFirst());
                    thisUrl = thisUrl.replace("%d", districtEntity.getDistrictEname());
                    if (thisUrl.contains("%n")) {
                        thisUrl = thisUrl.replace("%n", i + "");
                    }


                    System.out.println("thisUrl=" + thisUrl);
                    //System.out.println("开始爬"+thisUrl+"里面的内容");
                    craw(thisUrl, districtEntity.getDistrictId());
                }

            }
        }
    }

    //具体的爬取一页的信息，并将信息保存到数据库中
    public void craw(String url,String districtid){
        num++;
        Document document=null;
        try {
            document= Jsoup.connect(url).timeout(30000).get();
        } catch (IOException e) {
            e.printStackTrace();
        }if (document==null)
            try {
                document= Jsoup.connect(url).timeout(30000).get();
            } catch (IOException e) {
                e.printStackTrace();
            }
        Elements eles=document.select("div.key-list .item-mod");
        //每个element都是有一个房产的基本描述
        for (Element e:eles){
            CommunityEntity communityEntity=new CommunityEntity();
            String community_id= KeyUtil.genUniqueKey();
            String communityName=e.select("span.items-name").text();
            String communityAddress=e.select("a.address span.list-map").text();
            String communityDistrictid=districtid;
            String communityTypeandsize=e.select("a.huxing").text();
            String communityPhone=e.select("a.favor-pos p.tel").text();
            String communityHousetype=e.select("a.tags-wrap div.tag-panel").text();
            String communityImage=e.select("a.pic img").attr("src");
            String communityInfourl=e.select("a.favor-pos").attr("href");
            communityEntity.setCommunityId(community_id);
            communityEntity.setCommunityName(communityName);
            communityEntity.setCommunityAddress(communityAddress);
            communityEntity.setCommunityDistrictid(communityDistrictid);
            communityEntity.setCommunityTypeandsize(communityTypeandsize);
            communityEntity.setCommunityPhone(communityPhone);
            communityEntity.setCommunityHousetype(communityHousetype);
            communityEntity.setCommunityTypeandsize(communityTypeandsize);
            communityEntity.setCommunityImage(communityImage);
            communityEntity.setCommunityInfourl(communityInfourl);
            communityEntity=addPrice(communityEntity,e);
            repository.save(communityEntity);
        }
    }


    //数据库中 最低价，周边价格，自己准确的平均价，自己准确的总价
    public CommunityEntity addPrice(CommunityEntity communityEntity,Element element){
        String price=element.select("a.favor-pos p.price").text();
        //说明售价未定，只能通过周边房价来判断
        if (price.equals("")){
            if (element.select("a.favor-pos p.around-price").text().equals("")) {

            }else {
                price = element.select("a.favor-pos p.around-price").text();
                //此时也一种情况，不仅没有周边价格的信息，又没有自己的信息.
                communityEntity.setCommunityPriceinfo(price);
                //存入周边价格的信息
                int start = price.indexOf("价");
                int end = price.indexOf("元");
                int p = Integer.parseInt(price.substring(start + 1, end));
                communityEntity.setCommunityAvprice(p);
                //将此周边房价作为该房产的平均价格
            }
        }
        //此时可知房产价格，但是房产价格可能存在多种显示方式，如最低平均价，均价，房产总价
        else {
            if (price.contains("均价")){
                //此时是最准确的均价
                communityEntity.setCommunityPriceinfo(price);

                int start=price.indexOf("价");
                int end=price.indexOf("元");
                int p=Integer.parseInt(price.substring(start+1,end));

                //此时存入最准确的平均价格
                communityEntity.setCommunityAvprice(p);
            }else if (price.contains("总价")){
                communityEntity.setCommunityPriceinfo(price);
                int start=price.indexOf("价");
                int end=price.indexOf("万");
                int p=Integer.parseInt(price.substring(start+1,end))*10000;

                //此时存入总价
                communityEntity.setCommunityTotalprice(p);
            }else if (price.contains("最低")){
                communityEntity.setCommunityPriceinfo(price);
                int start=price.indexOf("低");
                int end=price.indexOf("元");
                int p=Integer.parseInt(price.substring(start+1,end));

                //此时存入总价
                communityEntity.setCommunityAvprice(p);
            }else {
                log.error("这是什么情况，出bug了");
            }

        }
        return communityEntity;
    }
}
