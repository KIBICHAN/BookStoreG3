package com.example.bookstoreg3.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ViewFlipper;

import com.example.bookstoreg3.R;
import com.example.bookstoreg3.adapter.SanPhamMoiAdapter;
import com.example.bookstoreg3.model.SanPhamMoi;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements SanPhamMoiAdapter.itemClickListener{
    private ViewFlipper viewlipper;
    Animation slidein, slideout;
    private RecyclerView recyclerview;
    private SanPhamMoiAdapter sanPhamMoiAdapter;
    private EditText edt_timkiem;
    private ImageView iv_ic_cart_24;

    public MainActivity(){}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt_timkiem = (EditText) findViewById(R.id.edt_timkiem);
        edt_timkiem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SearchActivity.class);
                startActivity(intent);
            }
        });

        iv_ic_cart_24 = (ImageView) findViewById(R.id.iv_ic_cart_24);
        iv_ic_cart_24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, GioHangActivity.class);
                startActivity(intent);
            }
        });

        ArrayList<SanPhamMoi> SanPhamMoiData = new ArrayList<>();

        viewlipper = (ViewFlipper) findViewById(R.id.viewlipper);
        slidein = AnimationUtils.loadAnimation(this, R.anim.slide_in_right);
        slideout = AnimationUtils.loadAnimation(this, R.anim.slide_out_right);
        viewlipper.setInAnimation(slidein);
        viewlipper.setOutAnimation(slideout);
        viewlipper.setFlipInterval(10000);
        viewlipper.setAutoStart(true);

        recyclerview = (RecyclerView) findViewById(R.id.recyclerview);

        SanPhamMoi sanPhamMoi = new SanPhamMoi("https://m.media-amazon.com/images/I/41gr3r3FSWL.jpg", "BOOK COVER DESIGN", "42.000đ");
        SanPhamMoi sanPhamMoi1 = new SanPhamMoi("https://edit.org/images/cat/book-covers-big-2019101610.jpg", "MY BOOK COVER", "34.000đ");

        SanPhamMoiData.add(sanPhamMoi);
        SanPhamMoiData.add(sanPhamMoi1);

        sanPhamMoiAdapter = new SanPhamMoiAdapter(getApplicationContext(), SanPhamMoiData, this);

        recyclerview.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerview.setAdapter(sanPhamMoiAdapter);
    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(this, ChiTietActivity.class);
        startActivity(intent);
    }
}