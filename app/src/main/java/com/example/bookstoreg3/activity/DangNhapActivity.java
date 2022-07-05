package com.example.bookstoreg3.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bookstoreg3.R;

public class DangNhapActivity extends AppCompatActivity {
    private TextView txtdangki;
    private Button btndangnhap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_nhap);

        btndangnhap = (Button) findViewById(R.id.btndangnhap);
        btndangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DangNhapActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        txtdangki = (TextView) findViewById(R.id.txtdangki);
        txtdangki.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DangNhapActivity.this, DangKiActivity.class);
                startActivity(intent);
            }
        });
    }
}
