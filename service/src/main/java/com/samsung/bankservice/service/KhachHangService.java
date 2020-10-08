package com.samsung.bankservice.service;

import com.samsung.bankservice.entity.KhachHang;
import com.samsung.bankservice.responsitory.KhachhangReponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KhachHangService {
    @Autowired
    KhachhangReponsitory khachhangReponsitory;

    public List<KhachHang> getAllCustomer(){
        return  khachhangReponsitory.findAll();
    }

    public void deleteCustomerById(KhachHang khachHang){
        khachhangReponsitory.delete(khachHang);

    }

    public KhachHang updateCustomerlById(KhachHang khachHang){
        return khachhangReponsitory.save(khachHang);
    }

    public  KhachHang findCustomerById(int id){
        Optional<KhachHang> khachHang=khachhangReponsitory.findById(id);
        return  khachHang.get();
    }

    public  KhachHang findCustomerByName(String name){
        KhachHang khachHang= khachhangReponsitory.findKhachHangByTenkhachhang(name);;
        return  khachHang;
    }
    public  KhachHang findCustomerByCmt(String cmt){
        KhachHang khachHang= khachhangReponsitory.findKhachHangByChungminhthu(cmt);;
        return  khachHang;
    }
    public  KhachHang saveCustomer(KhachHang khachHang){
        return  khachhangReponsitory.save(khachHang);
    }
}
