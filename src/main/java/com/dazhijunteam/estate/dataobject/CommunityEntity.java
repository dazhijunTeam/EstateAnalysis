package com.dazhijunteam.estate.dataobject;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "community", schema = "EstateAnalysis", catalog = "")
public class CommunityEntity {
    private String communityId;
    private String communityName;
    private String communityAddress;
    private String communityDistrictid;
    private String communityTypeandsize;
    private String communityPhone;
    private Integer communityAvprice;
    private String communityPriceinfo;
    private String communityHousetype;
    private Integer communityTotalprice;
    private String communityImage;
    private String communityInfourl;
    private Integer communityLowprice;
    private Byte isCheap=0;

    @Id
    @Column(name = "community_id", nullable = false, length = 30)
    public String getCommunityId() {
        return communityId;
    }

    public void setCommunityId(String communityId) {
        this.communityId = communityId;
    }

    @Basic
    @Column(name = "community_name", nullable = true, length = 50)
    public String getCommunityName() {
        return communityName;
    }

    public void setCommunityName(String communityName) {
        this.communityName = communityName;
    }

    @Basic
    @Column(name = "community_address", nullable = true, length = 255)
    public String getCommunityAddress() {
        return communityAddress;
    }

    public void setCommunityAddress(String communityAddress) {
        this.communityAddress = communityAddress;
    }

    @Basic
    @Column(name = "community_districtid", nullable = false, length = 30)
    public String getCommunityDistrictid() {
        return communityDistrictid;
    }

    public void setCommunityDistrictid(String communityDistrictid) {
        this.communityDistrictid = communityDistrictid;
    }

    @Basic
    @Column(name = "community_typeandsize", nullable = false, length = 30)
    public String getCommunityTypeandsize() {
        return communityTypeandsize;
    }

    public void setCommunityTypeandsize(String communityTypeandsize) {
        this.communityTypeandsize = communityTypeandsize;
    }

    @Basic
    @Column(name = "community_phone", nullable = true, length = 20)
    public String getCommunityPhone() {
        return communityPhone;
    }

    public void setCommunityPhone(String communityPhone) {
        this.communityPhone = communityPhone;
    }

    @Basic
    @Column(name = "community_avprice", nullable = true)
    public Integer getCommunityAvprice() {
        return communityAvprice;
    }

    public void setCommunityAvprice(Integer communityAvprice) {
        this.communityAvprice = communityAvprice;
    }

    @Basic
    @Column(name = "community_priceinfo", nullable = false, length = 60)
    public String getCommunityPriceinfo() {
        return communityPriceinfo;
    }

    public void setCommunityPriceinfo(String communityPriceinfo) {
        this.communityPriceinfo = communityPriceinfo;
    }

    @Basic
    @Column(name = "community_housetype", nullable = true, length = 255)
    public String getCommunityHousetype() {
        return communityHousetype;
    }

    public void setCommunityHousetype(String communityHousetype) {
        this.communityHousetype = communityHousetype;
    }

    @Basic
    @Column(name = "community_totalprice", nullable = true)
    public Integer getCommunityTotalprice() {
        return communityTotalprice;
    }

    public void setCommunityTotalprice(Integer communityTotalprice) {
        this.communityTotalprice = communityTotalprice;
    }

    @Basic
    @Column(name = "community_image", nullable = true, length = 255)
    public String getCommunityImage() {
        return communityImage;
    }

    public void setCommunityImage(String communityImage) {
        this.communityImage = communityImage;
    }

    @Basic
    @Column(name = "community_infourl", nullable = true, length = 100)
    public String getCommunityInfourl() {
        return communityInfourl;
    }

    public void setCommunityInfourl(String communityInfourl) {
        this.communityInfourl = communityInfourl;
    }

    @Basic
    @Column(name = "community_lowprice", nullable = true)
    public Integer getCommunityLowprice() {
        return communityLowprice;
    }

    public void setCommunityLowprice(Integer communityLowprice) {
        this.communityLowprice = communityLowprice;
    }

    @Basic
    @Column(name = "is_cheap", nullable = false)
    public Byte getIsCheap() {
        return isCheap;
    }

    public void setIsCheap(Byte isCheap) {
        this.isCheap = isCheap;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommunityEntity that = (CommunityEntity) o;
        return Objects.equals(communityId, that.communityId) &&
                Objects.equals(communityName, that.communityName) &&
                Objects.equals(communityAddress, that.communityAddress) &&
                Objects.equals(communityDistrictid, that.communityDistrictid) &&
                Objects.equals(communityTypeandsize, that.communityTypeandsize) &&
                Objects.equals(communityPhone, that.communityPhone) &&
                Objects.equals(communityAvprice, that.communityAvprice) &&
                Objects.equals(communityPriceinfo, that.communityPriceinfo) &&
                Objects.equals(communityHousetype, that.communityHousetype) &&
                Objects.equals(communityTotalprice, that.communityTotalprice) &&
                Objects.equals(communityImage, that.communityImage) &&
                Objects.equals(communityInfourl, that.communityInfourl) &&
                Objects.equals(communityLowprice, that.communityLowprice) &&
                Objects.equals(isCheap, that.isCheap);
    }

    @Override
    public int hashCode() {

        return Objects.hash(communityId, communityName, communityAddress, communityDistrictid, communityTypeandsize, communityPhone, communityAvprice, communityPriceinfo, communityHousetype, communityTotalprice, communityImage, communityInfourl, communityLowprice, isCheap);
    }
}
