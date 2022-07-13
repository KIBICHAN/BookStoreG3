package com.example.bookstoreg3.model;

import java.util.ArrayList;
import java.util.Date;

public class Order {
    String orderID;
    float total;
    Date dateOreder;
    Date dateDelivery;
    String userID;
    int status;
    ArrayList<OrderDetail> orderDetails;

    public Order() {
    }

    public Order(String orderID, float total, Date dateOreder, String userID, int status, ArrayList<OrderDetail> orderDetails) {
        this.orderID = orderID;
        this.total = total;
        this.dateOreder = dateOreder;
        this.userID = userID;
        this.status = status;
        this.orderDetails = orderDetails;
    }

    public Order(String orderID, float total, Date dateOreder, Date dateDelivery, String userID, int status) {
        this.orderID = orderID;
        this.total = total;
        this.dateOreder = dateOreder;
        this.dateDelivery = dateDelivery;
        this.userID = userID;
        this.status = status;
    }

    public Order(String orderID, float total, Date dateOreder, Date dateDelivery, String userID, int status, ArrayList<OrderDetail> orderDetails) {
        this.orderID = orderID;
        this.total = total;
        this.dateOreder = dateOreder;
        this.dateDelivery = dateDelivery;
        this.userID = userID;
        this.status = status;
        this.orderDetails = orderDetails;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public Date getDateOreder() {
        return dateOreder;
    }

    public void setDateOreder(Date dateOreder) {
        this.dateOreder = dateOreder;
    }

    public Date getDateDelivery() {
        return dateDelivery;
    }

    public void setDateDelivery(Date dateDelivery) {
        this.dateDelivery = dateDelivery;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public ArrayList<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(ArrayList<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }
}
