package com.dazhijunteam.estate.bean;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "house_infos", schema = "EstateAnalysis", catalog = "")
public class HouseInfos {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    private String houseId;
    private String houseImageUrl;
    private String price;
    private String aroundPrice;
    private String houseType;
    private String houseTypeId;
    private String address;
    private String tel;
    private String openTime;
    private String completeTime;
    private String buildingType;
    private String commentNum;
    private String houseYears;

    public HouseInfos(){

    }
    public HouseInfos(Integer id, String houseId, String houseImageUrl, String price, String aroundPrice, String houseType, String houseTypeId, String address, String tel, String openTime, String completeTime, String buildingType, String commentNum, String houseYears) {
        this.id = id;
        this.houseId = houseId;
        this.houseImageUrl = houseImageUrl;
        this.price = price;
        this.aroundPrice = aroundPrice;
        this.houseType = houseType;
        this.houseTypeId = houseTypeId;
        this.address = address;
        this.tel = tel;
        this.openTime = openTime;
        this.completeTime = completeTime;
        this.buildingType = buildingType;
        this.commentNum = commentNum;
        this.houseYears = houseYears;
    }

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getId() {
        return id;
    }

    @GeneratedValue
    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "house_id", nullable = false)
    public String getHouseId() {
        return houseId;
    }

    public void setHouseId(String houseId) {
        this.houseId = houseId;
    }

    @Basic
    @Column(name = "house_image_url", nullable = false, length = 800)
    public String getHouseImageUrl() {
        return houseImageUrl;
    }

    public void setHouseImageUrl(String houseImageUrl) {
        this.houseImageUrl = houseImageUrl;
    }

    @Basic
    @Column(name = "price", nullable = false, length = 50)
    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Basic
    @Column(name = "around_price", nullable = false, length = 20)
    public String getAroundPrice() {
        return aroundPrice;
    }

    public void setAroundPrice(String aroundPrice) {
        this.aroundPrice = aroundPrice;
    }

    @Basic
    @Column(name = "house_type", nullable = false, length = 30)
    public String getHouseType() {
        return houseType;
    }

    public void setHouseType(String houseType) {
        this.houseType = houseType;
    }

    @Basic
    @Column(name = "house_type_id", nullable = false, length = 200)
    public String getHouseTypeId() {
        return houseTypeId;
    }

    public void setHouseTypeId(String houseTypeId) {
        this.houseTypeId = houseTypeId;
    }

    @Basic
    @Column(name = "address", nullable = false, length = 80)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "tel", nullable = false, length = 25)
    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Basic
    @Column(name = "open_time", nullable = false, length = 20)
    public String getOpenTime() {
        return openTime;
    }

    public void setOpenTime(String openTime) {
        this.openTime = openTime;
    }

    @Basic
    @Column(name = "complete_time", nullable = false, length = 20)
    public String getCompleteTime() {
        return completeTime;
    }

    public void setCompleteTime(String completeTime) {
        this.completeTime = completeTime;
    }

    @Basic
    @Column(name = "building_type", nullable = false, length = 12)
    public String getBuildingType() {
        return buildingType;
    }

    public void setBuildingType(String buildingType) {
        this.buildingType = buildingType;
    }

    @Basic
    @Column(name = "comment_num", nullable = false, length = 10)
    public String getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(String commentNum) {
        this.commentNum = commentNum;
    }

    @Basic
    @Column(name = "house_years", nullable = false, length = 10)
    public String getHouseYears() {
        return houseYears;
    }

    public void setHouseYears(String houseYears) {
        this.houseYears = houseYears;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HouseInfos that = (HouseInfos) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(houseId, that.houseId) &&
                Objects.equals(houseImageUrl, that.houseImageUrl) &&
                Objects.equals(price, that.price) &&
                Objects.equals(aroundPrice, that.aroundPrice) &&
                Objects.equals(houseType, that.houseType) &&
                Objects.equals(houseTypeId, that.houseTypeId) &&
                Objects.equals(address, that.address) &&
                Objects.equals(tel, that.tel) &&
                Objects.equals(openTime, that.openTime) &&
                Objects.equals(completeTime, that.completeTime) &&
                Objects.equals(buildingType, that.buildingType) &&
                Objects.equals(commentNum, that.commentNum) &&
                Objects.equals(houseYears, that.houseYears);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, houseId, houseImageUrl, price, aroundPrice, houseType, houseTypeId, address, tel, openTime, completeTime, buildingType, commentNum, houseYears);
    }
}
