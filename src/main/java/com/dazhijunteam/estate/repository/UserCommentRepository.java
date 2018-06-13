package com.dazhijunteam.estate.repository;

import com.dazhijunteam.estate.bean.UserComment;
import com.dazhijunteam.estate.dataobject.DistrictEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserCommentRepository extends JpaRepository<UserComment,String> {

    List<UserComment> getByHouseId(String communityid);
}
