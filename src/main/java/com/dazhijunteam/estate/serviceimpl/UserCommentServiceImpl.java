package com.dazhijunteam.estate.serviceimpl;

import com.dazhijunteam.estate.bean.UserComment;
import com.dazhijunteam.estate.repository.UserCommentRepository;
import com.dazhijunteam.estate.service.UserCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class UserCommentServiceImpl implements UserCommentService{
    @Autowired
    private UserCommentRepository userCommentRepository;


    @Override
    public List<UserComment> getByHouseId(String communityid) {
        List<UserComment> commentList=userCommentRepository.getByHouseId(communityid);
        Collections.shuffle(commentList);
        List<UserComment> unsortcommentList=new ArrayList<>();
        if (commentList.size()>=8){
            for (int i=0;i<8;i++){
                unsortcommentList.add(commentList.get(i));
            }
            return unsortcommentList;
        }
        return commentList;
    }
}
