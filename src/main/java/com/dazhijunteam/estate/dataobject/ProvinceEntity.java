package com.dazhijunteam.estate.dataobject;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "province", schema = "EstateAnalysis", catalog = "")
public class ProvinceEntity {
    private String provinceId;
    private String provinceName;

    @Id
    @Column(name = "province_id", nullable = false, length = 30)
    public String getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(String provinceId) {
        this.provinceId = provinceId;
    }

    @Basic
    @Column(name = "province_name", nullable = true, length = 10)
    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProvinceEntity that = (ProvinceEntity) o;
        return Objects.equals(provinceId, that.provinceId) &&
                Objects.equals(provinceName, that.provinceName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(provinceId, provinceName);
    }
}
