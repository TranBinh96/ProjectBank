package com.samsung.bankclient06.entity;


public class TaiKhoanTinDung  {
    private  int mataikhoantindung;
    private  String tenloaitaikhoan;
    private String  soduhientai;
    private String hanmuctoida;


    public TaiKhoanTinDung() {
    }

    public TaiKhoanTinDung(int mataikhoantindung, String tenloaitaikhoan, String soduhientai, String hanmuctoida) {
        this.mataikhoantindung = mataikhoantindung;
        this.tenloaitaikhoan = tenloaitaikhoan;
        this.soduhientai = soduhientai;
        this.hanmuctoida = hanmuctoida;
    }

    public void setMataikhoantindung(int mataikhoantindung) {
        this.mataikhoantindung = mataikhoantindung;
    }

    public void setTenloaitaikhoan(String tenloaitaikhoan) {
        this.tenloaitaikhoan = tenloaitaikhoan;
    }

    public void setSoduhientai(String soduhientai) {
        this.soduhientai = soduhientai;
    }

    public void setHanmuctoida(String hanmuctoida) {
        this.hanmuctoida = hanmuctoida;
    }

    public int getMataikhoantindung() {
        return mataikhoantindung;
    }

    public String getTenloaitaikhoan() {
        return tenloaitaikhoan;
    }

    public String getSoduhientai() {
        return soduhientai;
    }

    public String getHanmuctoida() {
        return hanmuctoida;
    }
}
