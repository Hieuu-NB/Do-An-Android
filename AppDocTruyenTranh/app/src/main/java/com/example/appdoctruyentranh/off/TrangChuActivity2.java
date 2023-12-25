package com.example.appdoctruyentranh.off;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager2.widget.ViewPager2;

import com.example.appdoctruyentranh.OptionDocTruyen;
import com.example.appdoctruyentranh.R;
import com.example.appdoctruyentranh.off.Adapter.AdapterViewPage2;
import com.example.appdoctruyentranh.onl.MainActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class TrangChuActivity2 extends AppCompatActivity {
    Toolbar toolbar;
    Button btnBackOff;
    ViewPager2 mViewPager2;
    AdapterViewPage2 adapterViewPage2;
    BottomNavigationView mBottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.appdoctruyentranh.R.layout.activity_trang_chu2);
        toolbar = findViewById(R.id.toolbar_trang_chu);
        mViewPager2 = findViewById(R.id.viewpage2_trang_chu);
        mBottomNavigationView = findViewById(R.id.bottomnavigation_trang_chu);

        btnBackOff = findViewById(R.id.btnBackOff);
        btnBackOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TrangChuActivity2.this, OptionDocTruyen.class);
                startActivity(intent);
            }
        });
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");

        adapterViewPage2 = new AdapterViewPage2(this);
        mViewPager2.setAdapter(adapterViewPage2);

        mBottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
//                    case R.id.item_home:
//                        mViewPager2.setCurrentItem(0);
//                        break;
//                    case R.id.item_yeu_thich:
//                        mViewPager2.setCurrentItem(1);
//                        break;
                }
                return true;
            }
        });

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