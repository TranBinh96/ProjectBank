package com.samsung.bankservice.service;
import com.samsung.bankservice.entity.NhanVien;
import com.samsung.bankservice.responsitory.NhanVienReponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NhanVienService {
    @Autowired
    NhanVienReponsitory nhanVienReponsitory;

    public List<NhanVien> getAllPersionnel(){

        return  nhanVienReponsitory.findAll();
    }

    public void deletePersionnelById(NhanVien nhanVien){
        nhanVienReponsitory.delete(nhanVien);

    }

    public NhanVien updatePersionnelById(NhanVien nhanVien){
        return nhanVienReponsitory.save(nhanVien);
    }

    public  NhanVien findPersonnnelById(int id){
        Optional<NhanVien> nhanVien=nhanVienReponsitory.findById(id);;
        return  nhanVien.get();
    }

    public  NhanVien findPersonnnelByNhanVien(String name){
        NhanVien nhanVien= nhanVienReponsitory.findByTennhanvien(name);;
        return  nhanVien;
    }
    public  NhanVien savePersionnel(NhanVien nhanVien){
        return  nhanVienReponsitory.save(nhanVien);
    }


}
