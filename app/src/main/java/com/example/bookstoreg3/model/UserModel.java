package com.example.bookstoreg3.model;

import java.io.Serializable;

public class UserModel implements Serializable {
    String userID;
    String name;
    String address;
    String phone;
    float money;
    String gmail;
    int roleID;
    String userName;
    String password;
    boolean gender;

    public UserModel(String userID, String name, String address, String phone, float money, String gmail, int roleID, String userName, String password, boolean gender) {
        this.userID = userID;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.money = money;
        this.gmail = gmail;
        this.roleID = roleID;
        this.userName = userName;
        this.password = password;
        this.gender = gender;
    }

    public UserModel() {
    }

    public String getUserID() {
        return userID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public float getMoney() {
        return money;
    }

    public void setMoney(float money) {
        this.money = money;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public int getRoleID() {
        return roleID;
    }

    public void setRoleID(int roleID) {
        this.roleID = roleID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }
}
