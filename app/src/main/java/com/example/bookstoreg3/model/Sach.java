package com.example.bookstoreg3.model;

import java.io.Serializable;

public class Sach implements Serializable {
    int id;
    String tensach;
    String hinhanh;
    String giasach;
    String mota;
    int loai;

    public Sach(int id, String tensach, String hinhanh, String giasach, String mota, int loai) {
        this.id = id;
        this.tensach = tensach;
        this.hinhanh = hinhanh;
        this.giasach = giasach;
        this.mota = mota;
        this.loai = loai;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTensach() {
        return tensach;
    }

    public void setTensach(String tensach) {
        this.tensach = tensach;
    }

    public String getHinhanh() {
        return hinhanh;
    }

    public void setHinhanh(String hinhanh) {
        this.hinhanh = hinhanh;
    }

    public String getGiasach() {
        return giasach;
    }

    public void setGiasach(String giasach) {
        this.giasach = giasach;
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
