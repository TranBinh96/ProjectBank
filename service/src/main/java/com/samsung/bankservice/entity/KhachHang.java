package com.samsung.bankservice.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity(name = "khachhang")
public class KhachHang {
    @Id
    private int makhachhang;
    private  String tenkhachhang;
    private  String chungminhthu;
    private  String diachi;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
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
