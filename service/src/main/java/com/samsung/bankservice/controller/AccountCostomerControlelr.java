package com.samsung.bankservice.controller;

import com.samsung.bankservice.entity.TaiKhoanTinDung;
import com.samsung.bankservice.service.TaiKhoanTieuDungService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(path = "/accountcostomer",produces = "application/json")
public class AccountCostomerControlelr {
    @Autowired
    TaiKhoanTieuDungService accountCostomer;

    @GetMapping("find/{id}")
    public TaiKhoanTinDung findPositionById(@PathVariable int id){
        TaiKhoanTinDung taiKhoan=  accountCostomer.findAccountCostomerById(id);
        return  taiKhoan;
    }
    @RequestMapping(produces = "application/json")
    @PostMapping
    public TaiKhoanTinDung findPositionById(@RequestBody TaiKhoanTinDung taiKhoan){
        return accountCostomer.saveAccountCostomer(taiKhoan);
    }

    @PutMapping("{id}")
    public TaiKhoanTinDung updatePositionById(@PathVariable  int id,@RequestBody TaiKhoanTinDung taiKhoan){
        accountCostomer.findAccountCostomerById(id);
        return  accountCostomer.updateAccountCustomerById(taiKhoan);
    }

    @DeleteMapping("{id}")
    public void deletePositionById(@PathVariable  int id){
        TaiKhoanTinDung taiKhoan=  accountCostomer.findAccountCostomerById(id);
        accountCostomer.deleteAccountCostomerById(taiKhoan);
    }

    @GetMapping
    public List<TaiKhoanTinDung> getAllPositon(){
        List<TaiKhoanTinDung> taiKhoans=accountCostomer.getAllAccountCostomer();
        return taiKhoans;
    }

}
