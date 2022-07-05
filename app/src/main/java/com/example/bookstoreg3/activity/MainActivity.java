package com.example.bookstoreg3.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

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
import com.example.bookstoreg3.adapter.ViewPagerAdapter;
import com.example.bookstoreg3.model.SanPhamMoi;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{
    private ViewFlipper viewlipper;
    Animation slidein, slideout;
    private EditText edt_timkiem;
    private ImageView iv_ic_cart_24;
    private TabLayout tabview;
    private ViewPager2 viewpager2;
    private ViewPagerAdapter viewPagerAdapter;

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

        viewlipper = (ViewFlipper) findViewById(R.id.viewlipper);
        slidein = AnimationUtils.loadAnimation(this, R.anim.slide_in_right);
        slideout = AnimationUtils.loadAnimation(this, R.anim.slide_out_right);
        viewlipper.setInAnimation(slidein);
        viewlipper.setOutAnimation(slideout);
        viewlipper.setFlipInterval(10000);
        viewlipper.setAutoStart(true);

        tabview = (TabLayout) findViewById(R.id.tabview);
        viewpager2 = (ViewPager2) findViewById(R.id.viewpager2);

        viewPagerAdapter = new ViewPagerAdapter(this);
        viewpager2.setAdapter(viewPagerAdapter);

        new TabLayoutMediator(tabview, viewpager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                switch (position){
                    case 0: tab.setText("Mới Nhất");
                        break;
                    case 1: tab.setText("Thịnh Hành");
                        break;
                }
            }
        }).attach();
    }
}