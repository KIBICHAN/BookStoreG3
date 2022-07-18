package com.example.bookstoreg3.service;

import com.example.bookstoreg3.database.GetConnection;
import com.example.bookstoreg3.model.BookModel;
import com.example.bookstoreg3.model.Order;
import com.example.bookstoreg3.model.OrderDetail;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

public class OrderService {

    public OrderService() {
    }

    public Order CreateOrder(String userID) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy-HH:mm:ss");
        Order model = null;
        try{
            Connection conn = new GetConnection().getConn();
            if (conn != null){
                Date dateOrder = new Date();
                String orderID = userID+dateFormat.format(dateOrder).toString();
                float total = 0;
                java.sql.Date dateConvert = new java.sql.Date(dateOrder.getTime());
                String query1 = "INSERT INTO [BookManager].[dbo].[Order] (OrderID, Total, DateOrder, UserID, Status) VALUES ('" + orderID + "', 0, " + dateConvert + ", '"+ userID +"', -1)";
                Statement stm = conn.createStatement();
                if (stm.executeUpdate(query1) > 0) {
                    model = new Order(orderID, total, dateOrder, null, userID, -1);
                }
                stm.close();
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return model;
    }

    public Order GetOrderExist(String userID) {
        Order model = null;
        try{
            Connection conn = new GetConnection().getConn();
            if (conn != null) {
                String query1 = "SELECT * From [BookManager].[dbo].[Order] WHERE UserID = '" + userID + "' AND Status = -1";
                Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery(query1);
                if (rs.next()) {
                    Date date = new Date(rs.getDate("DateOrder").getTime());
                    model = new Order(
                            rs.getString("OrderID"),
                            rs.getFloat("Total"),
                            date,
                            userID,
                            -1,
                            null
                    );
                    return model;
                }
                rs.close();
                stm.close();
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public boolean UpdateOrder(String orderID, float total){
        try{
            Connection conn = new GetConnection().getConn();
            if (conn != null) {
                String query1 = "UPDATE [BookManager].[dbo].[Order] SET Status = 0 , Total = "+total+"   WHERE OrderID = '"+ orderID+"'";
                Statement stm = conn.createStatement();

                if (stm.executeUpdate(query1) > 0) {
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
