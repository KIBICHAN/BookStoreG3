package com.example.bookstoreg3.database;
import android.annotation.SuppressLint;
import android.os.StrictMode;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;

public class GetConnection {
    Connection conn;
    @SuppressLint("NewApi")
    public Connection getConn() {
        String ip="192.168.0.189",
        port="1433",
        db="BookManager",
        username="sa",
        password="123456789";
        StrictMode.ThreadPolicy sm = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(sm);
        String connURL = null;
        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            connURL = "jdbc:jtds:sqlserver://" + ip + ":" + port + ";databasename=" + db + ";user=" + username + ";"+"password=" + password + ";";
            conn = DriverManager.getConnection(connURL);
        }catch (Exception e) {
            Log.e("Error is", e.getMessage());
        }
        return conn;
    }
}
