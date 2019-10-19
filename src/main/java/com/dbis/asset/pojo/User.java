package com.dbis.asset.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author dsl
 * @date 2019/10/13 15:32
 * @description
 */
@Data
public class User implements Serializable {

    private Integer id;
    private String userName;
    private String userPassword;
    private String userNickname;
    private String userPhoneNo;    private String userGender;
    private String userMail;
    private String userBirthday;
    private Integer userState;
    private Integer userIsAdministrator;
    private String userSort;
    private String userDepartment;
    private String userPrivilege;
    private String userMotto;
    private String userHobby;
    private String userNewpassword;

//    private Device device;
/*
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserNickname() {
        return userNickname;
    }

    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname;
    }

    public String getUserPhoneNo() {
        return userPhoneNo;
    }

    public void setUserPhoneNo(String userPhoneNo) {
        this.userPhoneNo = userPhoneNo;
    }

    public String getUserGender() {
        return userGender;
    }

    public void setUserGender(String userGender) {
        this.userGender = userGender;
    }

    public String getUserMail() {
        return userMail;
    }

    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }

    public String getUserBirthday() {
        return userBirthday;
    }

    public void setUserBirthday(String userBirthday) {
        this.userBirthday = userBirthday;
    }

    public Integer getUserState() {
        return userState;
    }

    public void setUserState(Integer userState) {
        this.userState = userState;
    }

    public Integer getUserIsAdministrator() {
        return userIsAdministrator;
    }

    public void setUserIsAdministrator(Integer userIsAdministrator) {
        this.userIsAdministrator = userIsAdministrator;
    }

    public String getUserSort() {
        return userSort;
    }

    public void setUserSort(String userSort) {
        this.userSort = userSort;
    }

    public String getUserDepartment() {
        return userDepartment;
    }

    public void setUserDepartment(String userDepartment) {
        this.userDepartment = userDepartment;
    }

    public String getUserPrivilege() {
        return userPrivilege;
    }

    public void setUserPrivilege(String userPrivilege) {
        this.userPrivilege = userPrivilege;
    }

    public String getUserMotto() {
        return userMotto;
    }

    public void setUserMotto(String userMotto) {
        this.userMotto = userMotto;
    }

    public String getUserHobby() {
        return userHobby;
    }

    public void setUserHobby(String userHobby) {
        this.userHobby = userHobby;
    }

    public String getUserNewpassword() {
        return userNewpassword;
    }

    public void setUserNewpassword(String userNewpassword) {
        this.userNewpassword = userNewpassword;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userNickname='" + userNickname + '\'' +
                ", userPhoneNo='" + userPhoneNo + '\'' +
                ", userGender='" + userGender + '\'' +
                ", userMail='" + userMail + '\'' +
                ", userBirthday=" + userBirthday +
                ", userState=" + userState +
                ", userIsAdministrator=" + userIsAdministrator +
                ", userSort='" + userSort + '\'' +
                ", userDepartment='" + userDepartment + '\'' +
                ", userPrivilege='" + userPrivilege + '\'' +
                ", userMotto='" + userMotto + '\'' +
                ", userHobby='" + userHobby + '\'' +
                ", userNewpassword='" + userNewpassword + '\'' +
                '}';
    }*/
}
