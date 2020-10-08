package com.samsung.bankclient06.controller;

import com.samsung.bankclient06.entity.ChucVu;
import com.samsung.bankclient06.entity.KhachHang;
import com.samsung.bankclient06.entity.NhanVien;
import com.samsung.bankclient06.entity.TaiKhoan;
import com.samsung.bankclient06.restclient.AccountClient;
import com.samsung.bankclient06.restclient.CustomerResClient;
import com.samsung.bankclient06.restclient.PerssionnalResClient;
import com.samsung.bankclient06.restclient.PositionRestClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/chucvu")
public class PositionController {
    @Autowired
    PositionRestClient positionRestClient;
    @Autowired
    CustomerResClient customerResClient;
    @Autowired
    PerssionnalResClient perssionnalResClient;
    @Autowired
    AccountClient accountClient;

    @GetMapping("/{id}")
    public  String getPosionById(ModelMap map,int id){
        ChucVu chucVu= positionRestClient.findAllPositionById(id);
        return "chucvu";
    }

    @GetMapping
    public  String Default(ModelMap map, HttpSession httpSession){
        if (httpSession.getAttribute("nhanvien") != null) {
            String ten = (String) httpSession.getAttribute("nhanvien");
            map.addAttribute("username", ten);
        }
        List<NhanVien> nhanViens = perssionnalResClient.getAllPersionnal();
        List<TaiKhoan> taiKhoans = accountClient.getAllAccount();
        List<KhachHang> khachHangs = customerResClient.getAllCustomer();
        map.addAttribute("nhanvien", nhanViens.size());
        map.addAttribute("khachhang", khachHangs.size());
        map.addAttribute("taikhoan", taiKhoans.size());

        List<ChucVu> chucVus= positionRestClient.getAllPositon();
        map.addAttribute("chucvus",chucVus);
        return "chucvu";
    }

    @GetMapping("/update")
    public String updatePosionById(@RequestParam int machucvu,@RequestParam String tenchucvu){
        ChucVu chucVu=new ChucVu(machucvu,tenchucvu);
        positionRestClient.updatePosition(machucvu,chucVu);
        return "redirect:/chucvu";
    }
    @GetMapping("/delete/{id}")
    public String deletePosionById(@PathVariable int id){
        positionRestClient.deletePositonById(id);
        return "redirect:/chucvu";
    }
    @GetMapping("/find")
    public String findPosionById(ModelMap map ,@RequestParam int machucvu){

        ChucVu chucVu= positionRestClient.findAllPositionById(machucvu);
        List<ChucVu> chucVus= new ArrayList<>();
        chucVus.add(chucVu);
        map.addAttribute("chucvus",chucVus);
        return "chucvu";
    }

    @PostMapping
    public String savePositon(@RequestParam String tenchucvu){
        List<ChucVu> chucVus= positionRestClient.getAllPositon();
        ChucVu chucVu=new ChucVu();
        chucVu.setMachucvu(chucVus.size()+1);
        chucVu.setTenchucvu(tenchucvu);
        positionRestClient.savePosition(chucVu);
        return "redirect:/chucvu";
    }
}
