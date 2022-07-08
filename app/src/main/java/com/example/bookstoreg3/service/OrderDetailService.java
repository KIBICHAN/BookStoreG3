package com.example.bookstoreg3.service;

import com.example.bookstoreg3.database.GetConnection;

import java.sql.Connection;
import java.sql.Statement;

public class OrderDetailService {

    public boolean CreateOrderDetail (String orderID, String bookID) {
        OrderService orderDetail = null;
        try{
            Connection conn = new GetConnection().getConn();
            if (conn != null){
                String query = "";
                Statement stm = conn.createStatement();
                if (stm.executeUpdate(query) > 0) {
                    return true;
                }
                stm.close();
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
