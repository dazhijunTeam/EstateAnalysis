package com.dazhijunteam.estate.service;

import com.dazhijunteam.estate.dataobject.NewsEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface NewsService {
    NewsEntity save(NewsEntity newsEntity);

    Page<NewsEntity> findList(Pageable pageable);
}
