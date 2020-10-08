package com.samsung.bankservice.service;

import com.samsung.bankservice.entity.GiaoDichKhachHang;
import com.samsung.bankservice.responsitory.GiaoDichKhachHangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GiaoDichKhacHangService {
    @Autowired
    GiaoDichKhachHangRepository dealCustom;

    public List<GiaoDichKhachHang> getAllDealCustom(){
        return  dealCustom.findAll();
    }

    public void deleteDealCustomById(GiaoDichKhachHang giaoDichKhachHang){
        dealCustom.delete(giaoDichKhachHang);

    }

    public GiaoDichKhachHang updatePositionById(GiaoDichKhachHang giaoDichKhachHang){
        return dealCustom.save(giaoDichKhachHang);
    }

    public  GiaoDichKhachHang findDealCustomById(int id){
        Optional<GiaoDichKhachHang> giaoDichKhachHang=dealCustom.findById(id);;
        return  giaoDichKhachHang.get();
    }

    public  GiaoDichKhachHang saveDealCustom(GiaoDichKhachHang giaoDichKhachHang){

        return  dealCustom.save(giaoDichKhachHang);
    }

}
