package com.dazhijunteam.estate.util;

import com.dazhijunteam.estate.bean.HouseTypeInfos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HouseTypeUtil {
    public static Map<String,List<HouseTypeInfos>> HouseTypeListToMap(List<HouseTypeInfos> houseTypeInfosList){
        Map<String,List<HouseTypeInfos>> typeMap=new HashMap<>();
        //typeList中存储的是房产的户型类型集
        List<String> typeList=new ArrayList<>();
        for (HouseTypeInfos houseTypeInfo:houseTypeInfosList){
            if (!typeList.contains(houseTypeInfo.getTotalType())){
                typeList.add(houseTypeInfo.getTotalType());
            }
        }
        //遍历list中的户型类型集，将同一类型的户型放入至map中
        for (String houseType:typeList){
            List<HouseTypeInfos> houseTypeInfos=new ArrayList<>();
            for (HouseTypeInfos houseTypeInfo:houseTypeInfosList){
                if (houseType.equals(houseTypeInfo.getTotalType())){
                    houseTypeInfos.add(houseTypeInfo);
                }
            }
            typeMap.put(houseType,houseTypeInfos);
        }
        return typeMap;
    }
}
