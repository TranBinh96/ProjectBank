package com.samsung.bankservice.controller;

import com.samsung.bankservice.entity.NhanVien;
import com.samsung.bankservice.service.ChucVuService;
import com.samsung.bankservice.service.NhanVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(path = "/persionnel",produces = "application/json")
public class PersionnelContrtoller {
    @Autowired
    NhanVienService nhanVienService;

    @Autowired
    ChucVuService chucVuService;

    @GetMapping("/{id}")
    public NhanVien findPositionById(@PathVariable int id){
        NhanVien nhanVien=  nhanVienService.findPersonnnelById(id);
        return  nhanVien;
    }
    @GetMapping("/findname/{name}")
    public NhanVien findPositionByName(@PathVariable String name){
        NhanVien nhanVien=  nhanVienService.findPersonnnelByNhanVien(name);
        return  nhanVien;
    }
    @RequestMapping(produces = "application/json")
    @PostMapping
    public NhanVien findPositionById(@RequestBody NhanVien nhanVien){
        return nhanVienService.savePersionnel(nhanVien);
    }

    @PutMapping("{id}")
    public NhanVien updatePositionById(@PathVariable  int id, @RequestBody NhanVien nhanVien){
            nhanVienService.findPersonnnelById(id);
            return  nhanVienService.updatePersionnelById(nhanVien);

    }

    @DeleteMapping("{id}")
    public void deletePositionById(@PathVariable  int id){
        NhanVien nhanVien=  nhanVienService.findPersonnnelById(id);

        nhanVienService.deletePersionnelById(nhanVien);
    }

    @GetMapping
    public List<NhanVien> getAllPositon(){
        List<NhanVien> nhanViens=nhanVienService.getAllPersionnel();
        return nhanViens;
    }
}
