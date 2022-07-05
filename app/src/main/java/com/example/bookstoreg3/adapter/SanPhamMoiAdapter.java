package com.example.bookstoreg3.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bookstoreg3.R;
import com.example.bookstoreg3.model.SanPhamMoi;

import java.util.ArrayList;

public class SanPhamMoiAdapter extends RecyclerView.Adapter<SanPhamMoiAdapter.MyHolder>{
    ArrayList<SanPhamMoi> sanPhamMoiArrayList;
    private itemClickListener mItemClickListener;

    public SanPhamMoiAdapter(ArrayList<SanPhamMoi> sanPhamMoiArrayList, itemClickListener clickListener) {
        this.sanPhamMoiArrayList = sanPhamMoiArrayList;
        this.mItemClickListener = clickListener;
    }

    @NonNull
    @Override
    public SanPhamMoiAdapter.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_sp_moi, parent, false);
        return new MyHolder(v, mItemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull SanPhamMoiAdapter.MyHolder holder, int position) {
        holder.itemsp_image.setImageDrawable(sanPhamMoiArrayList.get(position).getHinhanh());
        holder.itemsp_ten.setText(sanPhamMoiArrayList.get(position).getTensp());
        holder.itemsp_gia.setText(sanPhamMoiArrayList.get(position).getGiasp());
    }

    @Override
    public int getItemCount() {
        return sanPhamMoiArrayList.size();
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
