package com.samsung.bankclient06.entity;


public class TaiKhoanTietKiem  {
    private  int mataikhoantietkiem;
    private  String tenloaitaikhoan;
    private String laisuathangthang;
    private String sodutoithieu;
    private String sotienguilandau;

    public TaiKhoanTietKiem(){}
    public TaiKhoanTietKiem(int mataikhoantietkiem, String tenloaitaikhoan, String laisuathangthang,String sodutoithieu,String sotienguilandau){
        this.mataikhoantietkiem=mataikhoantietkiem;
        this.tenloaitaikhoan=tenloaitaikhoan;
        this.laisuathangthang=laisuathangthang;
        this.sodutoithieu=sodutoithieu;
        this.sotienguilandau=sotienguilandau;
    }

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
