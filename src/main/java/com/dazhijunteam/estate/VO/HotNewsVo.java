package com.dazhijunteam.estate.VO;

import lombok.Data;

@Data
public class HotNewsVo<T> {
    private String total;
    private T list;
}
