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

import java.util.ArrayList;

public class GioHangAdapter extends RecyclerView.Adapter<GioHangAdapter.MyHolder>{
    Context context;
    ArrayList<BookModel> cardItemList;

    public GioHangAdapter(Context context, ArrayList<BookModel> cardItemList) {
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
    public void onBindViewHolder(@NonNull GioHangAdapter.MyHolder holder, int position) {
        Glide.with(context).load(cardItemList.get(position).getBookImg()).into(holder.card_item_image);
        holder.card_item_name.setText(cardItemList.get(position).getBookName());
        holder.card_item_price.setText(Float.toString(cardItemList.get(position).getPrice()));
    }

    @Override
    public int getItemCount() {
        return cardItemList.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder{
        ImageView card_item_image;
        TextView card_item_name;
        TextView card_item_price;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            Context context = itemView.getContext();
            card_item_image = itemView.findViewById(R.id.item_giohang_image);
            card_item_name = itemView.findViewById(R.id.item_giohang_tensp);
            card_item_price = itemView.findViewById(R.id.item_giohang_gia);
        }
    }
}
