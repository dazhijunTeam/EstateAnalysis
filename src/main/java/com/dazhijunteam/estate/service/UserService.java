package com.dazhijunteam.estate.service;

import com.dazhijunteam.estate.dataobject.User;

public interface UserService {
    User getOne(String s);

    void save(User user);

    Integer getMayLowPrice(User user);

    Integer getMayHighPrice(User user);
}
