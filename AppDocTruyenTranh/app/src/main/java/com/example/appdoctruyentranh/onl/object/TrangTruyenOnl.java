package com.example.appdoctruyentranh.onl.object;

import org.json.JSONException;
import org.json.JSONObject;

public class TrangTruyenOnl {
    private Long id;
    private String linkTrangTruyen;
    public TrangTruyenOnl(JSONObject o) throws JSONException {
        id = o.getLong("id");
        linkTrangTruyen = o.getString("linkTrangTruyen");
    }
    public TrangTruyenOnl() {
    }

    public TrangTruyenOnl(Long id, String linkTrangTruyen) {
        this.id = id;
        this.linkTrangTruyen = linkTrangTruyen;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLinkTrangTruyen() {
        return linkTrangTruyen;
    }

    public void setLinkTrangTruyen(String linkTrangTruyen) {
        this.linkTrangTruyen = linkTrangTruyen;
    }
}
