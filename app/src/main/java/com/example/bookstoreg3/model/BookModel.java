package com.example.bookstoreg3.model;

import java.util.Date;

public class BookModel {
    String bookID;
    String bookName;
    String Author;
    float price;
    String supplier;
    String publisher;
    int Inventory;
    int categoryID;
    String image;
    String ratting;
    Date datePublished;
    String description;

    public BookModel(String bookID, String bookName, String author, float price, String supplier, String publisher, int inventory, int categoryID, String image, String ratting, Date datePublished, String description) {
        this.bookID = bookID;
        this.bookName = bookName;
        Author = author;
        this.price = price;
        this.supplier = supplier;
        this.publisher = publisher;
        Inventory = inventory;
        this.categoryID = categoryID;
        this.image = image;
        this.ratting = ratting;
        this.datePublished = datePublished;
        this.description = description;
    }

    public BookModel() {
    }

    public String getBookID() {
        return bookID;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
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

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getRatting() {
        return ratting;
    }

    public void setRatting(String ratting) {
        this.ratting = ratting;
    }

    public Date getDatePublished() {
        return datePublished;
    }

    public void setDatePublished(Date datePublished) {
        this.datePublished = datePublished;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getInventory() {
        return Inventory;
    }

    public void setInventory(int inventory) {
        Inventory = inventory;
    }
}
