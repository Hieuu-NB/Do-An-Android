package com.example.appdoctruyentranh.onl.api;

import android.os.AsyncTask;

import com.example.appdoctruyentranh.onl.interfaces.LayTrangTruyen;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ApiLayTrangTruyen  extends AsyncTask<String, Void, String> {
    String data;
    LayTrangTruyen layTrangTruyen;
    private final OkHttpClient client = new OkHttpClient();
    public ApiLayTrangTruyen(LayTrangTruyen layTrangTruyen){
        this.layTrangTruyen = layTrangTruyen;
        this.layTrangTruyen.batDau();
    }
    @Override
    protected String doInBackground(String... params) {
        String param1 = "";

        if (params != null && params.length > 0) {
            param1 = params[0];
        }else{
            System.out.println("Loiiii !!!!!!!!!!!!!");
            System.out.println("Loiiii !!!!!!!!!!!!!");
            System.out.println("Loiiii !!!!!!!!!!!!!");
            System.out.println("Loiiii !!!!!!!!!!!!!");
        }

//        System.out.println();
        // Tạo URL với các tham số
        String url = "http://172.20.149.23:8090/truyen-tranh-onl/get-by-id?tapTruyen=" + param1;
        // Tạo yêu cầu GET
        Request request = new Request.Builder()
                .url(url)
                .build();
//        Request request = new Request.Builder()
//                .url("http://192.168.1.2:8090/truyen-tranh-onl/get-all")
//                .build();
        data = null;
        try {
            // Thực hiện cuộc gọi đồng bộ và nhận kết quả
            Response response = client.newCall(request).execute();
                data = response.body().string();
                return data;
        } catch (IOException e) {
            data= null;
            throw new RuntimeException(e);
        }
    }



    @Override
    protected void onPostExecute(String result) {
        if(data == null){
            this.layTrangTruyen.biLoi();
        }
        else{
            this.layTrangTruyen.ketThuc(data);
        }
    }
}
