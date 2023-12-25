package com.example.appdoctruyentranh.off;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appdoctruyentranh.R;
import com.example.appdoctruyentranh.off.Adapter.AdapterChiTietTruyen;
import com.example.appdoctruyentranh.off.Model.TruyenCoTich;

import java.util.ArrayList;

public class ChiTietTruyenActivity extends AppCompatActivity {

    Toolbar toolbar;
    ArrayList<TruyenCoTich> arrayList;
    AdapterChiTietTruyen adapterChiTietTruyen;
    RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.appdoctruyentranh.R.layout.activity_chi_tiet_truyen);
        toolbar = findViewById(R.id.toolbar_chi_tiet_truyen);
        mRecyclerView = findViewById(R.id.recy_view_ct_truyen);
        arrayList = new ArrayList<>();
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.icon_back);
        getSupportActionBar().setTitle("");

        Intent intent = getIntent();

        int id = intent.getIntExtra("_id",0);
        int anhTruyen = intent.getIntExtra("_anhTruyen",0);
        String tenTruyen = intent.getStringExtra("_tenTruyen");
        String noiDungTruyen = intent.getStringExtra("_noiDungTruyen");
        Log.d("TAG", "onCreate: " + id);
        arrayList.add(new TruyenCoTich(id,anhTruyen,tenTruyen,noiDungTruyen));
        adapterChiTietTruyen = new AdapterChiTietTruyen(this,arrayList);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this,RecyclerView.VERTICAL,false));
        mRecyclerView.setAdapter(adapterChiTietTruyen);

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case android.R.id.home:
                onBackPressed();
                return true;

            default:break;
        }

        return super.onOptionsItemSelected(item);
    }
}