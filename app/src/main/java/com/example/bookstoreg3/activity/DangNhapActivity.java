package com.example.bookstoreg3.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bookstoreg3.R;
import com.example.bookstoreg3.database.GetConnection;
import com.example.bookstoreg3.model.UserModel;
import com.example.bookstoreg3.service.UserService;

import java.sql.Connection;

public class DangNhapActivity extends AppCompatActivity {
    private TextView txtdangki, tvNoti;
    private Button btndangnhap;
    private EditText etgmail, etpassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_nhap);
        etgmail = (EditText) findViewById(R.id.email);
        etpassword = (EditText) findViewById(R.id.password);
        btndangnhap = (Button) findViewById(R.id.btndangnhap);
        tvNoti = (TextView) findViewById(R.id.tvNoti);
        UserService service = new UserService();
        btndangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String gmail = etgmail.getText().toString();
                String password = etpassword.getText().toString();
                UserModel user = service.login(gmail, password);
                if (user != null) {
                    SharedPreferences sharedPreferences = getSharedPreferences("Account", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("id", user.getUserID());
                    editor.putString("name", user.getName());
                    editor.putString("address", user.getAddress());
                    editor.putString("phone", user.getPhone());
                    editor.putFloat("money", user.getMoney());
                    editor.putString("gmail", user.getGmail());
                    editor.putInt("role", user.getRoleID());
                    editor.putString("username", user.getUserName());
                    editor.putString("password", user.getPassword());
                    editor.putBoolean("gender", user.isGender());
                    editor.commit();
                    Intent intent = new Intent(DangNhapActivity.this, MainActivity.class);
                    startActivity(intent);
                } else {
                    tvNoti.setText("Sai tài khoản hoặc mật khẩu!");
                    etgmail.setText("");
                    etpassword.setText("");

                    etgmail.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            tvNoti.setText("");
                        }
                    });
                    etpassword.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            tvNoti.setText("");
                        }
                    });
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
