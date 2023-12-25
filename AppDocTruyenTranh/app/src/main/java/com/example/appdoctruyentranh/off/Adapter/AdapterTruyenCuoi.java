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
import com.example.appdoctruyentranh.off.Model.TruyenCuoi;

import java.util.List;

public class AdapterTruyenCuoi extends RecyclerView.Adapter<AdapterTruyenCuoi.ViewHodelTruyenCuoi>{
    private Context context;
    private List<TruyenCuoi> list;

    public AdapterTruyenCuoi(Context context, List<TruyenCuoi> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHodelTruyenCuoi onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(com.example.appdoctruyentranh.R.layout.item_recy_truyen_cuoi,null);
        return new ViewHodelTruyenCuoi(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHodelTruyenCuoi holder, int position) {
        TruyenCuoi truyenCuoi = list.get(position);
        Glide.with(context).load(truyenCuoi.getImageAnhTruyen()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHodelTruyenCuoi extends RecyclerView.ViewHolder{
        ImageView imageView;
        public ViewHodelTruyenCuoi(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_anh_truyen_cuoi);
        }
    }
}
