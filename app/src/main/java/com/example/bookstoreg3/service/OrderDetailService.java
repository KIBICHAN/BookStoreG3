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
                orderDetailArrayList = new ArrayList<>();
                String query = "SELECT * From OrderDetail WHERE OrderID = '" + orderId + "'";
                Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery(query);
                while (rs.next()) {
                    orderDetailArrayList.add(
                            new OrderDetail (
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

    public OrderDetail GetOrderDetailByID(String orderId, String bookID) {
        OrderDetail orderDetail = null;
        try {
            Connection conn = new GetConnection().getConn();
            if (conn != null) {
                String query = "SELECT * From OrderDetail WHERE OrderID = '" + orderId + "' AND BookID = '" + bookID + "'";
                Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery(query);
                while (rs.next()) {
                    orderDetail = new OrderDetail(
                            rs.getString("OrderDetailID"),
                            rs.getString("OrderID"),
                            rs.getString("BookID"),
                            rs.getInt("Quantity"),
                            rs.getFloat("TotalUnit")
                    );
                }
                rs.close();
                stm.close();;
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return orderDetail;
    }

    public OrderDetail GetOrderDetailByOrderDetailID(String orderDetailId) {
        OrderDetail orderDetail = null;
        try {
            Connection conn = new GetConnection().getConn();
            if (conn != null) {
                String query = "SELECT * From OrderDetail WHERE OrderDetailID = '" + orderDetailId + "'";
                Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery(query);
                while (rs.next()) {
                    orderDetail = new OrderDetail(
                            rs.getString("OrderDetailID"),
                            rs.getString("OrderID"),
                            rs.getString("BookID"),
                            rs.getInt("Quantity"),
                            rs.getFloat("TotalUnit")
                    );
                }
                rs.close();
                stm.close();;
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return orderDetail;
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
    public boolean UpdateOrderDetail(String orderDetaileID, int quantity, float price) {

        try {
            Connection conn = new GetConnection().getConn();
            if (conn != null) {
                float total = quantity * price;
                String query = "UPDATE OrderDetail Set Quantity = " + quantity + ", TotalUnit = " + total + " Where OrderDetailID = '" + orderDetaileID + "' ";
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
