package com.example.bookstoreg3.service;

import com.example.bookstoreg3.database.GetConnection;
import com.example.bookstoreg3.model.OrderDetail;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class OrderDetailService {

    public OrderDetailService() {
    }

    public ArrayList<OrderDetail> GetAllOrderDetail(String orderId) {
        ArrayList<OrderDetail> orderDetailArrayList = null;
        try {
            Connection conn = new GetConnection().getConn();
            if (conn != null) {
                String query = "SELECT * From OrderDetail WHERE OrderID = '" + orderId + "'";
                Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery(query);
                while (rs.next()) {
                    orderDetailArrayList.add(
                            new OrderDetail(
                                    rs.getString("OrderDetailID"),
                                    rs.getString("OrderID"),
                                    rs.getString("BookID"),
                                    rs.getInt("Quantity"),
                                    rs.getFloat("TotalUnit")
                            )
                    );
                }
                rs.close();
                stm.close();;
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return orderDetailArrayList;
    }

    public OrderDetail CreateOrderDetail(String orderID, String bookID, int quantity, float price) {
        OrderDetail orderDetail = null;
        try {
            Connection conn = new GetConnection().getConn();
            if (conn != null) {
                float total = price * quantity;
                String orderDetailID = orderID + bookID;
                String query = "INSERT INTO OrderDetail VALUES ('" + orderDetailID + "', '" + orderID + "', '" + bookID + "', " + quantity + ", " + total + ")";
                Statement stm = conn.createStatement();
                if (stm.executeUpdate(query) > 0) {
                    orderDetail = new OrderDetail(orderDetailID, orderID, bookID, quantity, total);
                }
                stm.close();
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return orderDetail;
    }

    public void CheckDuplicateOrderDetail(String orderID, String bookID) {

        OrderService orderDetail = null;

        try {
            Connection conn = new GetConnection().getConn();
            if (conn != null) {
                String query = "UPDATE OrderDetail \n" +
                        "Set Quantity=Quantity+1\n" +
                        "Where OrderID ='" + orderID + "' AND BookID ='" + bookID + "'";
                Statement stm = conn.createStatement();
                stm.executeUpdate(query);
                stm.close();
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
