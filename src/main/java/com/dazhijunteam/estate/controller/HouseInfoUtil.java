package com.dazhijunteam.estate.controller;



import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.dazhijunteam.estate.bean.HouseCraw;
import com.dazhijunteam.estate.bean.HouseInfos;
import com.dazhijunteam.estate.bean.HouseTypeInfos;
import com.dazhijunteam.estate.bean.UserComment;
import com.dazhijunteam.estate.repository.HouseInfosRepository;
import com.dazhijunteam.estate.repository.HouseTypeInfosRepository;
import com.dazhijunteam.estate.repository.UserCommentRepository;
import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.TextNode;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public class HouseInfoUtil {


    private static List<HouseTypeInfos> houseTypeInfos = new ArrayList();
    private static List<HouseInfos> houseInfos = new ArrayList();
    private static List<String> overUrls = new ArrayList();
    private static List<UserComment> userComments = new ArrayList();
    private static final int MAX_THREAD = 16;

    public HouseInfoUtil() {
    }

    public static HouseCraw getAllHouseInfos(List<String> houseIds, List<String> itemsNameUrls) throws Exception {
        HouseCraw houseCraw = new HouseCraw();
        HouseInfoUtil.CrawThread crawThread = new HouseInfoUtil().new CrawThread(houseIds, itemsNameUrls);

        for(int i = 0; i < 16; ++i) {
            Thread thread = new Thread(crawThread, "thread" + i);
            thread.start();
        }

        while(itemsNameUrls.size() > 0) {
            Thread.sleep(14000L);
        }

        houseCraw.setHouseInfos(houseInfos);
        houseCraw.setHouseTypeInfos(houseTypeInfos);
        houseCraw.setUserComments(userComments);
        return houseCraw;
    }

    public HouseInfos getHouseInfos(String houseId, String itemsNameUrl) throws Exception {
        Document doc = getDocument(itemsNameUrl);
        List<String> houseTypeUrls = new ArrayList();
        String userCommentUrl = ((Element)doc.select(".lp-nav .lp-navtabs").select("li").get(4)).select("a").attr("href");
        this.getUserComment(houseId, userCommentUrl);
        Elements mainEle = doc.select(".main-detail");
        List<Element> imageEles = mainEle.select(".snav .pnav");
        String houseTypeId = "";
        String houseImageUrl = "";

        Element imageEle;
        for(Iterator var11 = imageEles.iterator(); var11.hasNext(); houseImageUrl = houseImageUrl + imageEle.select("em").text() + "-" + imageEle.select("img").attr("src") + ",") {
            imageEle = (Element)var11.next();
        }

        houseImageUrl = houseImageUrl.substring(0, houseImageUrl.length() - 1);
        Elements detailsEle = mainEle.select(".basic-details");
        Elements parmsEle = detailsEle.select(".basic-parms-wrap");
        String price = "";
        price = parmsEle.select(".price p").text();
        List<TextNode> pNodes=parmsEle.select(".price p").get(0).textNodes();
        try {
            price=pNodes.get(0).text().trim()+parmsEle.select(".price p").select("em").text().trim();
            if(pNodes.size()>1){
                price+=pNodes.get(1).text().trim();
            }
        }catch (IndexOutOfBoundsException e){
            System.out.println(itemsNameUrl);
            e.printStackTrace();
        }


        List<Element> othersEles = parmsEle.select(".price .others");
        if(othersEles.size()!=0)
            for(Element ele:othersEles){
                price+=","+ele.text();
            }

        String aroundPrice = "";
        if (parmsEle.select(".around-price span").size() != 0) {
            aroundPrice = parmsEle.select(".around-price span").text();
        }

        String houseType = "";
        List<Element> itemEles = parmsEle.select(".house-item a");
        if (itemEles.size() != 0) {
            Iterator var18 = itemEles.iterator();

            while(var18.hasNext()) {
                Element itemEle = (Element)var18.next();
                houseType = houseType + itemEle.text() + ",";
                houseTypeUrls.add(itemEle.attr("href"));
            }

            houseTypeId = this.getHouseTypeInfos(houseId, houseTypeUrls).getHouseTypeId();
            houseTypeId = houseTypeId.substring(0, houseTypeId.length() - 1);
            houseType = houseType.substring(0, houseType.length() - 1);
        }

        String address = parmsEle.select(".lpAddr-text").text();
        String tel = "";
        if (detailsEle.select(".no-tel").size() == 0&&detailsEle.select("p.tel").size()>0) {
            Elements telEle = detailsEle.select("p.tel");
            List<Element> strEles = telEle.select("strong");
            Elements emEle = telEle.select("em");
            try {
                tel = ((Element)strEles.get(0)).text();
            }catch (IndexOutOfBoundsException e){
                System.out.println(itemsNameUrl);
                e.printStackTrace();
            }
            if (emEle.size() != 0) {
                tel = ((Element)strEles.get(0)).text() + emEle.text() + ((Element)strEles.get(1)).text();
            }
        }

        String openTime = "";
        List<TextNode> texts = ((Element)detailsEle.select("p.info-new").get(0)).textNodes();

        TextNode text;
        for(Iterator var22 = texts.iterator(); var22.hasNext(); openTime = openTime + text.text().trim()) {
            text = (TextNode)var22.next();
        }
        if(detailsEle.select("p.info-new").get(0).select("span").size()!=0){
            openTime+=detailsEle.select("p.info-new").get(0).select("span").text();
        }
        String completeTime = "";
        List<TextNode> comTexts = ((Element)detailsEle.select("p.info-new").get(1)).textNodes();

        TextNode comText;
        for(Iterator var24 = comTexts.iterator(); var24.hasNext(); completeTime = completeTime + comText.text().trim()) {
            comText = (TextNode)var24.next();
        }
        if(detailsEle.select("p.info-new").get(1).select("span").size()!=0){
            completeTime+=detailsEle.select("p.info-new").get(1).select("span").text();
        }

        String buildingType = "";
        String commentNum = "";
        if (detailsEle.select("ul.info-left span").size() != 0) {
            buildingType = ((Element)detailsEle.select("ul.info-left span").get(0)).text();
            commentNum = detailsEle.select("li.botli span").text();
        }

        String houseYears = "";
        if (detailsEle.select("ul.info-left span").size() > 1) {
            houseYears = ((Element)detailsEle.select("ul.info-left span").get(1)).text();
        }

        return new HouseInfos((Integer)null, houseId, houseImageUrl, price, aroundPrice, houseType, houseTypeId, address, tel, openTime, completeTime, buildingType, commentNum, houseYears);
    }

    public HouseTypeInfos getHouseTypeInfos(String houseId, List<String> houseTypeUrls) throws Exception {
        HouseTypeInfos houseTypeInfo = new HouseTypeInfos();
        String houseTypeId = "";
        if (houseTypeUrls.size() != 0) {
            int i = 1;
            Iterator var7 = houseTypeUrls.iterator();

            while(var7.hasNext()) {
                String houseTypeUrl = (String)var7.next();
                Document doc = getDocument(houseTypeUrl);
                Elements hxEle = doc.select(".hx-layout");
                String totalType = hxEle.select(".hx-snav .current").text();
                if (totalType.length() > 0) {
                    totalType = totalType.substring(0, totalType.length() - 3);
                }

                List<Element> liEles = hxEle.select(".hx-list li");
                Iterator var13 = liEles.iterator();

                while(var13.hasNext()) {
                    Element liEle = (Element)var13.next();
                    String temId="";
                    String reg = "\\d{5,6}";
                    Matcher m = Pattern.compile(reg).matcher(houseTypeUrl);
                    while(m.find()) {
                         temId = m.group();
                    }
                    int id = Integer.parseInt(temId + i++);
                    houseTypeId = houseTypeId + id + "-";
                    String title = liEle.select("a").attr("title");
                    String typeImageUrl = liEle.select("img").attr("imglazyload-src");
                    String typeEng = liEle.select(".desc-txt .desc-k").text();
                    String typeCn = liEle.select(".desc-txt .desc-v").text();
                    Integer hotStatus = 0;
                    Integer saleStatus = 0;
                    if (liEle.select(".type-name .hot-sale").size() != 0) {
                        hotStatus = 1;
                    }

                    if (liEle.select(".type-name .zsale").size() != 0) {
                        saleStatus = 1;
                    }

                    Double houseArea = 0.0;
                    String area = liEle.select(".type-name .area-k").text();

                    for(Matcher matcher = Pattern.compile("\\d+(\\.\\d+)?").matcher(area); matcher.find(); houseArea = Double.parseDouble(matcher.group())) {
                        ;
                    }
                    BigDecimal housearea= BigDecimal.valueOf(houseArea);
                    houseTypeInfo = new HouseTypeInfos(id, houseId, title, totalType, typeImageUrl, typeEng, typeCn, hotStatus, saleStatus, housearea,houseTypeId);
                    houseTypeInfos.add(houseTypeInfo);
                }
            }
        }

        return houseTypeInfo;
    }

    public List<UserComment> getUserComment(String houseId, String userCommentUrl) throws IOException, ParseException {
        Document doc = getDocument(userCommentUrl);
        List<Element> liEles = doc.select(".total-revlist li");
        if (liEles.size() > 0) {
            Iterator var6 = liEles.iterator();

            while(var6.hasNext()) {
                Element liEle = (Element)var6.next();
                String userPhotoUrl = liEle.select(".info-user img").attr("imglazyload-src");
                Elements modEle = liEle.select(".info-mod");
                String username = modEle.select(".clearfix .author").text();
                String comment = modEle.select(".all-text").text();
                comment = comment.substring(0, comment.length() - 2);
                String commentTime = modEle.select(".tray-panel .date").text();
                UserComment userCommnet = new UserComment(houseId, userPhotoUrl, username, comment, commentTime);
                userComments.add(userCommnet);
            }
        }

        return userComments;
    }

    public synchronized Map<Integer, Object> getUrlAndId(List<String> houseIds, List<String> allwaitUrls) {
        String url = "";
        String id = null;
        if (allwaitUrls.size() > 0) {
            url = (String)allwaitUrls.get(0);
            id = (String)houseIds.get(0);
            allwaitUrls.remove(0);
            houseIds.remove(0);
        }

        Map<Integer, Object> map = new HashMap();
        map.put(1, id);
        map.put(2, url);
        return map;
    }

    public static Document getDocument(String url) throws IOException {
        Document doc;
        try {
            doc = Jsoup.connect(url).timeout(50000).get();
        } catch (HttpStatusException var11) {
            doc = Jsoup.connect(url).timeout(50000).get();
        }
        return doc;
    }

    public class CrawThread implements Runnable {
        private List<String> houseIds;
        private List<String> itemsNameUrls;

        public CrawThread(List<String> houseIds, List<String> itemsNameUrls) {
            this.houseIds = houseIds;
            this.itemsNameUrls = itemsNameUrls;
        }

        public void run() {
            while(this.itemsNameUrls.size() > 0) {
                try {
                    Map<Integer, Object> map = HouseInfoUtil.this.getUrlAndId(this.houseIds, this.itemsNameUrls);
                    String houseId = (String) map.get(1);
                    String url = (String)map.get(2);
                    if (!HouseInfoUtil.overUrls.contains(url) && url.length() > 0) {
                        HouseInfos houseInfo = HouseInfoUtil.this.getHouseInfos(houseId, url);
                        System.out.println(houseInfo);
                        HouseInfoUtil.houseInfos.add(houseInfo);
                        HouseInfoUtil.overUrls.add(url);
                        System.out.println(HouseInfoUtil.houseInfos.size());
                        System.out.println(Thread.currentThread().getName() + "正在爬取");
                        Thread.sleep(10L);
                    }
                } catch (Exception var5) {
                    var5.printStackTrace();
                }
            }

        }
    }
}

