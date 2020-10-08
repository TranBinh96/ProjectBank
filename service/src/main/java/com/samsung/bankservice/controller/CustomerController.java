package com.samsung.bankservice.controller;

import com.samsung.bankservice.entity.KhachHang;
import com.samsung.bankservice.service.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(path = "/customer" ,produces = "application/json")
public class CustomerController {
    @Autowired
    KhachHangService khachHangService;

    @GetMapping("/{id}")
    public KhachHang findCustomerById(@PathVariable int id){
        KhachHang khachHang=  khachHangService.findCustomerById(id);
        return  khachHang;
    }
    @GetMapping("/findname/{name}")
    public KhachHang findPositionByName(@PathVariable String name){
        KhachHang nhanVien=  khachHangService.findCustomerByName(name);
        return  nhanVien;
    }
    @GetMapping("/findcmt/{cmt}")
    public KhachHang findPositionByCmt(@PathVariable String cmt){
        KhachHang khachHang=  khachHangService.findCustomerByCmt(cmt);
        return  khachHang;
    }
    @RequestMapping(method =  RequestMethod.POST,produces = "application/json")
    public KhachHang findPositionById(@RequestBody KhachHang khachHang){
        return khachHangService.saveCustomer(khachHang);
    }

    @PutMapping("{id}")
    public KhachHang updatePositionById(@PathVariable  int id, @RequestBody KhachHang khachHang){
         khachHangService.findCustomerById(id);
        return  khachHangService.updateCustomerlById(khachHang);
    }

    @DeleteMapping("{id}")
    public void deletePositionById(@PathVariable  int id){
        KhachHang khachHang=  khachHangService.findCustomerById(id);

        khachHangService.deleteCustomerById(khachHang);
    }
    @GetMapping
    public List<KhachHang> getAllPositon(){
        List<KhachHang> khachHangs= khachHangService.getAllCustomer();
        return khachHangs;
    }

}
