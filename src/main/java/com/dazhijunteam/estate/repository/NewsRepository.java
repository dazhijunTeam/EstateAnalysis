package com.dazhijunteam.estate.repository;

import com.dazhijunteam.estate.dataobject.NewsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NewsRepository extends JpaRepository<NewsEntity,String>{

}
