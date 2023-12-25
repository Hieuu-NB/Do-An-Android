package com.example.appdoctruyentranh.off.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.appdoctruyentranh.R;
import com.example.appdoctruyentranh.off.Model.TruyenCoTich;

import java.util.List;

public class AdapterChiTietTruyen extends RecyclerView.Adapter<AdapterChiTietTruyen.ViewHodelCTTruyen>{
    private Context context;
    private List<TruyenCoTich> list;

    public AdapterChiTietTruyen(Context context, List<TruyenCoTich> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHodelCTTruyen onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(com.example.appdoctruyentranh.R.layout.item_recy_view_chi_tiet_truyen,null);
        return new ViewHodelCTTruyen(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHodelCTTruyen holder, int position) {
            TruyenCoTich coTich = list.get(position);
        Glide.with(context).load(coTich.getImageAnhTruyen()).into(holder.image_anh_truyen);
        holder.txt_ten_truyen.setText(coTich.getTenTruyen());
        holder.txt_noi_dung_truyen.setText(coTich.getNoiDungTruyen());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHodelCTTruyen extends RecyclerView.ViewHolder{
        ImageView image_anh_truyen ;
        TextView txt_ten_truyen , txt_noi_dung_truyen;
        public ViewHodelCTTruyen(@NonNull View itemView) {
            super(itemView);
            image_anh_truyen = itemView.findViewById(R.id.image_ct_anh_truyen);
            txt_ten_truyen = itemView.findViewById(R.id.txt_ct_ten_truyen);
            txt_noi_dung_truyen = itemView.findViewById(R.id.txt_ct_noi_dung_truyen);
        }
    }
}
