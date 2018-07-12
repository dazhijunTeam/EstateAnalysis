package com.dazhijunteam.estate.crawlerbean;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.sql.Timestamp;
@Data
public class NewsCrawlerBean {

//    private String newsId;
//    private String newsCityid;
//    private String newsContent;
    @SerializedName(value ="category")
    private String newsType;

    @SerializedName(value ="title")
    private String newsTitle;

    @SerializedName(value ="author")
    private String newsAuthor;

    @SerializedName(value ="time")
    private String newsData;

    @SerializedName(value ="summary")
    private String newsSummary;

    @SerializedName(value ="newest_tag")
    private String newsTag;

    @SerializedName(value ="image_url")
    private String newsImage;

    @SerializedName(value ="url")
    private String news_url;
}
