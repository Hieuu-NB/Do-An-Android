package com.example.appdoctruyentranh.off.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;
import com.example.appdoctruyentranh.R;
import com.example.appdoctruyentranh.off.Model.ListAnh;

import java.util.List;

public class AdapterViewPage extends PagerAdapter {

    private Context context;
    private List<ListAnh> list;

    public AdapterViewPage(Context context, List<ListAnh> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = LayoutInflater.from (container.getContext ()).inflate (R.layout.item_list_chuyen_anh,container,false);
        ImageView imageView = view.findViewById (com.example.appdoctruyentranh.R.id.image_slide1);

        ListAnh listAnh = list.get (position);
        Glide.with (context).load (listAnh.getImageAnh()).into (imageView);

        container.addView (view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView ((View) object);
    }

}
