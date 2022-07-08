package com.example.bookstoreg3.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.bookstoreg3.R;
import com.example.bookstoreg3.model.BookModel;
import com.example.bookstoreg3.service.BookService;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ChiTietActivity extends AppCompatActivity {
    private ImageView iv_ic_cart_24;
    private ImageView imgBook;
    private TextView bookName,bookPrice,author,supperlier,publisher,datePublished,description,inventory,ratting;
    private Button btnthemvaogiohang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet);
        iv_ic_cart_24 = (ImageView) findViewById(R.id.iv_ic_cart_24);
        imgBook = (ImageView) findViewById(R.id.imgBookImg);
        bookName = (TextView) findViewById(R.id.tvBookName);
        bookPrice = (TextView) findViewById(R.id.tvBookPrice);
        author = (TextView) findViewById(R.id.tvAuthor);
        supperlier = (TextView) findViewById(R.id.tvSupperlier);
        publisher = (TextView) findViewById(R.id.tvPublisher);
        datePublished = (TextView) findViewById(R.id.tvDatePublished);
        description = (TextView) findViewById(R.id.tvDesc);
        inventory = (TextView) findViewById(R.id.tvInventory);
        SharedPreferences sharedPreferences = getSharedPreferences("bookID", MODE_PRIVATE);
        String id = sharedPreferences.getString("id", "");
        BookService service = new BookService();
        BookModel model = service.getBookByID(id);
        Glide.with(getApplicationContext()).load(model.getBookImg()).into(imgBook);
        bookName.setText(model.getBookName());
        bookPrice.setText(Float.toString(model.getPrice()));
        author.setText(model.getAuthor());
        supperlier.setText(model.getSupplier());
        publisher.setText(model.getPublisher());
        datePublished.setText(model.getDatePublished().toString());
        description.setText(model.getDescription());
        inventory.setText(Integer.toString(model.getStockQuantity()));

        iv_ic_cart_24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChiTietActivity.this, GioHangActivity.class);
                startActivity(intent);
            }
        });

        btnthemvaogiohang = (Button) findViewById(R.id.btnthemvaogiohang);
        btnthemvaogiohang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChiTietActivity.this, GioHangActivity.class);
                startActivity(intent);
            }
        });
    }
}
