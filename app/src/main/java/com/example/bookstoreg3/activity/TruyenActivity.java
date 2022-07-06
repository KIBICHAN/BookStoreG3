package com.example.bookstoreg3.activity;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bookstoreg3.R;
import com.example.bookstoreg3.adapter.TruyenAdapter;
import com.example.bookstoreg3.model.Truyen;

import java.util.ArrayList;
import java.util.Objects;

public class TruyenActivity extends AppCompatActivity {
    Toolbar toolbar;
    RecyclerView recycleview_dt;
    ArrayList<Truyen> truyenArrayList;
    TruyenAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_truyen);

        toolbar = findViewById(R.id.toobar);
        recycleview_dt = findViewById(R.id.recycleview_dt);

        truyenArrayList = new ArrayList<>();
        adapter = new TruyenAdapter(getApplicationContext(), truyenArrayList);


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL, false);
        recycleview_dt.setLayoutManager(linearLayoutManager);
        recycleview_dt.setAdapter(adapter);
        recycleview_dt.setHasFixedSize(true);

        ActionToolBar();

        //auto gen demo
        for (int i = 1; i <= 10; i++) {
            truyenArrayList.add(new Truyen(
                    1,
                    "Manga",
                    "https://cdn0.fahasa.com/media/catalog/product/8/9/8936067598889.jpg",
                    "50000","sách coi cho vui",1));
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