package com.example.appdoctruyentranh.onl;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appdoctruyentranh.R;
import com.example.appdoctruyentranh.off.MainActivityOff;
import com.example.appdoctruyentranh.off.TrangChuActivity2;

public class MainActivityOnl extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_off);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(MainActivityOnl.this, MainActivity.class));
            }
        },3000);
    }
}
