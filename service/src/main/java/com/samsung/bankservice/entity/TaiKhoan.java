package com.samsung.bankservice.entity;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity(name = "taikhoan")
public class TaiKhoan {
    @Id
    private  int mataikhoan;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date ngaytaotaikhoan;
    private  String tenloaitaikhoan;
    @ManyToOne
    KhachHang khachHang;
    @ManyToOne
    NhanVien nhanVien;
    private String sodu;

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
