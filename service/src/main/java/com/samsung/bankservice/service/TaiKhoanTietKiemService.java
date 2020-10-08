package com.samsung.bankservice.service;

import com.samsung.bankservice.entity.TaiKhoanTietKiem;
import com.samsung.bankservice.responsitory.TaiKhoanTietKiemReponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaiKhoanTietKiemService {

    @Autowired
    TaiKhoanTietKiemReponsitory accountsaving;

    public List<TaiKhoanTietKiem> getAllAccountSaving(){

        return  accountsaving.findAll();
    }

    public void deleteAccountSavingById(TaiKhoanTietKiem taiKhoan){
        accountsaving.delete(taiKhoan);

    }

    public TaiKhoanTietKiem updateAccountSavingById(TaiKhoanTietKiem taiKhoan){

        return accountsaving.save(taiKhoan);
    }

    public TaiKhoanTietKiem findAccountSavingById(int id){
        Optional<TaiKhoanTietKiem> taiKhoan=accountsaving.findById(id);;
        return  taiKhoan.get();
    }

    public  TaiKhoanTietKiem saveAccountSaving(TaiKhoanTietKiem taiKhoan){

        return accountsaving.save(taiKhoan);
    }

}
