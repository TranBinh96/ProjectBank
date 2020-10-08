package com.samsung.bankservice.controller;

import com.samsung.bankservice.entity.TaiKhoanTietKiem;
import com.samsung.bankservice.service.TaiKhoanTietKiemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(path = "/accountsaving",produces = "application/json")
public class AccountSavingController {
    @Autowired
    TaiKhoanTietKiemService accountSaving;
    @GetMapping("find/{id}")
    public TaiKhoanTietKiem findPositionById(@PathVariable int id){
        TaiKhoanTietKiem taiKhoan=  accountSaving.findAccountSavingById(id);
        return  taiKhoan;
    }
    @RequestMapping(produces = "application/json")
    @PostMapping
    public TaiKhoanTietKiem findPositionById(@RequestBody TaiKhoanTietKiem taiKhoan){
        return accountSaving.saveAccountSaving(taiKhoan);
    }

    @PutMapping("{id}")
    public TaiKhoanTietKiem updatePositionById(@PathVariable  int id,@RequestBody TaiKhoanTietKiem taiKhoan){
        accountSaving.findAccountSavingById(id);
        return  accountSaving.updateAccountSavingById(taiKhoan);
    }

    @DeleteMapping("{id}")
    public void deletePositionById(@PathVariable  int id){
        TaiKhoanTietKiem taiKhoan=  accountSaving.findAccountSavingById(id);
        accountSaving.deleteAccountSavingById(taiKhoan);
    }

    @GetMapping
    public List<TaiKhoanTietKiem> getAllPositon(){
        List<TaiKhoanTietKiem> taiKhoans=accountSaving.getAllAccountSaving();
        return taiKhoans;
    }
}
