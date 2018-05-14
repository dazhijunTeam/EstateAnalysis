package com.dazhijunteam.estate.dataobject;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "community", schema = "EstateAnalysis", catalog = "")
public class CommunityEntity {
    private String communityId;
    private String communityName;
    private String communityComment;
    private String communityDistrictid;
    private String communityDeveloper;
    private Timestamp communityBuildDate;
    private Integer communityProperty;
    private String communityHousetypeid;
    private String communityPhone;
    private BigDecimal communityAverageprice;
    private String communityLabel;
    private String communityHousetype;
    private String communityArea;
    private Date communityOpen;
    private Date communityGived;
    private String communityTypecomm;

    @Id
    @Column(name = "community_id", nullable = false, length = 30)
    public String getCommunityId() {
        return communityId;
    }

    public void setCommunityId(String communityId) {
        this.communityId = communityId;
    }

    @Basic
    @Column(name = "community_name", nullable = true, length = 10)
    public String getCommunityName() {
        return communityName;
    }

    public void setCommunityName(String communityName) {
        this.communityName = communityName;
    }

    @Basic
    @Column(name = "community_comment", nullable = true, length = 255)
    public String getCommunityComment() {
        return communityComment;
    }

    public void setCommunityComment(String communityComment) {
        this.communityComment = communityComment;
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
    @Column(name = "community_developer", nullable = true, length = 30)
    public String getCommunityDeveloper() {
        return communityDeveloper;
    }

    public void setCommunityDeveloper(String communityDeveloper) {
        this.communityDeveloper = communityDeveloper;
    }

    @Basic
    @Column(name = "community_build_date", nullable = true)
    public Timestamp getCommunityBuildDate() {
        return communityBuildDate;
    }

    public void setCommunityBuildDate(Timestamp communityBuildDate) {
        this.communityBuildDate = communityBuildDate;
    }

    @Basic
    @Column(name = "community_property", nullable = true)
    public Integer getCommunityProperty() {
        return communityProperty;
    }

    public void setCommunityProperty(Integer communityProperty) {
        this.communityProperty = communityProperty;
    }

    @Basic
    @Column(name = "community_housetypeid", nullable = false, length = 30)
    public String getCommunityHousetypeid() {
        return communityHousetypeid;
    }

    public void setCommunityHousetypeid(String communityHousetypeid) {
        this.communityHousetypeid = communityHousetypeid;
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
    @Column(name = "community_averageprice", nullable = true, precision = 2)
    public BigDecimal getCommunityAverageprice() {
        return communityAverageprice;
    }

    public void setCommunityAverageprice(BigDecimal communityAverageprice) {
        this.communityAverageprice = communityAverageprice;
    }

    @Basic
    @Column(name = "community_label", nullable = false, length = 60)
    public String getCommunityLabel() {
        return communityLabel;
    }

    public void setCommunityLabel(String communityLabel) {
        this.communityLabel = communityLabel;
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
    @Column(name = "community_area", nullable = true, length = 50)
    public String getCommunityArea() {
        return communityArea;
    }

    public void setCommunityArea(String communityArea) {
        this.communityArea = communityArea;
    }

    @Basic
    @Column(name = "community_open", nullable = true)
    public Date getCommunityOpen() {
        return communityOpen;
    }

    public void setCommunityOpen(Date communityOpen) {
        this.communityOpen = communityOpen;
    }

    @Basic
    @Column(name = "community_gived", nullable = true)
    public Date getCommunityGived() {
        return communityGived;
    }

    public void setCommunityGived(Date communityGived) {
        this.communityGived = communityGived;
    }

    @Basic
    @Column(name = "community_typecomm", nullable = true, length = 50)
    public String getCommunityTypecomm() {
        return communityTypecomm;
    }

    public void setCommunityTypecomm(String communityTypecomm) {
        this.communityTypecomm = communityTypecomm;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommunityEntity that = (CommunityEntity) o;
        return Objects.equals(communityId, that.communityId) &&
                Objects.equals(communityName, that.communityName) &&
                Objects.equals(communityComment, that.communityComment) &&
                Objects.equals(communityDistrictid, that.communityDistrictid) &&
                Objects.equals(communityDeveloper, that.communityDeveloper) &&
                Objects.equals(communityBuildDate, that.communityBuildDate) &&
                Objects.equals(communityProperty, that.communityProperty) &&
                Objects.equals(communityHousetypeid, that.communityHousetypeid) &&
                Objects.equals(communityPhone, that.communityPhone) &&
                Objects.equals(communityAverageprice, that.communityAverageprice) &&
                Objects.equals(communityLabel, that.communityLabel) &&
                Objects.equals(communityHousetype, that.communityHousetype) &&
                Objects.equals(communityArea, that.communityArea) &&
                Objects.equals(communityOpen, that.communityOpen) &&
                Objects.equals(communityGived, that.communityGived) &&
                Objects.equals(communityTypecomm, that.communityTypecomm);
    }

    @Override
    public int hashCode() {

        return Objects.hash(communityId, communityName, communityComment, communityDistrictid, communityDeveloper, communityBuildDate, communityProperty, communityHousetypeid, communityPhone, communityAverageprice, communityLabel, communityHousetype, communityArea, communityOpen, communityGived, communityTypecomm);
    }
}
