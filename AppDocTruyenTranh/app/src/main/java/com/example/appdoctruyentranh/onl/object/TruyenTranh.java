package com.example.appdoctruyentranh.onl.object;

import org.json.JSONException;
import org.json.JSONObject;


public class TruyenTranh {
    private Long id;
    private String tenTruyen;
    private String tenChap;
    private String linkAnh;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TruyenTranh(JSONObject o) throws JSONException {
        tenTruyen = o.getString("tenTruyen");
        tenChap = o.getString("tenChap");
        linkAnh = o.getString("linkAnh");
    }
    public String getTenTruyen() {
        return tenTruyen;
    }

    public void setTenTruyen(String tenTruyen) {
        this.tenTruyen = tenTruyen;
    }

    public String getTenChap() {
        return tenChap;
    }

    public void setTenChap(String tenChap) {
        this.tenChap = tenChap;
    }

    public String getLinkAnh() {
        return linkAnh;
    }

    public void setLinkAnh(String linkAnh) {
        this.linkAnh = linkAnh;
    }

    public TruyenTranh() {
    }

//    public TruyenTranh(String tenTruyen, String tapTruyen, String anhTruyen) {
//        this.tenTruyen = tenTruyen;
//        this.tapTruyen = tapTruyen;
//        this.anhTruyen = anhTruyen;
//    }
//
//    public String getTenTruyen() {
//        return tenTruyen;
//    }
//
//    public void setTenTruyen(String tenTruyen) {
//        this.tenTruyen = tenTruyen;
//    }
//
//    public String getTapTruyen() {
//        return tapTruyen;
//    }
//
//    public void setTapTruyen(String tapTruyen) {
//        this.tapTruyen = tapTruyen;
//    }
//
//    public String getAnhTruyen() {
//        return anhTruyen;
//    }
//
//    public void setAnhTruyen(String anhTruyen) {
//        this.anhTruyen = anhTruyen;
//    }
//
//    public TruyenTranh(JSONObject o) throws JSONException {
//        tenTruyen = o.getString("tenTruyen");
//        tapTruyen = o.getString("tapTruyen");
//        anhTruyen = o.getString("anhTruyen");
//    }


}
