package com.example.bookstoreg3.model;

import android.graphics.drawable.Drawable;

import java.io.Serializable;

public class SanPhamMoi implements Serializable {
    Drawable hinhanh;
    String tensp;
    String giasp;

    public SanPhamMoi(Drawable hinhanh, String tensp, String giasp) {
        this.hinhanh = hinhanh;
        this.tensp = tensp;
        this.giasp = giasp;
    }

    public Drawable getHinhanh() {
        return hinhanh;
    }

    public void setHinhanh(Drawable hinhanh) {
        this.hinhanh = hinhanh;
    }

    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    public String getGiasp() {
        return giasp;
    }

    public void setGiasp(String giasp) {
        this.giasp = giasp;
    }
}
