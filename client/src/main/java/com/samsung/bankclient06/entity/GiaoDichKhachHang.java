package com.samsung.bankclient06.entity;

import java.util.Date;


public class GiaoDichKhachHang {

    private  int magiaodich;
    private String loagiaodich;
    private String sotiengiaodich;
    private  Date ngaygiaodich;
    TaiKhoan taiKhoan;
    NhanVien nhanVien;
    KhachHang khachHang;

    public TaiKhoan getTaiKhoan() {
        return taiKhoan;
    }

    public void setTaiKhoan(TaiKhoan taiKhoan) {
        this.taiKhoan = taiKhoan;
    }

    public void setMagiaodich(int magiaodich) {
        this.magiaodich = magiaodich;
    }

    public void setLoagiaodich(String loagiaodich) {
        this.loagiaodich = loagiaodich;
    }

    public void setSotiengiaodich(String sotiengiaodich) {
        this.sotiengiaodich = sotiengiaodich;
    }

    public void setNgaygiaodich(Date ngaygiaodich) {
        this.ngaygiaodich = ngaygiaodich;
    }

    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }

    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }

    public int getMagiaodich() {
        return magiaodich;
    }

    public String getLoagiaodich() {
        return loagiaodich;
    }

    public String getSotiengiaodich() {
        return sotiengiaodich;
    }

    public Date getNgaygiaodich() {
        return ngaygiaodich;
    }

    public NhanVien getNhanVien() {
        return nhanVien;
    }

    public KhachHang getKhachHang() {
        return khachHang;
    }
}
