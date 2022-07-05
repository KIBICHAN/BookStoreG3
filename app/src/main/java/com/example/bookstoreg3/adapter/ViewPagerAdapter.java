package com.example.bookstoreg3.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.bookstoreg3.fragment.MoiNhatFragment;
import com.example.bookstoreg3.fragment.ThinhHanhFragment;

import java.util.ArrayList;

public class ViewPagerAdapter extends FragmentStateAdapter {

    public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0: return new MoiNhatFragment();
            case 1: return new ThinhHanhFragment();
            default: return new MoiNhatFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
