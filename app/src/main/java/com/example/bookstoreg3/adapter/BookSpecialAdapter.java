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

public class BookSpecialAdapter extends RecyclerView.Adapter<BookSpecialAdapter.MyHolder>{
    Context context;
    ArrayList<BookModel> list;
    private itemClickListener mItemClickListener;

    public BookSpecialAdapter(Context context, ArrayList<BookModel> sanPhamMoiArrayList, itemClickListener clickListener) {
        this.context = context;
        this.list = sanPhamMoiArrayList;
        this.mItemClickListener = clickListener;
    }

    @NonNull
    @Override
    public BookSpecialAdapter.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_sp_moi, parent, false);
        return new MyHolder(v, mItemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull BookSpecialAdapter.MyHolder holder, int position) {
        Glide.with(context).load(list.get(position).getBookImg()).into(holder.itemsp_image);
        holder.itemsp_ten.setText(list.get(position).getBookName());
        holder.itemsp_gia.setText(Float.toString(list.get(position).getPrice()));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView itemsp_image;
        TextView itemsp_ten;
        TextView itemsp_gia;

        itemClickListener clickListener;

        public MyHolder(@NonNull View itemView, itemClickListener clickListener) {
            super(itemView);
            Context context = itemView.getContext();
            itemsp_image = itemView.findViewById(R.id.itemsp_image);
            itemsp_ten = itemView.findViewById(R.id.itemsp_ten);
            itemsp_gia = itemView.findViewById(R.id.itemsp_gia);

            this.clickListener = clickListener;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            clickListener.onItemClick(getAdapterPosition());
        }
    }
    public interface itemClickListener {
        void onItemClick(int position);
    }
}
