package com.dazhijunteam.estate.serviceimpl;

import com.dazhijunteam.estate.dataobject.NewsEntity;
import com.dazhijunteam.estate.repository.NewsRepository;
import com.dazhijunteam.estate.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NewsServiceImpl implements NewsService{
    @Autowired
    private NewsRepository repository;

    @Override
    public NewsEntity save(NewsEntity newsEntity) {
        return repository.save(newsEntity);
    }
}
