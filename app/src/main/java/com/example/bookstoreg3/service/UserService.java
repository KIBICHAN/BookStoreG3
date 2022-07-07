package com.example.bookstoreg3.service;

import com.example.bookstoreg3.database.GetConnection;
import com.example.bookstoreg3.model.UserModel;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class UserService {

    public UserService() {
    }

    public UserModel login(String gmail, String password) {
        UserModel user = null;
        try {
            Connection conn = new GetConnection().getConn();
            if (conn != null){
                String query = "select * from UserAccount where Gmail = '"+ gmail +"' AND Password = '"+ password +"' AND RoleID = 2";
                Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery(query);
                if (rs.next() == true) {
                    user = new UserModel(rs.getString("UserID"),
                            rs.getString("Name"),
                            rs.getString("Address"),
                            rs.getString("Phone"),
                            rs.getFloat("Money"),
                            rs.getString("Gmail"),
                            rs.getInt("RoleID"),
                            rs.getString("UserName"),
                            rs.getString("Password"),
                            rs.getBoolean("Gender"));
                }
                rs.close();
                stm.close();
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }
}
