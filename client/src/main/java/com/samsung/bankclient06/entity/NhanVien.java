package com.samsung.bankclient06.entity;


import java.util.Date;

public class NhanVien {
    private  int manhanvien;
    private String chungminhthu;
    private String tennhanvien;
    private String diachi;
    private Date ngaysinh;
    ChucVu chucVu;
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
    public NhanVien() {
    }
    public NhanVien(int manhanvien, String chungminhthu, String tennhanvien, String diachi, Date ngaysinh, ChucVu chucVu, String username, String password) {
        this.manhanvien = manhanvien;
        this.chungminhthu = chungminhthu;
        this.tennhanvien = tennhanvien;
        this.diachi = diachi;
        this.ngaysinh = ngaysinh;
        this.chucVu = chucVu;
        this.username = username;
        this.password = password;
    }

    public NhanVien(int manhanvien, String chungminhthu, String tennhanvien, String diachi, Date ngaysinh, ChucVu chucVu) {
        this.manhanvien = manhanvien;
        this.chungminhthu = chungminhthu;
        this.tennhanvien = tennhanvien;
        this.diachi = diachi;
        this.chucVu = chucVu;
        this.ngaysinh = ngaysinh;
    }

    public void setManhanvien(int manhanvien) {
        this.manhanvien = manhanvien;
    }

    public void setChungminhthu(String chungminhthu) {
        this.chungminhthu = chungminhthu;
    }

    public void setTennhanvien(String tennhanvien) {
        this.tennhanvien = tennhanvien;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public void setNgaysinh(Date ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public void setChucVu(ChucVu chucVu) {
        this.chucVu = chucVu;
    }

    public int getManhanvien() {
        return manhanvien;
    }

    public String getChungminhthu() {
        return chungminhthu;
    }

    public String getTennhanvien() {
        return tennhanvien;
    }


    public String getDiachi() {
        return diachi;
    }

    public Date getNgaysinh() {
        return ngaysinh;
    }

    public ChucVu getChucVu() {
        return chucVu;
    }
}
