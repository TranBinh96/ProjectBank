package com.samsung.bankservice.service;

import com.samsung.bankservice.entity.TaiKhoan;
import com.samsung.bankservice.responsitory.TaiKhoanResponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaiKhoanService {
    @Autowired
    TaiKhoanResponsitory taiKhoanResponsitory;

    public List<TaiKhoan> getAllAccount(){

        return  taiKhoanResponsitory.findAll();
    }

    public void deleteAccountId(TaiKhoan taiKhoan){
        taiKhoanResponsitory.delete(taiKhoan);

    }

    public TaiKhoan updateAccountById(TaiKhoan taiKhoan){

        return taiKhoanResponsitory.save(taiKhoan);
    }

    public  TaiKhoan findAccountById(int id){
        Optional<TaiKhoan> taiKhoan=taiKhoanResponsitory.findById(id);;
        return  taiKhoan.get();
    }

    public  TaiKhoan saveAccountSaving(TaiKhoan taiKhoan){

        return taiKhoanResponsitory.save(taiKhoan);
    }
}
