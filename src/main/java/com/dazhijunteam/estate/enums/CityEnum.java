package com.dazhijunteam.estate.enums;

import lombok.Data;

public enum CityEnum {
    BEIJING("1", "bj"),
    SHANGHAI("2", "sh"),
    guangzhou("3","gz"),
    SHENZHEN("4", "sz"),
    HANGZHOU("5", "hz"),
    NANJING("6", "nj"),
    XIAMEN("7", "xm"),
    NANCHANG("8", "nc");

    public String code;
    public String cityFirst;

    CityEnum(String code, String cityFirst) {
        this.code = code;
        this.cityFirst = cityFirst;
    }
}
