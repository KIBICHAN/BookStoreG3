package com.example.bookstoreg3.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bookstoreg3.R;
import com.example.bookstoreg3.activity.ChiTietActivity;
import com.example.bookstoreg3.adapter.SanPhamMoiAdapter;
import com.example.bookstoreg3.model.SanPhamMoi;

import java.util.ArrayList;

public class ThinhHanhFragment extends Fragment implements SanPhamMoiAdapter.itemClickListener{
    private RecyclerView recyclerview;
    private SanPhamMoiAdapter sanPhamMoiAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_thinh_hanh, container, false);

        ArrayList<SanPhamMoi> SanPhamMoiData = new ArrayList<>();

        recyclerview = (RecyclerView) rootView.findViewById(R.id.recyclerview);

        SanPhamMoi sanPhamMoi = new SanPhamMoi("https://m.media-amazon.com/images/I/41gr3r3FSWL.jpg", "COVER DESIGN", "42.000đ");
        SanPhamMoi sanPhamMoi1 = new SanPhamMoi("https://edit.org/images/cat/book-covers-big-2019101610.jpg", "MY BOOK COVER", "34.000đ");

        SanPhamMoiData.add(sanPhamMoi);
        SanPhamMoiData.add(sanPhamMoi1);

        sanPhamMoiAdapter = new SanPhamMoiAdapter(getContext(), SanPhamMoiData, this);

        recyclerview.setLayoutManager(new GridLayoutManager(getContext(), 2));
        recyclerview.setAdapter(sanPhamMoiAdapter);

        return rootView;
    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(getContext(), ChiTietActivity.class);
        startActivity(intent);
    }
}