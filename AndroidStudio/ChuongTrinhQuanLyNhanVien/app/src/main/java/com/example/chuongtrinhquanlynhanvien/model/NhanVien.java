package com.example.chuongtrinhquanlynhanvien.model;

import java.util.ArrayList;

public class NhanVien {
    private String TenNV;
    private String MaNV;
    private String gioiTinh;
    private String chucvu;
    private Boolean gioitinh;

    public NhanVien(String maNV,String tenNV, String gioiTinh,Boolean gioitinh ,String chucvu) {
        TenNV = tenNV;
        MaNV = maNV;
        this.gioiTinh = gioiTinh;
        this.chucvu = chucvu;
        this.gioiTinh = gioiTinh;
    }

    public Boolean getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(Boolean gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getTenNV() {
        return TenNV;
    }

    public void setTenNV(String tenNV) {
        TenNV = tenNV;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String maNV) {
        MaNV = maNV;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getChucvu() {
        return chucvu;
    }

    public void setChucvu(String chucvu) {
        this.chucvu = chucvu;
    }
}
