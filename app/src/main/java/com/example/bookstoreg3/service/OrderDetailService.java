package com.example.bookstoreg3.service;

import com.example.bookstoreg3.database.GetConnection;
import com.example.bookstoreg3.model.OrderDetail;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class OrderDetailService {

    public ArrayList<OrderDetail> GetAllOrderDetail(String orderId){
        ArrayList<OrderDetail> orderDetailArrayList = null;

        try{
            Connection conn = new GetConnection().getConn();
            if(conn!=null){
                String query = "SELECT * From OrderDetail WHERE OrderID = '"+orderId+"'";
                Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery(query);
                while (rs.next()){
                    orderDetailArrayList.add(new OrderDetail(rs.getString("OrderDetailID"),
                                                             rs.getString("OrderID"),
                                                             rs.getString("BookID"),
                                                             rs.getInt("Quantity"),
                                                             rs.getFloat("TotalUnit")));
                }
                return orderDetailArrayList;
            }


        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void CreateOrderDetail (String orderID, String bookID, int quantity, float price) {
        float total = price * quantity;
        OrderService orderDetail = null;

        try{
            Connection conn = new GetConnection().getConn();
            if (conn != null){
                String query = "INSERT INTO OrderDetail VALUES ('"+ orderID + bookID+"', '"+orderID+"', " +
                        " '"+bookID+"', "+quantity+", "+total+")";
                Statement stm = conn.createStatement();
                stm.executeUpdate(query) ;
                stm.close();
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void CheckDuplicateOrderDetail (String orderID, String bookID) {

        OrderService orderDetail = null;

        try{
            Connection conn = new GetConnection().getConn();
            if (conn != null){
                String query = "UPDATE OrderDetail \n" +
                        "Set Quantity=Quantity+1\n" +
                        "Where OrderID ='"+orderID+"' AND BookID ='"+bookID+"'";
                Statement stm = conn.createStatement();
                stm.executeUpdate(query);
                stm.close();
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void setQuantityOrderDetail (String orderDetailID,  int quantity, float price) {
        float total = price * quantity;
        OrderService orderDetail = null;

        try{
            Connection conn = new GetConnection().getConn();
            if (conn != null){
                String query = "UPDATE OrderDetail \n" +
                        "Set Quantity="+quantity+", TotalUnit = "+total+"\n" +
                        "Where OrderDetailID ='"+orderDetailID+"'";
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
