package com.dazhijunteam.estate.VO;

import lombok.Data;

@Data
public class HotNewsVo<T> {
    private int total;
    private T list;
    public static void main(String[] args){
        String a="aaabbb";
        String b="aaa"+new String("bbb");
        System.out.println(b==a);
    }
}
