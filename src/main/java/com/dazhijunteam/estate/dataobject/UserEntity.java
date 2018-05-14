package com.dazhijunteam.estate.dataobject;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "user", schema = "EstateAnalysis", catalog = "")
public class UserEntity {
    private String userName;
    private String userId;
    private String userPassword;
    private String userNickname;
    private String userPhone;
    private String userResidence;

    @Basic
    @Column(name = "user_name", nullable = false, length = 20)
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Id
    @Column(name = "user_id", nullable = false, length = 30)
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "user_password", nullable = true, length = 20)
    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    @Basic
    @Column(name = "user_nickname", nullable = true, length = 20)
    public String getUserNickname() {
        return userNickname;
    }

    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname;
    }

    @Basic
    @Column(name = "user_phone", nullable = true, length = 20)
    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    @Basic
    @Column(name = "user_residence", nullable = true, length = 20)
    public String getUserResidence() {
        return userResidence;
    }

    public void setUserResidence(String userResidence) {
        this.userResidence = userResidence;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return Objects.equals(userName, that.userName) &&
                Objects.equals(userId, that.userId) &&
                Objects.equals(userPassword, that.userPassword) &&
                Objects.equals(userNickname, that.userNickname) &&
                Objects.equals(userPhone, that.userPhone) &&
                Objects.equals(userResidence, that.userResidence);
    }

    @Override
    public int hashCode() {

        return Objects.hash(userName, userId, userPassword, userNickname, userPhone, userResidence);
    }
}
