package com.example.bookstoreg3.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bookstoreg3.R;
import com.example.bookstoreg3.database.GetConnection;
import com.example.bookstoreg3.service.UserService;

import java.sql.Connection;

public class DangNhapActivity extends AppCompatActivity {
    private TextView txtdangki;
    private Button btndangnhap;
    private EditText etgmail, etpassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_nhap);
        etgmail = (EditText) findViewById(R.id.email);
        etpassword = (EditText) findViewById(R.id.password);
        btndangnhap = (Button) findViewById(R.id.btndangnhap);
        UserService service = new UserService();
        btndangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String gmail = etgmail.getText().toString();
                String password = etpassword.getText().toString();
                if (service.login(gmail, password) != null) {
                    Intent intent = new Intent(DangNhapActivity.this, MainActivity.class);
                    startActivity(intent);
                }else {
                    //lam gi do
                }
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
