package com.samsung.bankservice.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity(name = "giaodichthe")
public class GiaoDichThe {
    @Id
    private int magiaodich;
    @ManyToOne
    TaiKhoanTietKiem taiKhoanTietKiem;
    @ManyToOne
    TaiKhoanTinDung taiKhoanTinDung;
    private  float sotiengiaodich;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date ngaygiaodich;
    private  String loaigiaodich;
    @ManyToOne
    NhanVien nhanVien;

    public void setMagiaodich(int magiaodich) {
        this.magiaodich = magiaodich;
    }

    public void setTaiKhoanTietKiem(TaiKhoanTietKiem taiKhoanTietKiem) {
        this.taiKhoanTietKiem = taiKhoanTietKiem;
    }

    public void setTaiKhoanTinDung(TaiKhoanTinDung taiKhoanTinDung) {
        this.taiKhoanTinDung = taiKhoanTinDung;
    }

    public void setSotiengiaodich(float sotiengiaodich) {
        this.sotiengiaodich = sotiengiaodich;
    }

    public void setNgaygiaodich(Date ngaygiaodich) {
        this.ngaygiaodich = ngaygiaodich;
    }

    public void setLoaigiaodich(String loaigiaodich) {
        this.loaigiaodich = loaigiaodich;
    }

    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }

    public int getMagiaodich() {
        return magiaodich;
    }

    public TaiKhoanTietKiem getTaiKhoanTietKiem() {
        return taiKhoanTietKiem;
    }

    public TaiKhoanTinDung getTaiKhoanTinDung() {
        return taiKhoanTinDung;
    }

    public float getSotiengiaodich() {
        return sotiengiaodich;
    }

    public Date getNgaygiaodich() {
        return ngaygiaodich;
    }

    public String getLoaigiaodich() {
        return loaigiaodich;
    }

    public NhanVien getNhanVien() {
        return nhanVien;
    }
}
