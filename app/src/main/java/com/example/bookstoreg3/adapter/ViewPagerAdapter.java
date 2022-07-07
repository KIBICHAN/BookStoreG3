package com.example.bookstoreg3.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.bookstoreg3.fragment.NewFragment;
import com.example.bookstoreg3.fragment.RattingFragment;

public class ViewPagerAdapter extends FragmentStateAdapter {

    public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0: return new NewFragment();
            case 1: return new RattingFragment();
            default: return new NewFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
