package com.example.appdoctruyentranh.off.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.appdoctruyentranh.R;
import com.example.appdoctruyentranh.off.Model.TruyenCoTich;

import java.util.List;

public class AdapterTruyenCoTich extends RecyclerView.Adapter<AdapterTruyenCoTich.ViewHodelTruyenCoTich1>{
    private Context context;
    private List<TruyenCoTich> list;

    public AdapterTruyenCoTich(Context context, List<TruyenCoTich> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHodelTruyenCoTich1 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(com.example.appdoctruyentranh.R.layout.item_recy_truyen_co_tich,null);
        return new ViewHodelTruyenCoTich1(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHodelTruyenCoTich1 holder, int position) {
        TruyenCoTich coTich = list.get(position);
        Glide.with(context).load(coTich.getImageAnhTruyen()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHodelTruyenCoTich1 extends RecyclerView.ViewHolder{
        ImageView imageView;
        public ViewHodelTruyenCoTich1(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_anh_truyen_co_tich);
        }
    }
}
