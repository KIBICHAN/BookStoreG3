package com.example.bookstoreg3.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bookstoreg3.R;
import com.example.bookstoreg3.adapter.BookAdapter;
import com.example.bookstoreg3.model.BookModel;
import com.example.bookstoreg3.service.BookService;

import java.util.ArrayList;
import java.util.Objects;

public class BookCategoryActivity extends AppCompatActivity {
    Toolbar toolbar;
    RecyclerView recycleview_dt;
    ArrayList<BookModel> list;
    BookAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_category);
        toolbar = findViewById(R.id.toobar);
        recycleview_dt = findViewById(R.id.recycleview_dt);
        Intent intent = getIntent();
        String categoryName = intent.getStringExtra("name");
        BookService service = new BookService();
        list = service.getCategoryBook(categoryName);
        adapter = new BookAdapter(getApplicationContext(), list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL, false);
        recycleview_dt.setLayoutManager(linearLayoutManager);
        recycleview_dt.setAdapter(adapter);
        recycleview_dt.setHasFixedSize(true);
        ActionToolBar();
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