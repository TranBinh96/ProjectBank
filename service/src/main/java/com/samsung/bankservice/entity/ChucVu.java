package com.samsung.bankservice.entity;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "chucvu")
public class ChucVu {
    @Id
    private int machucvu;
    private String tenchucvu;

    public void setMachucvu(int machucvu) {
        this.machucvu = machucvu;
    }

    public void setTenchucvu(String tenchucvu) {
        this.tenchucvu = tenchucvu;
    }

    public int getMachucvu() {
        return machucvu;
    }

    public String getTenchucvu() {
        return tenchucvu;
    }
}
