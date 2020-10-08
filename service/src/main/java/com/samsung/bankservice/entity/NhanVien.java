package com.samsung.bankservice.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity(name = "nhanvien")
public class NhanVien {
    @Id
    private  int manhanvien;
    private String chungminhthu;
    private String tennhanvien;
    private String diachi;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date ngaysinh;
    @ManyToOne
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
