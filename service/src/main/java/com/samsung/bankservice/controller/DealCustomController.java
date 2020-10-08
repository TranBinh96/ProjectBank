package com.samsung.bankservice.controller;

import com.samsung.bankservice.entity.GiaoDichKhachHang;
import com.samsung.bankservice.service.GiaoDichKhacHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(path = "/dealcustom",produces = "application/json")
public class DealCustomController {
    @Autowired
    GiaoDichKhacHangService  dealcustom;
    @GetMapping("/{id}")
    public GiaoDichKhachHang findPositionById(@PathVariable int id){
        GiaoDichKhachHang giaoDichKhachHang=  dealcustom.findDealCustomById(id);
        return  giaoDichKhachHang;
    }
    @RequestMapping(produces = "application/json")
    @PostMapping
    public GiaoDichKhachHang findPositionById(@RequestBody GiaoDichKhachHang giaoDichKhachHang){
        return dealcustom.saveDealCustom(giaoDichKhachHang);
    }

    @PutMapping("{id}")
    public GiaoDichKhachHang updatePositionById(@PathVariable  int id,@RequestBody GiaoDichKhachHang giaoDichKhachHang){
        dealcustom.findDealCustomById(id);
        return  dealcustom.updatePositionById(giaoDichKhachHang);
    }

    @DeleteMapping("{id}")
    public void deletePositionById(@PathVariable  int id){
        GiaoDichKhachHang giaoDichKhachHang=  dealcustom.findDealCustomById(id);
        dealcustom.deleteDealCustomById(giaoDichKhachHang);
    }

    @GetMapping
    public List<GiaoDichKhachHang> getAllPositon(){
        List<GiaoDichKhachHang> giaoDichKhachHangs=dealcustom.getAllDealCustom();
        return giaoDichKhachHangs;
    }
}
