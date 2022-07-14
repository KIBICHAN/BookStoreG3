package com.example.bookstoreg3.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bookstoreg3.R;
import com.example.bookstoreg3.adapter.BookAdapter;
import com.example.bookstoreg3.adapter.GioHangAdapter;
import com.example.bookstoreg3.model.BookModel;
import com.example.bookstoreg3.model.OrderDetail;
import com.example.bookstoreg3.service.OrderDetailService;

import java.util.ArrayList;

public class GioHangActivity extends AppCompatActivity {
    private Button btnmuahang;
    private GioHangAdapter adapter;
    private TextView total;
    private RecyclerView recyclerviewgiohang;
    private float totalAll;
    ArrayList<OrderDetail> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gio_hang);
        new ItemTouchHelper(itemTouchHelperCallBack).attachToRecyclerView(recyclerviewgiohang);
        recyclerviewgiohang = findViewById(R.id.recyclerviewgiohang);
        OrderDetailService orderDetailService = new OrderDetailService();
        SharedPreferences orderUser = getSharedPreferences("orderUser", MODE_PRIVATE);
        String orderID = orderUser.getString("id", "");
        list = orderDetailService.GetAllOrderDetail(orderID);
        adapter = new GioHangAdapter(getApplicationContext(), list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL, false);
        recyclerviewgiohang.setLayoutManager(linearLayoutManager);
        recyclerviewgiohang.setAdapter(adapter);
        recyclerviewgiohang.setHasFixedSize(true);
        total = (TextView) findViewById(R.id.txttongtien);
        for (int i = 0; i < list.size(); i++) {
            totalAll = totalAll + list.get(i).getTotalUnit();
        }
        total.setText(Float.toString(totalAll));
        btnmuahang = (Button) findViewById(R.id.btnmuahang);
        btnmuahang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GioHangActivity.this, ThanhToanActivity.class);
                startActivity(intent);
            }
        });
    }
    ItemTouchHelper.SimpleCallback itemTouchHelperCallBack = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT | ItemTouchHelper.LEFT) {
        @Override
        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
            return false;
        }

        @Override
        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
            list.remove(viewHolder.getAdapterPosition());
            recyclerviewgiohang.notify();
        }
    };
}
