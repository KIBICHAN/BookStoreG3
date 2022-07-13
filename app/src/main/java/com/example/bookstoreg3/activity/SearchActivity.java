package com.example.bookstoreg3.activity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;

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

public class SearchActivity extends AppCompatActivity {
    Toolbar toolbar;
    RecyclerView recycleView_search;
    ArrayList<BookModel> list;
    BookAdapter adapter;
    EditText edtSearch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        edtSearch = (EditText) findViewById(R.id.edtsearch);
        toolbar = (Toolbar) findViewById(R.id.toobar);
        recycleView_search = (RecyclerView) findViewById(R.id.recycleview_search);
        edtSearch.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if ((keyEvent.getAction() == KeyEvent.ACTION_DOWN) &&
                        (i == KeyEvent.KEYCODE_ENTER)) {
                    // Perform action on key press
                    BookService service = new BookService();
                    list = service.getBookByName(edtSearch.getText().toString());
                    adapter = new BookAdapter(getApplicationContext(),list);
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(SearchActivity.this,LinearLayoutManager.VERTICAL, false);
                    recycleView_search.setLayoutManager(linearLayoutManager);
                    recycleView_search.setAdapter(adapter);
                    recycleView_search.setHasFixedSize(true);
                    return true;
                }
                return false;
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
