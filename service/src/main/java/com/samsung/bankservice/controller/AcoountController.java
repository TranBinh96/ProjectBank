package com.samsung.bankservice.controller;
import com.samsung.bankservice.entity.TaiKhoan;
import com.samsung.bankservice.service.TaiKhoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(path = "/account",produces = "application/json")
public class AcoountController {
    @Autowired
    TaiKhoanService  taiKhoanService;
    @GetMapping("/{id}")
    public TaiKhoan findAccountById(@PathVariable int id){
        TaiKhoan taiKhoan=  taiKhoanService.findAccountById(id);
        return  taiKhoan;
    }
    @RequestMapping(produces = "application/json")
    @PostMapping
    public TaiKhoan findAccountById(@RequestBody TaiKhoan taiKhoan){
        return taiKhoanService.saveAccountSaving(taiKhoan);
    }

    @PutMapping("{id}")
    public TaiKhoan updateAccountById(@PathVariable  int id,@RequestBody TaiKhoan taiKhoan){
        taiKhoanService.findAccountById(id);
        return  taiKhoanService.updateAccountById(taiKhoan);
    }

    @DeleteMapping("{id}")
    public void deleteAccountById(@PathVariable  int id){
        TaiKhoan taiKhoan= taiKhoanService.findAccountById(id);
        taiKhoanService.deleteAccountId(taiKhoan);
    }

    @GetMapping
    public List<TaiKhoan> getAllAccount(){
        List<TaiKhoan> taiKhoans= taiKhoanService.getAllAccount();
        return taiKhoans;
    }


}
