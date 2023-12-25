package com.example.appdoctruyentranh.off.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.appdoctruyentranh.R;
import com.example.appdoctruyentranh.off.Aciton.ItemClick;
import com.example.appdoctruyentranh.off.Model.TruyenCoTich;

import java.util.List;

public class AdapterDanhSachTruyen extends RecyclerView.Adapter<AdapterDanhSachTruyen.ViewhodelTruyenCoTich>{

    private Context context;
    private List<TruyenCoTich> list;
    private ItemClick itemClick;


    public AdapterDanhSachTruyen(Context context, List<TruyenCoTich> list, ItemClick itemClick) {
        this.context = context;
        this.list = list;
        this.itemClick = itemClick;
    }

    @NonNull
    @Override
    public ViewhodelTruyenCoTich onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_recy_danh_sach_truyen,null);
        return new ViewhodelTruyenCoTich(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewhodelTruyenCoTich holder, int position) {
        TruyenCoTich coTich = list.get(position);
        Glide.with(context).load(coTich.getImageAnhTruyen()).into(holder.image_anh);
        holder.txt_ten_truyen.setText(coTich.getTenTruyen());
        holder.click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemClick.ChiTietruyen(coTich);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewhodelTruyenCoTich extends RecyclerView.ViewHolder {
        ImageView image_anh;
        TextView txt_ten_truyen;
        TextView yeuThich;
        LinearLayout click;
        public ViewhodelTruyenCoTich(@NonNull View itemView) {
            super(itemView);
            image_anh = itemView.findViewById(R.id.image_anh_truyen);
            txt_ten_truyen = itemView.findViewById(R.id.txt_ten_truyen);
            yeuThich = itemView.findViewById(R.id.txt_yeu_thich);
            click = itemView.findViewById(R.id.linear_danh_sach_truyen);
        }
    }
}
