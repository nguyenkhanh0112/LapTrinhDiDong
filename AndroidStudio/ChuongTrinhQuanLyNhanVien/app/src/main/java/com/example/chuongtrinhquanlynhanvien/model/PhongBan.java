package com.example.chuongtrinhquanlynhanvien.model;

import com.example.chuongtrinhquanlynhanvien.model.NhanVien;

import java.util.ArrayList;

public class PhongBan {
    private String maPhong;
    private String tenPhong;
    private NhanVien truongPhong;
    private ArrayList<NhanVien> phoPhongs;
    private ArrayList<NhanVien>nhanViens;

    public PhongBan(String maPhong, String tenPhong, NhanVien truongPhong, ArrayList<NhanVien> phoPhongs,ArrayList<NhanVien>nhanViens) {
        this.maPhong = maPhong;
        this.tenPhong = tenPhong;
        this.truongPhong = truongPhong;
        this.phoPhongs = phoPhongs;
        this.nhanViens=nhanViens;
    }
    public PhongBan(){}

    public String getMaPhong() {
        return maPhong;
    }

    public void setMaPhong(String maPhong) {
        this.maPhong = maPhong;
    }

    public String getTenPhong() {
        return tenPhong;
    }

    public void setTenPhong(String tenPhong) {
        this.tenPhong = tenPhong;
    }

    public ArrayList<NhanVien> getPhoPhongs() {
        return phoPhongs;
    }

    public void setPhoPhongs(ArrayList<NhanVien> phoPhongs) {
        this.phoPhongs = phoPhongs;
    }

    public ArrayList<NhanVien> getNhanViens() {
        return nhanViens;
    }

    public void setNhanViens(ArrayList<NhanVien> nhanViens) {
        this.nhanViens = nhanViens;
    }

    public NhanVien getTruongPhong() {
        return truongPhong;
    }

    public void setTruongPhong(NhanVien truongPhong) {
        this.truongPhong = truongPhong;
    }
}
