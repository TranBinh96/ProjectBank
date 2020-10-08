package com.samsung.bankclient06.entity;


import java.util.Date;


public class GiaoDichThe {

    private int magiaodich;
    private Date ngaygiaodich;
    private  String sotiengiaodich;
    private  String loaigiaodich;
    NhanVien nhanVien;
    KhachHang khachHang;
    TaiKhoanTinDung taiKhoanTinDung;
    TaiKhoanTietKiem taiKhoanTietKiem;

    public void setTaiKhoanTinDung(TaiKhoanTinDung taiKhoanTinDung) {
        this.taiKhoanTinDung = taiKhoanTinDung;
    }

    public void setTaiKhoanTietKiem(TaiKhoanTietKiem taiKhoanTietKiem) {
        this.taiKhoanTietKiem = taiKhoanTietKiem;
    }

    public TaiKhoanTinDung getTaiKhoanTinDung() {
        return taiKhoanTinDung;
    }

    public TaiKhoanTietKiem getTaiKhoanTietKiem() {
        return taiKhoanTietKiem;
    }

    public void setMagiaodich(int magiaodich) {
        this.magiaodich = magiaodich;
    }

    public void setNgaygiaodich(Date ngaygiaodich) {
        this.ngaygiaodich = ngaygiaodich;
    }

    public void setSotiengiaodich(String sotiengiaodich) {
        this.sotiengiaodich = sotiengiaodich;
    }

    public void setLoaigiaodich(String loaigiaodich) {
        this.loaigiaodich = loaigiaodich;
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

    public Date getNgaygiaodich() {
        return ngaygiaodich;
    }

    public String getSotiengiaodich() {
        return sotiengiaodich;
    }

    public String getLoaigiaodich() {
        return loaigiaodich;
    }

    public NhanVien getNhanVien() {
        return nhanVien;
    }

    public KhachHang getKhachHang() {
        return khachHang;
    }


}
