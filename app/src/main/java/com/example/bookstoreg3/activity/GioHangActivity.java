package com.example.bookstoreg3.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bookstoreg3.R;

public class GioHangActivity extends AppCompatActivity {
    private Button btnmuahang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gio_hang);

        btnmuahang = (Button) findViewById(R.id.btnmuahang);
        btnmuahang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GioHangActivity.this, ThanhToanActivity.class);
                startActivity(intent);
            }
        });
    }
}
