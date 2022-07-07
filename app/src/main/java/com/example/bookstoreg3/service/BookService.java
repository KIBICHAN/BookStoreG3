package com.example.bookstoreg3.service;

import com.example.bookstoreg3.database.GetConnection;
import com.example.bookstoreg3.model.BookModel;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class BookService {

    public ArrayList<BookModel> getCategoryBook(String categoryName) {
        ArrayList<BookModel> listBookCategory = null;
        try{
            Connection conn = new GetConnection().getConn();
            if (conn != null){
                String query = "select * from Book where CategoryID = (select CategoryID from Category Where CategoryName = '"+ categoryName +"') ";
                Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery(query);
                listBookCategory = new ArrayList<>();
                while (rs.next()){
                    String id = rs.getString("BookID");
                    String img = rs.getString("Image");
                    String name = rs.getString("BookName");
                    float price = rs.getFloat("Price");
                    String description = rs.getString("Description");
                    BookModel model = new BookModel(id, img, name, price, description);
                    listBookCategory.add(model);
                }
                rs.close();
                stm.close();
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listBookCategory;
    }

    public ArrayList<BookModel> getNewBook(int year) {
        ArrayList<BookModel> listBook = null;
        try{
            Connection conn = new GetConnection().getConn();
            if (conn != null){
                String query = "select top 5 * from Book where YEAR(DatePublished) = "+ year +" order by DatePublished desc";
                Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery(query);
                listBook = new ArrayList<>();
                while (rs.next()){
                    String id = rs.getString("BookID");
                    String img = rs.getString("Image");
                    String name = rs.getString("BookName");
                    float price = rs.getFloat("Price");
                    BookModel model = new BookModel(id, img, name, price);
                    listBook.add(model);
                }
                rs.close();
                stm.close();
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listBook;
    }

    public ArrayList<BookModel> getPopularBook(int rating) {
        ArrayList<BookModel> listBook = null;
        try{
            Connection conn = new GetConnection().getConn();
            if (conn != null){
                String query = "select * from Book where Ratting = "+ rating +"";
                Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery(query);
                listBook = new ArrayList<>();
                while (rs.next()){
                    String id = rs.getString("BookID");
                    String img = rs.getString("Image");
                    String name = rs.getString("BookName");
                    float price = rs.getFloat("Price");
                    BookModel model = new BookModel(id, img, name, price);
                    listBook.add(model);
                }
                rs.close();
                stm.close();
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listBook;
    }
}
