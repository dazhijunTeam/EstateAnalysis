package com.dazhijunteam.estate.dataobject;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "housetype", schema = "EstateAnalysis", catalog = "")
public class HousetypeEntity {
    private String housetypeId;
    private String housetypeLabel;
    private BigDecimal housetypeArea;
    private BigDecimal housetypeTotalprice;
    private String housetypeHeading;
    private String housetypeComment;
    private Double housetypeHeight;
    private String housetypeImage;
    private String housetypeName;
    private String housetypePhone;
    private String housetypeRoom;
    private BigDecimal housetypePrice;

    @Id
    @Column(name = "housetype_id", nullable = false, length = 30)
    public String getHousetypeId() {
        return housetypeId;
    }

    public void setHousetypeId(String housetypeId) {
        this.housetypeId = housetypeId;
    }

    @Basic
    @Column(name = "housetype_label", nullable = false, length = 30)
    public String getHousetypeLabel() {
        return housetypeLabel;
    }

    public void setHousetypeLabel(String housetypeLabel) {
        this.housetypeLabel = housetypeLabel;
    }

    @Basic
    @Column(name = "housetype_area", nullable = true, precision = 2)
    public BigDecimal getHousetypeArea() {
        return housetypeArea;
    }

    public void setHousetypeArea(BigDecimal housetypeArea) {
        this.housetypeArea = housetypeArea;
    }

    @Basic
    @Column(name = "housetype_totalprice", nullable = true, precision = 2)
    public BigDecimal getHousetypeTotalprice() {
        return housetypeTotalprice;
    }

    public void setHousetypeTotalprice(BigDecimal housetypeTotalprice) {
        this.housetypeTotalprice = housetypeTotalprice;
    }

    @Basic
    @Column(name = "housetype_heading", nullable = true, length = 50)
    public String getHousetypeHeading() {
        return housetypeHeading;
    }

    public void setHousetypeHeading(String housetypeHeading) {
        this.housetypeHeading = housetypeHeading;
    }

    @Basic
    @Column(name = "housetype_comment", nullable = true, length = 255)
    public String getHousetypeComment() {
        return housetypeComment;
    }

    public void setHousetypeComment(String housetypeComment) {
        this.housetypeComment = housetypeComment;
    }

    @Basic
    @Column(name = "housetype_height", nullable = false, precision = 0)
    public Double getHousetypeHeight() {
        return housetypeHeight;
    }

    public void setHousetypeHeight(Double housetypeHeight) {
        this.housetypeHeight = housetypeHeight;
    }

    @Basic
    @Column(name = "housetype_image", nullable = false, length = 255)
    public String getHousetypeImage() {
        return housetypeImage;
    }

    public void setHousetypeImage(String housetypeImage) {
        this.housetypeImage = housetypeImage;
    }

    @Basic
    @Column(name = "housetype_name", nullable = true, length = 30)
    public String getHousetypeName() {
        return housetypeName;
    }

    public void setHousetypeName(String housetypeName) {
        this.housetypeName = housetypeName;
    }

    @Basic
    @Column(name = "housetype_phone", nullable = true, length = 20)
    public String getHousetypePhone() {
        return housetypePhone;
    }

    public void setHousetypePhone(String housetypePhone) {
        this.housetypePhone = housetypePhone;
    }

    @Basic
    @Column(name = "housetype_room", nullable = true, length = 50)
    public String getHousetypeRoom() {
        return housetypeRoom;
    }

    public void setHousetypeRoom(String housetypeRoom) {
        this.housetypeRoom = housetypeRoom;
    }

    @Basic
    @Column(name = "housetype_price", nullable = true, precision = 2)
    public BigDecimal getHousetypePrice() {
        return housetypePrice;
    }

    public void setHousetypePrice(BigDecimal housetypePrice) {
        this.housetypePrice = housetypePrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HousetypeEntity that = (HousetypeEntity) o;
        return Objects.equals(housetypeId, that.housetypeId) &&
                Objects.equals(housetypeLabel, that.housetypeLabel) &&
                Objects.equals(housetypeArea, that.housetypeArea) &&
                Objects.equals(housetypeTotalprice, that.housetypeTotalprice) &&
                Objects.equals(housetypeHeading, that.housetypeHeading) &&
                Objects.equals(housetypeComment, that.housetypeComment) &&
                Objects.equals(housetypeHeight, that.housetypeHeight) &&
                Objects.equals(housetypeImage, that.housetypeImage) &&
                Objects.equals(housetypeName, that.housetypeName) &&
                Objects.equals(housetypePhone, that.housetypePhone) &&
                Objects.equals(housetypeRoom, that.housetypeRoom) &&
                Objects.equals(housetypePrice, that.housetypePrice);
    }

    @Override
    public int hashCode() {

        return Objects.hash(housetypeId, housetypeLabel, housetypeArea, housetypeTotalprice, housetypeHeading, housetypeComment, housetypeHeight, housetypeImage, housetypeName, housetypePhone, housetypeRoom, housetypePrice);
    }
}
