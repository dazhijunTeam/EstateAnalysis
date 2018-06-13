package com.dazhijunteam.estate.bean;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Data
@Table(name = "house_type_infos", schema = "EstateAnalysis", catalog = "")
public class HouseTypeInfos {
    @Id
    private Integer id;
    private String houseId;
    private String title;
    private String totalType;
    private String typeImageUrl;
    private String typeEng;
    private String typeCn;
    private Integer hotStatus;
    private Integer saleStatus;
    private BigDecimal houseArea;

    @Transient
    private String HouseTypeId;

    public HouseTypeInfos() {
    }

    public HouseTypeInfos(Integer id, String houseId, String title, String totalType, String typeImageUrl, String typeEng, String typeCn, Integer hotStatus, Integer saleStatus, BigDecimal houseArea,String houseTypeId) {
        this.id = id;
        this.houseId = houseId;
        this.title = title;
        this.totalType = totalType;
        this.typeImageUrl = typeImageUrl;
        this.typeEng = typeEng;
        this.typeCn = typeCn;
        this.hotStatus = hotStatus;
        this.saleStatus = saleStatus;
        this.houseArea = houseArea;
        this.HouseTypeId=houseTypeId;
    }
}
