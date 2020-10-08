package com.samsung.bankservice.entity;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="taikhoantindung")
public class TaiKhoanTinDung  {
    @Id
    private  int mataikhoantindung;
    private  String tenloaitaikhoan;
    private String soduhientai;
    private String hanmuctoida;

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
