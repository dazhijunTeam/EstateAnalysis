package com.dazhijunteam.estate.repository;

import com.dazhijunteam.estate.dataobject.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String>{
    @Override
    User getOne(String s);
}
