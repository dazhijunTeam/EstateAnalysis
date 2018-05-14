package com.dazhijunteam.estate.dataobject;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "news", schema = "EstateAnalysis", catalog = "")
public class NewsEntity {
    private String newsId;
    private String newsCityid;
    private String newsTypeid;
    private String newsTitle;
    private String newsAuthor;
    private Date newsData;
    private String newsContent;
    private String newsSummary;
    private String newsTag;
    private String newsImage;

    public void setNewsData(Date newsData) {
        this.newsData = newsData;
    }

    @Id
    @Column(name = "news_id", nullable = false, length = 30)
    public String getNewsId() {
        return newsId;
    }

    public void setNewsId(String newsId) {
        this.newsId = newsId;
    }

    @Basic
    @Column(name = "news_cityid", nullable = false, length = 30)
    public String getNewsCityid() {
        return newsCityid;
    }

    public void setNewsCityid(String newsCityid) {
        this.newsCityid = newsCityid;
    }

    @Basic
    @Column(name = "news_typeid", nullable = false, length = 30)
    public String getNewsTypeid() {
        return newsTypeid;
    }

    public void setNewsTypeid(String newsTypeid) {
        this.newsTypeid = newsTypeid;
    }

    @Basic
    @Column(name = "news_title", nullable = true, length = 50)
    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    @Basic
    @Column(name = "news_author", nullable = true, length = 20)
    public String getNewsAuthor() {
        return newsAuthor;
    }

    public void setNewsAuthor(String newsAuthor) {
        this.newsAuthor = newsAuthor;
    }

    @Basic
    @Column(name = "news_data", nullable = true)
    public Date getNewsData() {
        return newsData;
    }

    @Basic
    @Column(name = "news_content", nullable = true, length = -1)
    public String getNewsContent() {
        return newsContent;
    }

    public void setNewsContent(String newsContent) {
        this.newsContent = newsContent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NewsEntity that = (NewsEntity) o;
        return Objects.equals(newsId, that.newsId) &&
                Objects.equals(newsCityid, that.newsCityid) &&
                Objects.equals(newsTypeid, that.newsTypeid) &&
                Objects.equals(newsTitle, that.newsTitle) &&
                Objects.equals(newsAuthor, that.newsAuthor) &&
                Objects.equals(newsData, that.newsData) &&
                Objects.equals(newsContent, that.newsContent);
    }

    @Override
    public int hashCode() {

        return Objects.hash(newsId, newsCityid, newsTypeid, newsTitle, newsAuthor, newsData, newsContent);
    }

    @Basic
    @Column(name = "news_summary", nullable = true, length = -1)
    public String getNewsSummary() {
        return newsSummary;
    }

    @Override
    public String toString() {
        return "NewsEntity{" +
                "newsId='" + newsId + '\'' +
                ", newsCityid='" + newsCityid + '\'' +
                ", newsTypeid='" + newsTypeid + '\'' +
                ", newsTitle='" + newsTitle + '\'' +
                ", newsAuthor='" + newsAuthor + '\'' +
                ", newsData=" + newsData +
                ", newsContent='" + newsContent + '\'' +
                ", newsSummary='" + newsSummary + '\'' +
                ", newsTag='" + newsTag + '\'' +
                ", newsImage='" + newsImage + '\'' +
                '}';
    }

    public void setNewsSummary(String newsSummary) {
        this.newsSummary = newsSummary;
    }

    @Basic
    @Column(name = "news_tag", nullable = true, length = 255)
    public String getNewsTag() {
        return newsTag;
    }

    public void setNewsTag(String newsTag) {
        this.newsTag = newsTag;
    }

    @Basic
    @Column(name = "news_image", nullable = true, length = 255)
    public String getNewsImage() {
        return newsImage;
    }

    public void setNewsImage(String newsImage) {
        this.newsImage = newsImage;
    }
}
