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

public class MoiNhatFragment extends Fragment implements SanPhamMoiAdapter.itemClickListener{
    private RecyclerView recyclerview;
    private SanPhamMoiAdapter sanPhamMoiAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_moi_nhat, container, false);

        ArrayList<SanPhamMoi> SanPhamMoiData = new ArrayList<>();

        recyclerview = (RecyclerView) rootView.findViewById(R.id.recyclerview);

        SanPhamMoi sanPhamMoi = new SanPhamMoi("https://marketplace.canva.com/EAD7WuSVrt0/1/0/1003w/canva-colorful-illustration-young-adult-book-cover-LVthABb24ik.jpg", "HYPOCRITE WORLD", "62.000đ");
        SanPhamMoi sanPhamMoi1 = new SanPhamMoi("https://d1csarkz8obe9u.cloudfront.net/posterpreviews/action-thriller-book-cover-design-template-3675ae3e3ac7ee095fc793ab61b812cc_screen.jpg?ts=1637008457", "DRUG KING", "134.000đ");

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