package com.example.bookstoreg3.model;

import android.graphics.drawable.Drawable;

import java.io.Serializable;
import java.util.Date;

public class BookModel implements Serializable {
    String bookID;
    String bookImg;
    String bookName;
    float price;
    String author;
    String supplier;
    String publisher;
    Date datePublished;
    int stockQuantity;
    int categoryId;
    int rating;
    String description;

    public BookModel() {}

    public BookModel(String bookID, String bookImg, String bookName, float price) {
        this.bookID = bookID;
        this.bookImg = bookImg;
        this.bookName = bookName;
        this.price = price;
    }

    public BookModel(String bookID, String bookImg, String bookName, float price, String description) {
        this.bookID = bookID;
        this.bookImg = bookImg;
        this.bookName = bookName;
        this.price = price;
        this.description = description;
    }

    public BookModel(String bookID, String bookImg, String bookName, float price, String author, String supplier, String publisher, Date datePublished, int stockQuantity, int rating, String description) {
        this.bookID = bookID;
        this.bookImg = bookImg;
        this.bookName = bookName;
        this.price = price;
        this.author = author;
        this.supplier = supplier;
        this.publisher = publisher;
        this.datePublished = datePublished;
        this.stockQuantity = stockQuantity;
        this.rating = rating;
        this.description = description;
    }

    public BookModel(String bookID, String bookImg, String bookName, float price, String author, String supplier, String publisher, Date datePublished, int stockQuantity, int categoryId, int rating, String description) {
        this.bookID = bookID;
        this.bookImg = bookImg;
        this.bookName = bookName;
        this.price = price;
        this.author = author;
        this.supplier = supplier;
        this.publisher = publisher;
        this.datePublished = datePublished;
        this.stockQuantity = stockQuantity;
        this.categoryId = categoryId;
        this.rating = rating;
        this.description = description;
    }

    public String getBookID() {
        return bookID;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
    }

    public String getBookImg() {
        return bookImg;
    }

    public void setBookImg(String bookImg) {
        this.bookImg = bookImg;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Date getDatePublished() {
        return datePublished;
    }

    public void setDatePublished(Date datePublished) {
        this.datePublished = datePublished;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
