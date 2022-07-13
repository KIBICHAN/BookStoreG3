package com.example.bookstoreg3.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.bookstoreg3.R;
import com.example.bookstoreg3.model.BookModel;
import com.example.bookstoreg3.model.OrderDetail;
import com.example.bookstoreg3.service.BookService;

import java.util.ArrayList;

public class GioHangAdapter extends RecyclerView.Adapter<GioHangAdapter.MyHolder>{
    Context context;
    ArrayList<OrderDetail> cardItemList;

    public GioHangAdapter(Context context, ArrayList<OrderDetail> cardItemList) {
        this.context = context;
        this.cardItemList = cardItemList;
    }

    @NonNull
    @Override
    public GioHangAdapter.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_giohang, parent, false);
        return new MyHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        BookService bookService = new BookService();
        BookModel book = bookService.getBookByID(cardItemList.get(position).getBookID());
        Glide.with(context).load(book.getBookImg()).into(holder.card_item_image);
        String name = book.getBookName();
        holder.card_item_name.setText(name);
        holder.card_item_price.setText(Float.toString(book.getPrice()));
        holder.card_item_quantity.setText(Integer.toString(cardItemList.get(position).getQuantity()));
        holder.card_item_total.setText(Float.toString(cardItemList.get(position).getTotalUnit()));
    }

    @Override
    public int getItemCount() {
        return cardItemList.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder{
        ImageView card_item_image;
        TextView card_item_name;
        TextView card_item_price;
        TextView card_item_quantity;
        TextView card_item_total;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            Context context = itemView.getContext();
            card_item_image = itemView.findViewById(R.id.item_giohang_image);
            card_item_name = itemView.findViewById(R.id.item_giohang_tensp);
            card_item_price = itemView.findViewById(R.id.item_giohang_gia);
            card_item_quantity = itemView.findViewById(R.id.item_giohang_soluong);
            card_item_total = itemView.findViewById(R.id.item_giohang_giasp2);
        }
    }
}
