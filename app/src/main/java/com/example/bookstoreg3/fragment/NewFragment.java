package com.example.bookstoreg3.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bookstoreg3.R;
import com.example.bookstoreg3.activity.ChiTietActivity;
import com.example.bookstoreg3.adapter.BookSpecialAdapter;
import com.example.bookstoreg3.model.BookModel;
import com.example.bookstoreg3.service.BookService;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class NewFragment extends Fragment implements BookSpecialAdapter.itemClickListener{
    private RecyclerView recyclerview;
    private BookSpecialAdapter bookSpecialAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        BookService service = new BookService();
        View rootView = inflater.inflate(R.layout.fragment_new, container, false);
        ArrayList<BookModel> bookSpecialList = new ArrayList<>();
        bookSpecialList = service.getNewBook(Calendar.getInstance().get(Calendar.YEAR));
        recyclerview = (RecyclerView) rootView.findViewById(R.id.recyclerview);
        bookSpecialAdapter = new BookSpecialAdapter(getContext(), bookSpecialList, this);
        recyclerview.setLayoutManager(new GridLayoutManager(getContext(), 2));
        recyclerview.setAdapter(bookSpecialAdapter);

        return rootView;
    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(getContext(), ChiTietActivity.class);
        startActivity(intent);
    }
}