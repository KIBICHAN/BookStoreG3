package com.example.bookstoreg3.model;

public class OrderDetail {
    String orderDetailID;
    String orderID;
    String bookID;
    int quantity;
    float totalUnit;

    public OrderDetail(String orderDetailID, String orderID, String bookID, int quantity, float totalUnit) {
        this.orderDetailID = orderDetailID;
        this.orderID = orderID;
        this.bookID = bookID;
        this.quantity = quantity;
        this.totalUnit = totalUnit;
    }

    public OrderDetail() {
    }

    public String getOrderDetailID() {
        return orderDetailID;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getBookID() {
        return bookID;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getTotalUnit() {
        return totalUnit;
    }

    public void setTotalUnit(float totalUnit) {
        this.totalUnit = totalUnit;
    }
}
