package com.dazhijunteam.estate.service;

import com.dazhijunteam.estate.bean.UserComment;

import java.util.List;

public interface UserCommentService {
    List<UserComment> getByHouseId(String communityid);
}
