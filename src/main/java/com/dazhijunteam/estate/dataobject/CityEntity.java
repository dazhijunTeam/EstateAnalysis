package com.dazhijunteam.estate.dataobject;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "city", schema = "EstateAnalysis", catalog = "")
public class CityEntity {
    private String cityId;
    private String cityName;
    private String cityProvinceid;
    private String cityFirst;

    @Id
    @Column(name = "city_id", nullable = false, length = 30)
    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    @Basic
    @Column(name = "city_name", nullable = true, length = 10)
    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    @Basic
    @Column(name = "city_provinceid", nullable = true, length = 30)
    public String getCityProvinceid() {
        return cityProvinceid;
    }

    public void setCityProvinceid(String cityProvinceid) {
        this.cityProvinceid = cityProvinceid;
    }

    @Basic
    @Column(name = "city_first", nullable = true, length = 10)
    public String getCityFirst() {
        return cityFirst;
    }

    public void setCityFirst(String cityFirst) {
        this.cityFirst = cityFirst;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CityEntity that = (CityEntity) o;
        return Objects.equals(cityId, that.cityId) &&
                Objects.equals(cityName, that.cityName) &&
                Objects.equals(cityProvinceid, that.cityProvinceid) &&
                Objects.equals(cityFirst, that.cityFirst);
    }

    @Override
    public int hashCode() {

        return Objects.hash(cityId, cityName, cityProvinceid, cityFirst);
    }
}
