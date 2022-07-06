package com.example.bookstoreg3.model;

import java.io.Serializable;

public class Truyen implements Serializable {
    int id;
    String tentruyen;
    String hinhanh;
    String giatruyen;
    String mota;
    int loai;

    public Truyen(int id, String tentruyen, String hinhanh, String giatruyen, String mota, int loai) {
        this.id = id;
        this.tentruyen = tentruyen;
        this.hinhanh = hinhanh;
        this.giatruyen = giatruyen;
        this.mota = mota;
        this.loai = loai;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTentruyen() {
        return tentruyen;
    }

    public void setTentruyen(String tentruyen) {
        this.tentruyen = tentruyen;
    }

    public String getHinhanh() {
        return hinhanh;
    }

    public void setHinhanh(String hinhanh) {
        this.hinhanh = hinhanh;
    }

    public String getGiatruyen() {
        return giatruyen;
    }

    public void setGiatruyen(String giatruyen) {
        this.giatruyen = giatruyen;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public int getLoai() {
        return loai;
    }

    public void setLoai(int loai) {
        this.loai = loai;
    }
}
