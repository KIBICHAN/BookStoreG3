package com.example.bookstoreg3.activity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager2.widget.ViewPager2;

import com.example.bookstoreg3.R;
import com.example.bookstoreg3.adapter.ViewPagerAdapter;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    Animation slidein, slideout;
    private ViewFlipper viewlipper;
    private EditText edt_timkiem;
    private ImageView iv_ic_cart_24, iv_ic_baseline_menu_24;
    private TabLayout tabview;
    private ViewPager2 viewpager2;
    private ViewPagerAdapter viewPagerAdapter;
    private DrawerLayout drawerLayout;

    public MainActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NavigationView mNavigationView = (NavigationView) findViewById(R.id.navigationView);

        if (mNavigationView != null) {
            mNavigationView.setNavigationItemSelectedListener(this);
        }

        edt_timkiem = (EditText) findViewById(R.id.edt_timkiem);
        edt_timkiem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SearchActivity.class);
                startActivity(intent);
            }
        });

        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);

        iv_ic_baseline_menu_24 = (ImageView) findViewById(R.id.iv_ic_baseline_menu_24);
        iv_ic_baseline_menu_24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
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
                switch (position) {
                    case 0:
                        tab.setText("Mới Nhất");
                        break;
                    case 1:
                        tab.setText("Thịnh Hành");
                        break;
                }
            }
        }).attach();
    }

    private boolean isPackageAvailable(String name) {
        boolean available = true;
        try {
            getPackageManager().getPackageInfo(name, 0);
        } catch (PackageManager.NameNotFoundException e) {
            available = false;
        }
        return available;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.nav_account) {
            Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
            startActivity(intent);
        }
        if (id == R.id.nav_sach) {
            Intent intent = new Intent(MainActivity.this, SachActivity.class);
            startActivity(intent);
        }
        if (id == R.id.nav_truyen) {
            Intent intent = new Intent(MainActivity.this, TruyenActivity.class);
            startActivity(intent);
        }
        if (id == R.id.nav_shop_loc) {
            Intent intent = new Intent(MainActivity.this, MapsActivity.class);
            startActivity(intent);
        }
        if (id == R.id.nav_logout) {
            finish();
        }
        if (id == R.id.nav_message) {
            if (isPackageAvailable("com.facebook.orca")) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setPackage("com.facebook.orca");
                intent.setData(Uri.parse("https://m.me/hoangson200015"));
                startActivity(intent);
            } else {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://m.me/hoangson200015"));
                startActivity(intent);
            }
        }
        return true;
    }
}