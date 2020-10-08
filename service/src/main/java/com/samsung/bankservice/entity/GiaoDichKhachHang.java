package com.samsung.bankservice.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity(name = "giaodichkhachhang")
public class GiaoDichKhachHang {
    @Id
    private  String magiaodich;
    @ManyToOne
    KhachHang khachHang;
    @ManyToOne
    TaiKhoan taiKhoan;
    private String loagiaodich;
    private float sotiengiaodich;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private  Date ngaygiaodich;
    @ManyToOne
    NhanVien nhanVien;

    public void setMagiaodich(String magiaodich) {
        this.magiaodich = magiaodich;
    }

    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }

    public void setTaiKhoan(TaiKhoan taiKhoan) {
        this.taiKhoan = taiKhoan;
    }

    public void setLoagiaodich(String loagiaodich) {
        this.loagiaodich = loagiaodich;
    }

    public void setSotiengiaodich(float sotiengiaodich) {
        this.sotiengiaodich = sotiengiaodich;
    }

    public void setNgaygiaodich(Date ngaygiaodich) {
        this.ngaygiaodich = ngaygiaodich;
    }

    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }

    public String getMagiaodich() {
        return magiaodich;
    }

    public KhachHang getKhachHang() {
        return khachHang;
    }

    public TaiKhoan getTaiKhoan() {
        return taiKhoan;
    }

    public String getLoagiaodich() {
        return loagiaodich;
    }

    public float getSotiengiaodich() {
        return sotiengiaodich;
    }

    public Date getNgaygiaodich() {
        return ngaygiaodich;
    }

    public NhanVien getNhanVien() {
        return nhanVien;
    }
}
