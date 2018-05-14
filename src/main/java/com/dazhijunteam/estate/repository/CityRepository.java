package com.dazhijunteam.estate.repository;

import com.dazhijunteam.estate.dataobject.CityEntity;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface CityRepository extends JpaRepository<CityEntity,String>{
    CityEntity getByCityId(String id);

    @Override
    List<CityEntity> findAll();
}
