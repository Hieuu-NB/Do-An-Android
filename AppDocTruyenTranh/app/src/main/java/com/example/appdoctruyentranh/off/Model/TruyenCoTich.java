package com.example.appdoctruyentranh.off.Model;

public class TruyenCoTich {
    private int id;
    private int imageAnhTruyen;
    private String tenTruyen;
    private String noiDungTruyen;

    public TruyenCoTich() {
    }

    public TruyenCoTich(int id, int imageAnhTruyen, String tenTruyen, String noiDungTruyen) {
        this.id = id;
        this.imageAnhTruyen = imageAnhTruyen;
        this.tenTruyen = tenTruyen;
        this.noiDungTruyen = noiDungTruyen;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImageAnhTruyen() {
        return imageAnhTruyen;
    }

    public void setImageAnhTruyen(int imageAnhTruyen) {
        this.imageAnhTruyen = imageAnhTruyen;
    }

    public String getTenTruyen() {
        return tenTruyen;
    }

    public void setTenTruyen(String tenTruyen) {
        this.tenTruyen = tenTruyen;
    }

    public String getNoiDungTruyen() {
        return noiDungTruyen;
    }

    public void setNoiDungTruyen(String noiDungTruyen) {
        this.noiDungTruyen = noiDungTruyen;
    }
}
