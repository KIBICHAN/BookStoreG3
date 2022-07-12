package com.example.bookstoreg3.service;

import com.example.bookstoreg3.database.GetConnection;
import com.example.bookstoreg3.model.BookModel;
import com.example.bookstoreg3.model.Order;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class OrderService {

    public void Create(String userID) {

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date currentDate = new Date(); //Tue Jul 12 13:27:39 IST 2022

        try{
            Connection conn = new GetConnection().getConn();
            if (conn != null){
                String query1 = "INSERT INTO [BookManager].[dbo].[Order] VALUES ('"+formatter.format(currentDate) + userID+"', NULL, GETDATE()," +
                        " NULL, '"+userID+"', -1)";
                Statement stm = conn.createStatement();
                stm.executeUpdate(query1) ;
                stm.close();
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public String CheckOrder(String userID) {

        try{
            Connection conn = new GetConnection().getConn();
            if (conn != null){
                String query1 = "SELECT OrderID, From [BookManager].[dbo].[Order] WHERE UserID = "+userID+" " +
                        "AND Status =-1";
                Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery(query1);
                if (rs.next()) {
                    return rs.getString("OrderID");
                }
                stm.close();
                conn.close();
                rs.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
