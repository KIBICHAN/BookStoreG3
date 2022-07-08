package com.example.bookstoreg3.service;

import com.example.bookstoreg3.database.GetConnection;
import com.example.bookstoreg3.model.BookModel;
import com.example.bookstoreg3.model.Order;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class OrderService {

    public boolean Create(String userID) {
        Order order = null;
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
