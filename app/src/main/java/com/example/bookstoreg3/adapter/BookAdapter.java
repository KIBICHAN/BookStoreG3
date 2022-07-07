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
import com.example.bookstoreg3.model.BookModel;

import java.util.ArrayList;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BookHolder>{
    ArrayList<BookModel> bookModels;

    public BookAdapter(ArrayList<BookModel> bookModel) {
        this.bookModels = bookModel;
    }

    @NonNull
    @Override
    public BookAdapter.BookHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_chi_tiet, parent, false);
        return new BookHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull BookHolder holder, int position) {
        holder.bookName.setText(bookModels.get(position).getBookName());
        holder.bookPrice.setText((int) bookModels.get(position).getPrice());
        holder.author.setText(bookModels.get(position).getAuthor());
        holder.supplier.setText(bookModels.get(position).getSupplier());
        holder.publisher.setText(bookModels.get(position).getPublisher());
        holder.datePublished.setText(bookModels.get(position).getDatePublished().toString());
        holder.rating.setText(bookModels.get(position).getRating());
        holder.description.setText(bookModels.get(position).getDescription());

    }

    @Override
    public int getItemCount() {
        return bookModels.size();
    }

    public class BookHolder extends RecyclerView.ViewHolder{
        ImageView bookImg;
        TextView bookName, bookPrice, author, supplier, publisher, datePublished, rating, description;


        public BookHolder(@NonNull View itemView) {
            super(itemView);
            Context context = itemView.getContext();
            bookImg = itemView.findViewById(R.id.imgBookImg);
            bookName = itemView.findViewById(R.id.tvBookName);
            bookPrice = itemView.findViewById(R.id.tvBookPrice);
            author = itemView.findViewById(R.id.tvAuthor);
            supplier = itemView.findViewById(R.id.tvSupperlier);
            publisher = itemView.findViewById(R.id.tvPublisher);
            datePublished = itemView.findViewById(R.id.tvDatePublished);
            rating = itemView.findViewById(R.id.tvRating);
            description = itemView.findViewById(R.id.tvDesc);
        }
    }
}
