package com.samsung.bankservice.service;

import com.samsung.bankservice.entity.TaiKhoanTinDung;
import com.samsung.bankservice.responsitory.TaiKhoanTinDungReponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaiKhoanTieuDungService {
    @Autowired
    TaiKhoanTinDungReponsitory accountCustomer;
    public List<TaiKhoanTinDung> getAllAccountCostomer(){

        return  accountCustomer.findAll();
    }

    public void deleteAccountCostomerById(TaiKhoanTinDung taiKhoan){
        accountCustomer.delete(taiKhoan);

    }

    public TaiKhoanTinDung updateAccountCustomerById(TaiKhoanTinDung taiKhoan){

        return accountCustomer.save(taiKhoan);
    }

    public  TaiKhoanTinDung findAccountCostomerById(int id){
        Optional<TaiKhoanTinDung> taiKhoan=accountCustomer.findById(id);;
        return  taiKhoan.get();
    }

    public TaiKhoanTinDung saveAccountCostomer(TaiKhoanTinDung taiKhoan){

        return accountCustomer.save(taiKhoan);
    }
}
