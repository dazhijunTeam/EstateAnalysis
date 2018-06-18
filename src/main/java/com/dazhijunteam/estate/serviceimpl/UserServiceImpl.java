package com.dazhijunteam.estate.serviceimpl;

import com.dazhijunteam.estate.dataobject.User;
import com.dazhijunteam.estate.repository.UserRepository;
import com.dazhijunteam.estate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

    @Override
    public User getOne(String s) {
        return userRepository.getOne(s);
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public Integer getMayLowPrice(User user) {
        int avgPrice=user.getHprice();

        int lowPrice=avgPrice-5000;
        return lowPrice;
    }

    @Override
    public Integer getMayHighPrice(User user) {
        int avgPrice=user.getHprice();
        float index=0;
        if (user.getSalary()>30000){
            index=0.7f;
        } else if (user.getSalary()>20000){
            index=0.65f;
        } else if (user.getSalary()>15000){
            index=0.58f;
        } else if (user.getSalary()>10000){
            index=0.4f;
        } else if (user.getSalary()>6000){
            index=0.3f;
        } else if (user.getSalary()>3000){
            index=0.1f;
        }

        int highPrice=avgPrice+(int)(20000*index);
        return highPrice;
    }
}
