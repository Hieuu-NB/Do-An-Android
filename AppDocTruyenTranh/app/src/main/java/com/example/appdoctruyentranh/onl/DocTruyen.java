package com.example.appdoctruyentranh.onl;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import com.example.appdoctruyentranh.R;
import com.example.appdoctruyentranh.onl.adapter.TrangTruyenAdapter;
import com.example.appdoctruyentranh.onl.api.ApiLayTrangTruyen;
import com.example.appdoctruyentranh.onl.interfaces.LayTrangTruyen;
import com.example.appdoctruyentranh.onl.object.TrangTruyenOnl;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class DocTruyen extends AppCompatActivity implements LayTrangTruyen {
    Button btn;
    GridView gdvDSTruyen;
    List<TrangTruyenOnl> trangTruyenOnls;
    TrangTruyenAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doc_truyen);
        init();
        anhXa();
        setUp();
        setClick();
        new ApiLayTrangTruyen(this).execute();


        Intent intent = getIntent();

        // lấy bundle ra khỏi intent
        Bundle bundle = intent.getBundleExtra("myPackage");
        int a = bundle.getInt("TapTruyen");
        System.out.println(a);
//        ApiLayTrangTruyen apiTask = new ApiLayTrangTruyen();
//        apiTask.execute(String.valueOf(a));

        new ApiLayTrangTruyen(this).execute(String.valueOf(a));
    }
    private void init(){
        trangTruyenOnls = new ArrayList<>();
        adapter = new TrangTruyenAdapter(this, 0, trangTruyenOnls);
    }

    private void anhXa(){
        btn = findViewById(R.id.button);
        gdvDSTruyen = findViewById(R.id.DsTrangTruyen);
    }
    private void setUp(){
        gdvDSTruyen.setAdapter(adapter);
    }
    private void setClick(){
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DocTruyen.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }



    @Override
    public void batDau() {
        Toast.makeText(this, "Loading ...", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void ketThuc(String data) {
        try {
            trangTruyenOnls.clear();
            JSONArray arr = new JSONArray(data);

            for (int i = 0; i< arr.length();i++){
                JSONObject o = arr.getJSONObject(i);
                trangTruyenOnls.add(new TrangTruyenOnl(o));
            }
            adapter = new TrangTruyenAdapter(this, R.id.gdvDSTruyen, trangTruyenOnls);
            gdvDSTruyen.setAdapter(adapter);
        }catch (JSONException e){
            e.getMessage();
        }
    }

    @Override
    public void biLoi() {
        Toast.makeText(this, "Conect False !!!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}