package com.example.appdoctruyentranh.user;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.appdoctruyentranh.OptionDocTruyen;
import com.example.appdoctruyentranh.R;

public class DangKi extends AppCompatActivity {
    Button button_dang_ky;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_ki);
        button_dang_ky = findViewById(R.id.button_dang_ky);
        button_dang_ky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DangKi.this, DangNhap.class);
                startActivity(intent);

                Context context = getApplicationContext();
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, "Đăng Ký Thành Công", duration);
                toast.show();

            }
        });
//        button_dang_ky = findViewById(R.id.button_dang_ky);
//        button_dang_ky.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(DangKi.this, DangNhap.class);
//                startActivity(intent);
//            }
//        });


    }
}