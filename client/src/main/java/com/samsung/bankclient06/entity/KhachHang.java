package com.samsung.bankclient06.entity;


import java.util.Date;

public class KhachHang {

    private int makhachhang;
    private  String tenkhachhang;
    private  String chungminhthu;
    private  String diachi;
    private Date nggaysinh;
    private String username;
    private  String password;

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public KhachHang(int makhachhang, String tenkhachhang, String chungminhthu, String diachi, Date nggaysinh, String username, String password) {
        this.makhachhang = makhachhang;
        this.tenkhachhang = tenkhachhang;
        this.chungminhthu = chungminhthu;
        this.diachi = diachi;
        this.nggaysinh = nggaysinh;
        this.username = username;
        this.password = password;
    }

    public KhachHang() {
    }

    public KhachHang(int makhachhang, String tenkhachhang, String chungminhthu, String diachi, Date nggaysinh) {
        this.makhachhang = makhachhang;
        this.tenkhachhang = tenkhachhang;
        this.chungminhthu = chungminhthu;
        this.diachi = diachi;
        this.nggaysinh = nggaysinh;
    }

    public void setMakhachhang(int makhachhang) {
        this.makhachhang = makhachhang;
    }

    public void setTenkhachhang(String tenkhachhang) {
        this.tenkhachhang = tenkhachhang;
    }

    public void setChungminhthu(String chungminhthu) {
        this.chungminhthu = chungminhthu;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public void setNggaysinh(Date nggaysinh) {
        this.nggaysinh = nggaysinh;
    }

    public int getMakhachhang() {
        return makhachhang;
    }

    public String getTenkhachhang() {
        return tenkhachhang;
    }

    public String getChungminhthu() {
        return chungminhthu;
    }

    public String getDiachi() {
        return diachi;
    }

    public Date getNggaysinh() {
        return nggaysinh;
    }
}
