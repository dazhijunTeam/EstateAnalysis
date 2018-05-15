package com.dazhijunteam.estate.enums;

import lombok.Data;

public enum CityEnum {
    BEIJING("1", "bj"),
    TIANJIN("2", "tj"),
    LANGFANG("3", "LF"),
    SHIJIAZHUANG("4", "SJZ"),
    TAIYUAN("5", "TY"),
    BAOTOU("6", "BT"),
    WEIFANG("7", "WF"),
    YANTAI("8", "YT"),
    DALIAN("9", "DL"),
    HAERBIN("10", "HEB"),
    SHENYANG("11", "SY"),
    CHANGCHUN("12", "CC"),
    SHANGHAI("13", "SH"),
    KUNSHAN("14", "KS"),
    HANGZHOU("15", "HZ"),
    SUZHOU("16", "SZ"),
    NANJING("17", "NJ"),
    WUXI("18", "WX"),
    NINGBO("19", "NB"),
    HEFEI("20", "HF"),
    JINAN("21", "JN"),
    QINGDAO("22", "QD"),
    NANTONG("23", "NT"),
    YANGZHOU("24", "YZ"),
    CHANGZHOU("25", "CZ"),
    TAIZHOU("26", "TZ"),
    SHENZHEN("27", "SZ"),
    GUANGZHOU("28", "GZ"),
    FOSHAN("29", "FS"),
    SANYA("30", "SY"),
    HUIZHOU("31", "HZ"),
    FUZHOU("32", "FZ"),
    XIAMEN("33", "XM"),
    DONGGUAN("34", "DG"),
    ZHUHAI("35", "ZH"),
    ZHONGSHAN("36", "ZS"),
    JIANGMEN("37", "JM"),
    NANNING("38", "NN"),
    NANCHANG("39", "nc"),
    HAIKOU("40", "HK"),
    CHENGDU("41", "CD"),
    CHONGQING("42", "CQ"),
    WUHAN("43", "WH"),
    ZHENGZHOU("44", "ZZ"),
    XIAN("45", "XA"),
    CHANGSHA("46", "CS"),
    KUNMING("47", "KM"),
    GUIYANG("48", "GY"),
    LUOYANG("49", "LY"),
    WULUMUQI("50", "WLMQ"),
    LANZHOU("51", "LZ"),
    XUCHANG("52", "XC"),
    YICHANG("53", "YC");

    public String code;
    public String cityFirst;

    CityEnum(String code, String cityFirst) {
        this.code = code;
        this.cityFirst = cityFirst;
    }
}
