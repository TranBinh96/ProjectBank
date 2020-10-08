package com.samsung.bankservice.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "taikhoantietkiem")
public class TaiKhoanTietKiem  {
    @Id
    private  int mataikhoantietkiem;
    private  String tenloaitaikhoan;
    private String laisuathangthang;
    private String sodutoithieu;
    private String sotienguilandau;

    public void setMataikhoantietkiem(int mataikhoantietkiem) {
        this.mataikhoantietkiem = mataikhoantietkiem;
    }

    public String getSotienguilandau() {
        return sotienguilandau;
    }

    public void setSotienguilandau(String sotienguilandau) {
        this.sotienguilandau = sotienguilandau;
    }

    public void setTenloaitaikhoan(String tenloaitaikhoan) {
        this.tenloaitaikhoan = tenloaitaikhoan;
    }

    public void setLaisuathangthang(String laisuathangthang) {
        this.laisuathangthang = laisuathangthang;
    }

    public void setSodutoithieu(String sodutoithieu) {
        this.sodutoithieu = sodutoithieu;
    }

    public int getMataikhoantietkiem() {
        return mataikhoantietkiem;
    }

    public String getTenloaitaikhoan() {
        return tenloaitaikhoan;
    }

    public String getLaisuathangthang() {
        return laisuathangthang;
    }

    public String getSodutoithieu() {
        return sodutoithieu;
    }
}
