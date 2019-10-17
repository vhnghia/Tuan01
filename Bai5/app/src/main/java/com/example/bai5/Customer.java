package com.example.bai5;

public class Customer {
    private String FullName;
    private float TongTien;
    private String loaiKH;

    public Customer(String Fullname, float TongTien, String loaiKH){
        this.FullName = Fullname;
        this.TongTien = TongTien;
        this.loaiKH = loaiKH;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    public String getFullName() {
        return FullName;
    }

    public void setLoaiKH(String loaiKH) {
        this.loaiKH = loaiKH;
    }

    public String getLoaiKH() {
        return loaiKH;
    }

    public void setTongTien(float tongTien) {
        TongTien = tongTien;
    }

    public float getTongTien() {
        return TongTien;
    }
}
