package com.example.appdoctruyentranh;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.appdoctruyentranh.off.MainActivityOff;
import com.example.appdoctruyentranh.onl.MainActivity;
import com.example.appdoctruyentranh.user.DangNhap;

public class OptionDocTruyen extends AppCompatActivity {
    Button btnReadOnline, btnReadOffline, logOut;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option_doc_truyen);
        btnReadOnline = findViewById(R.id.btnReadOnline);
        btnReadOffline = findViewById(R.id.btnReadOffline);

        logOut = findViewById(R.id.logOut);

        btnReadOnline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OptionDocTruyen.this, MainActivity.class);
                startActivity(intent);
            }
        });


        btnReadOffline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OptionDocTruyen.this, MainActivityOff.class);
                startActivity(intent);
            }
        });

        logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OptionDocTruyen.this, DangNhap.class);
                startActivity(intent);
            }
        });
    }
}