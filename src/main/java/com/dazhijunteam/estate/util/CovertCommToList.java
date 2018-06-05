package com.dazhijunteam.estate.util;

import com.dazhijunteam.estate.dataobject.CommunityEntity;
import com.dazhijunteam.estate.dataobject.twoComm;
import com.dazhijunteam.estate.exception.CovertException;

import java.util.ArrayList;
import java.util.List;

public class CovertCommToList {

    public static List<twoComm> covertwithTwolist(List<CommunityEntity> left,List<CommunityEntity> right){

        List<twoComm> twoComms=new ArrayList<>();

        for (int i=0;i<left.size();i++){
            twoComm twoComm=new twoComm();
            twoComm.setLeft(left.get(i));
            twoComm.setRight(right.get(i));
            twoComms.add(twoComm);
        }

        return twoComms;
    }
}
