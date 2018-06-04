package com.dazhijunteam.estate.dataobject;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "district", schema = "EstateAnalysis", catalog = "")
public class DistrictEntity {
    private String districtId;
    private String districtName;
    private String districtCityid;
    private String districtEname;

    @Id
    @Column(name = "district_id", nullable = false, length = 30)
    public String getDistrictId() {
        return districtId;
    }

    public void setDistrictId(String districtId) {
        this.districtId = districtId;
    }

    @Basic
    @Column(name = "district_name", nullable = true, length = 10)
    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    @Basic
    @Column(name = "district_cityid", nullable = false, length = 30)
    public String getDistrictCityid() {
        return districtCityid;
    }

    public void setDistrictCityid(String districtCityid) {
        this.districtCityid = districtCityid;
    }

    @Basic
    @Column(name = "district_ename", nullable = true, length = 20)
    public String getDistrictEname() {
        return districtEname;
    }

    public void setDistrictEname(String districtEname) {
        this.districtEname = districtEname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DistrictEntity that = (DistrictEntity) o;
        return Objects.equals(districtId, that.districtId) &&
                Objects.equals(districtName, that.districtName) &&
                Objects.equals(districtCityid, that.districtCityid) &&
                Objects.equals(districtEname, that.districtEname);
    }

    @Override
    public int hashCode() {

        return Objects.hash(districtId, districtName, districtCityid, districtEname);
    }
}
