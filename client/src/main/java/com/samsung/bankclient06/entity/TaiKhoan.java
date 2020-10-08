package com.samsung.bankclient06.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class TaiKhoan {
    private  int mataikhoan;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date ngaytaotaikhoan;
    private  String tenloaitaikhoan;
    KhachHang khachHang;
    NhanVien nhanVien;
    private String sodu;

    public TaiKhoan() {
    }

    public TaiKhoan(int mataikhoan, Date ngaytaotaikhoan, String tenloaitaikhoan, KhachHang khachHang, NhanVien nhanVien, String sodu) {
        this.mataikhoan = mataikhoan;
        this.ngaytaotaikhoan = ngaytaotaikhoan;
        this.tenloaitaikhoan = tenloaitaikhoan;
        this.khachHang = khachHang;
        this.nhanVien = nhanVien;
        this.sodu = sodu;
    }

    public void setMataikhoan(int mataikhoan) {
        this.mataikhoan = mataikhoan;
    }

    public void setNgaytaotaikhoan(Date ngaytaotaikhoan) {
        this.ngaytaotaikhoan = ngaytaotaikhoan;
    }

    public void setTenloaitaikhoan(String tenloaitaikhoan) {
        this.tenloaitaikhoan = tenloaitaikhoan;
    }

    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }

    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }

    public void setSodu(String sodu) {
        this.sodu = sodu;
    }

    public int getMataikhoan() {
        return mataikhoan;
    }

    public Date getNgaytaotaikhoan() {
        return ngaytaotaikhoan;
    }

    public String getTenloaitaikhoan() {
        return tenloaitaikhoan;
    }

    public KhachHang getKhachHang() {
        return khachHang;
    }

    public NhanVien getNhanVien() {
        return nhanVien;
    }

    public String getSodu() {
        return sodu;
    }
}
