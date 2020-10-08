package com.samsung.bankclient06.entity;


public class ChucVu {

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

    public ChucVu(int machucvu, String tenchucvu) {
        this.machucvu = machucvu;
        this.tenchucvu = tenchucvu;
    }

    public ChucVu() {
    }
}
