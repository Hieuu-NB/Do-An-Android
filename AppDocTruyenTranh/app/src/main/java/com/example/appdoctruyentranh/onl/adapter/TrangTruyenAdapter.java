package com.example.appdoctruyentranh.onl.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.example.appdoctruyentranh.R;
import com.example.appdoctruyentranh.onl.object.TrangTruyenOnl;

import java.util.ArrayList;
import java.util.List;

public class TrangTruyenAdapter extends ArrayAdapter<TrangTruyenOnl> {

    private Context ct;
    private ArrayList<TrangTruyenOnl> arr;
    public TrangTruyenAdapter(@NonNull Context context, int resource, @NonNull List<TrangTruyenOnl> objects) {
        super(context, resource,objects);
        this.ct = context;
        this.arr = new ArrayList<>(objects);
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null){
            LayoutInflater inflater = (LayoutInflater) ct.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_trang_truyen,null);

        }
        if (arr.size() > 0 ){
            TrangTruyenOnl trangTruyenOnl = this.arr.get(position);

            ImageView imgTrangTruyen = convertView.findViewById(R.id.imgTrangTruyen);


            Glide.with(this.ct).load(trangTruyenOnl.getLinkTrangTruyen())
                    .listener(new RequestListener<Drawable>() {
                        @Override
                        public boolean onLoadFailed(@Nullable GlideException e, @Nullable Object model, @NonNull com.bumptech.glide.request.target.Target<Drawable> target, boolean isFirstResource) {
                            Log.e("GlideError", "Load failed :", e);
                            return false;
                        }

                        @Override
                        public boolean onResourceReady(@NonNull Drawable resource, @NonNull Object model, com.bumptech.glide.request.target.Target<Drawable> target, @NonNull DataSource dataSource, boolean isFirstResource) {
                            return false;
                        }
                    })
                    .into(imgTrangTruyen);
        }
        return  convertView;
    }
}














