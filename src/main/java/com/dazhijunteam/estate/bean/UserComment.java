package com.dazhijunteam.estate.bean;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "user_comment", schema = "EstateAnalysis", catalog = "")
public class UserComment {
    private Integer id;
    private String houseId;
    private String userPhotoUrl;
    private String username;
    private String comment;
    private String commentTime;

    public UserComment(){

    }

    public UserComment(String houseId, String userPhotoUrl, String username, String comment, String commentTime) {
        this.houseId = houseId;
        this.userPhotoUrl = userPhotoUrl;
        this.username = username;
        this.comment = comment;
        this.commentTime = commentTime;
    }

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "house_id", nullable = false)
    public String getHouseId() {
        return houseId;
    }

    public void setHouseId(String houseId) {
        this.houseId = houseId;
    }

    @Basic
    @Column(name = "user_photo_url", nullable = false, length = 120)
    public String getUserPhotoUrl() {
        return userPhotoUrl;
    }

    public void setUserPhotoUrl(String userPhotoUrl) {
        this.userPhotoUrl = userPhotoUrl;
    }

    @Basic
    @Column(name = "username", nullable = false, length = 100)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "comment", nullable = false, length = 800)
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Basic
    @Column(name = "comment_time", nullable = false, length = 20)
    public String getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(String commentTime) {
        this.commentTime = commentTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserComment that = (UserComment) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(houseId, that.houseId) &&
                Objects.equals(userPhotoUrl, that.userPhotoUrl) &&
                Objects.equals(username, that.username) &&
                Objects.equals(comment, that.comment) &&
                Objects.equals(commentTime, that.commentTime);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, houseId, userPhotoUrl, username, comment, commentTime);
    }
}
