package com.dazhijunteam.estate.serviceimpl;

import com.dazhijunteam.estate.dataobject.NewsEntity;
import com.dazhijunteam.estate.repository.NewsRepository;
import com.dazhijunteam.estate.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsServiceImpl implements NewsService{

    @Autowired
    private NewsRepository repository;

    @Override
    public NewsEntity save(NewsEntity newsEntity) {
        return repository.save(newsEntity);
    }

    @Override
    public Page<NewsEntity> findList(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Page<NewsEntity> findListByCityId(Pageable pageable,String cityId) {
        return repository.findListByNewsCityid(pageable,cityId);
    }

    @Override
    public NewsEntity findByNewsId(String newsId) {
        return repository.findOne(newsId);
    }
}
