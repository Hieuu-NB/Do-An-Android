package com.example.appdoctruyentranh.off.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.appdoctruyentranh.off.Fragmnet.HomeFragment;
import com.example.appdoctruyentranh.off.Fragmnet.TheLoaiFragment;


public class AdapterViewPage2 extends FragmentStateAdapter {

    public AdapterViewPage2(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new HomeFragment();
            case 1:
                return new TheLoaiFragment();
            default:
                return new HomeFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
