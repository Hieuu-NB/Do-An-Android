package com.example.appdoctruyentranh.user;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.appdoctruyentranh.OptionDocTruyen;
import com.example.appdoctruyentranh.R;


import java.util.ArrayList;
import java.util.List;

public class DangNhap extends AppCompatActivity   {
    Button btnLogin,btn2;
    EditText edit_taikhoan,edit_mat_khau;
    TextView text_dang_ky;
//    List<User> users;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dang_nhap);

//        button_dang_nhap.findViewById(R.id.btnLogin);
//        btn2.findViewById(R.id.btn2);

        // Ánh xạ Button
        Button myButton = findViewById(R.id.my_button);
        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DangNhap.this, OptionDocTruyen.class);
                startActivity(intent);
            }
        });

        text_dang_ky = findViewById(R.id.text_dang_ky);
        text_dang_ky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DangNhap.this, DangKi.class);
                startActivity(intent);
            }
        });
//        button_dang_nhap.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(DangNhap.this, OptionDocTruyen.class);
//                startActivity(intent);
//            }
//        });


//        users = new ArrayList<>();
//        UserAdapter adapter = new UserAdapter(this, 0, users);

//        edit_taikhoan.findViewById(R.id.edit_taikhoan);
//        edit_mat_khau.findViewById(R.id.edit_mat_khau);
//
//        String tk = String.valueOf(edit_taikhoan.getText());
//        String mk = String.valueOf(edit_mat_khau.getText());

//        new ApiCheckUser(this).execute();


    }


//    @Override
//    public void batDau() {
//        Toast.makeText(this, "Loading ...", Toast.LENGTH_SHORT).show();
//    }
//
//    @Override
//    public void ketThuc(String data) {
//        try {
//            users.clear();
//            JSONArray arr = new JSONArray(data);
//            for (int i = 0; i< arr.length();i++){
//                JSONObject o = arr.getJSONObject(i);
//                users.add(new User(o));
//            }
//
////            adapter = new TruyenTranhAdapter(this, R.id.gdvDSTruyen, truyenTranhArrayList);
////            gdvDSTruyen.setAdapter(adapter);
//        }catch (JSONException e){
//            e.getMessage();
//        }
//    }
//
//
//    @Override
//    public void biLoi() {
//        Toast.makeText(this, "Conect False !!!", Toast.LENGTH_SHORT).show();
//    }
//
//    @Override
//    public void onPointerCaptureChanged(boolean hasCapture) {
//        super.onPointerCaptureChanged(hasCapture);
//    }
}