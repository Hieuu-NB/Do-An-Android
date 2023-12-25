package com.example.appdoctruyentranh.off.Fragmnet;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appdoctruyentranh.R;
import com.example.appdoctruyentranh.off.Adapter.AdapterTruyenCoTich;
import com.example.appdoctruyentranh.off.Adapter.AdapterTruyenCuoi;
import com.example.appdoctruyentranh.off.Model.TruyenCoTich;
import com.example.appdoctruyentranh.off.Model.TruyenCuoi;

import java.util.ArrayList;


public class TheLoaiFragment extends Fragment {

    RecyclerView mRecyclerViewTruyenCoTich ;
    RecyclerView mRecyclerViewtruyenCuoi;
    AdapterTruyenCoTich adapterTruyenCoTich;
    AdapterTruyenCuoi adapterTruyenCuoi;
    ArrayList<TruyenCoTich> arrayList;
    ArrayList<TruyenCuoi> list;
    public TheLoaiFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mRecyclerViewTruyenCoTich = view.findViewById(com.example.appdoctruyentranh.R.id.recy_view_truyen_co_tich);
        mRecyclerViewtruyenCuoi = view.findViewById(R.id.recy_view_truyen_cuoi);
        arrayList = new ArrayList<>();
        arrayList.add(new TruyenCoTich(1,R.drawable.truyen1,"",""));
        arrayList.add(new TruyenCoTich(2,R.drawable.truyen2,"",""));
        arrayList.add(new TruyenCoTich(3,R.drawable.truyen3,"",""));
        arrayList.add(new TruyenCoTich(4,R.drawable.truyen4,"",""));
        mRecyclerViewTruyenCoTich.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false));
        adapterTruyenCoTich = new AdapterTruyenCoTich(getActivity(),arrayList);
        mRecyclerViewTruyenCoTich.setAdapter(adapterTruyenCoTich);

        list = new ArrayList<>();
        list.add(new TruyenCuoi(R.drawable.truyencuoi1));
        list.add(new TruyenCuoi(R.drawable.truyencuoi2));
        list.add(new TruyenCuoi(R.drawable.truyencuoi3));
        list.add(new TruyenCuoi(R.drawable.truyencuoi4));
        adapterTruyenCuoi = new AdapterTruyenCuoi(getActivity(),list);
        mRecyclerViewtruyenCuoi.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false));
        mRecyclerViewtruyenCuoi.setAdapter(adapterTruyenCuoi);
    }
}