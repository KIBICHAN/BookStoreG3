package com.example.bookstoreg3.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.bookstoreg3.R;
import com.example.bookstoreg3.service.OrderService;

import java.util.Objects;

public class ThanhToanActivity extends AppCompatActivity {
    TextView txtTotal, txtEmail, txtPhone;
    Button btnDatHang;
    Toolbar toolbar;
    OrderService orderService = new OrderService();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thanh_toan);
        txtTotal= (TextView) findViewById(R.id.txttongtien);
        txtEmail= (TextView) findViewById(R.id.txtemail);
        txtPhone= (TextView) findViewById(R.id.txtsodienthoai);
        btnDatHang= (Button) findViewById(R.id.btndathang);
        toolbar = (Toolbar) findViewById(R.id.toobar);
        SharedPreferences totalSP = getSharedPreferences("totalMoney", MODE_PRIVATE);


        String totalS = totalSP.getString("total", "");
        float total = Float.parseFloat(totalS);
        SharedPreferences sharedPreferences = getSharedPreferences("Account", MODE_PRIVATE);
        SharedPreferences orderUser = getSharedPreferences("orderUser", MODE_PRIVATE);
        String orderID = orderUser.getString("id", "");
        txtTotal.setText(totalS);
        txtPhone.setText(sharedPreferences.getString("phone",""));
        txtEmail.setText(sharedPreferences.getString("gmail", ""));
        btnDatHang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (orderService.UpdateOrder(orderID,total)){
                    Toast.makeText(ThanhToanActivity.this, "dat hang thanh cong", Toast.LENGTH_SHORT).show();
                    Intent intentH = new Intent(ThanhToanActivity.this, MainActivity.class);
                    startActivity(intentH);
                }
            }
        });
        ActionToolBar ();
    }
    private void ActionToolBar () {
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
