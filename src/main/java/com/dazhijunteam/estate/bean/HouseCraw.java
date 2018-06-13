package com.dazhijunteam.estate.bean;

import lombok.Data;

import java.util.List;

@Data
public class HouseCraw {
    private List<HouseInfos> houseInfos;
    private List<HouseTypeInfos> houseTypeInfos;
    private List<UserComment> userComments;

    public HouseCraw() {
    }
}
