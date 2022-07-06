package com.example.bookstoreg3.activity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bookstoreg3.R;
import com.example.bookstoreg3.adapter.SachAdapter;
import com.example.bookstoreg3.model.Sach;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SachActivity extends AppCompatActivity {
    Toolbar toolbar;
    RecyclerView recycleview_dt;
    List<Sach> sachArrayList;
    SachAdapter adapter;
    Handler handler = new Handler();
    boolean isLoading = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sach);

        toolbar = findViewById(R.id.toobar);
        recycleview_dt = findViewById(R.id.recycleview_dt);

        adapter = new SachAdapter(getApplicationContext(), sachArrayList);
        sachArrayList = new ArrayList<>();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL, false);
        recycleview_dt.setLayoutManager(linearLayoutManager);
        recycleview_dt.setAdapter(adapter);
        recycleview_dt.setHasFixedSize(true);

        ActionToolBar();

        //auto gen demo
        for (int i = 1; i <= 10; i++) {
            sachArrayList.add(new Sach(
                            1,
                            "Android",
                            "https://cdn0.fahasa.com/media/catalog/product/i/m/image_195509_1_50093.jpg",
                            "50000","sách dạy học",1));
        }
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
