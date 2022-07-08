package com.example.bookstoreg3.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bookstoreg3.R;

public class ChiTietActivity extends AppCompatActivity {
    private ImageView iv_ic_cart_24;
    private Button btnthemvaogiohang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet);
        iv_ic_cart_24 = (ImageView) findViewById(R.id.iv_ic_cart_24);
        Intent intent = new Intent();
        String id = intent.getStringExtra("id");
        iv_ic_cart_24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChiTietActivity.this, GioHangActivity.class);
                startActivity(intent);
            }
        });

        btnthemvaogiohang = (Button) findViewById(R.id.btnthemvaogiohang);
        btnthemvaogiohang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChiTietActivity.this, GioHangActivity.class);
                startActivity(intent);
            }
        });
    }
}
