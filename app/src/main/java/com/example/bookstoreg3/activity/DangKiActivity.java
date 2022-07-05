package com.example.bookstoreg3.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bookstoreg3.R;

public class DangKiActivity extends AppCompatActivity {
    private TextView txtdangki;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_ki);

        txtdangki = (TextView) findViewById(R.id.txtdangki);
        txtdangki.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DangKiActivity.this, DangNhapActivity.class);
                startActivity(intent);
            }
        });
    }
}
