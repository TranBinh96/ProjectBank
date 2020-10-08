package com.samsung.bankclient06.controller;
import com.samsung.bankclient06.entity.KhachHang;
import com.samsung.bankclient06.entity.NhanVien;
import com.samsung.bankclient06.entity.TaiKhoan;
import com.samsung.bankclient06.restclient.AccountClient;
import com.samsung.bankclient06.restclient.CustomerResClient;
import com.samsung.bankclient06.restclient.PerssionnalResClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/khachhang")
public class CustomerController {
    @Autowired
    CustomerResClient customerResClient;

    @Autowired
    PerssionnalResClient perssionnalResClient;
    @Autowired
    AccountClient accountClient;
    @GetMapping
    public  String Defaualt(ModelMap map, HttpSession httpSession){
        if (httpSession.getAttribute("nhanvien") != null) {
            String ten = (String) httpSession.getAttribute("nhanvien");
            String dau=ten.substring(0,1).toUpperCase();
            String cuoi=ten.substring(1);
            String name=dau+cuoi;
            map.addAttribute("username", name);
            List<KhachHang> khachHangs= customerResClient.getAllCustomer();
            map.addAttribute("khachhangs",khachHangs);
            List<NhanVien> nhanViens = perssionnalResClient.getAllPersionnal();
            List<TaiKhoan> taiKhoans = accountClient.getAllAccount();
            map.addAttribute("nhanvien", nhanViens.size());
            map.addAttribute("khachhang", khachHangs.size());
            map.addAttribute("taikhoan", taiKhoans.size());
            return "khachhang";
        }
        return "homeuser";

    }
    @PostMapping
    public String saveCustomer(@RequestParam String tenkhachhang, @RequestParam String diachi, @RequestParam("ngaysinh") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date ngaysinh, @RequestParam String chungminhthu){
        List<KhachHang> khachHangs= customerResClient.getAllCustomer();
        int makhachang=khachHangs.size()+1;
        KhachHang khachHang=new KhachHang();
        khachHang.setMakhachhang(makhachang);
        khachHang.setTenkhachhang(tenkhachhang);
        khachHang.setChungminhthu(chungminhthu);
        khachHang.setDiachi(diachi);
        khachHang.setNggaysinh(ngaysinh);
        customerResClient.saveCustomer(khachHang);
        return "redirect:/khachhang";
    }

    @GetMapping("/update")
    public String updateCustomer(@RequestParam String tenkhachhang,@RequestParam int makhachhang, @RequestParam String diachi
            ,@RequestParam String chungminhthu ,@RequestParam("ngaysinh") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date ngaysinh){
        KhachHang khachHang=new  KhachHang(makhachhang,  tenkhachhang,chungminhthu, diachi, ngaysinh) ;
        customerResClient.updateCustomer(makhachhang,khachHang);
        return "redirect:/khachhang";
    }
    @GetMapping("/find")
    public String findCustomerById(ModelMap map ,@RequestParam int makhachhang){
        KhachHang khachHang= customerResClient.findCustomer(makhachhang);
        List<KhachHang> khachHangs= new ArrayList<>();
        khachHangs.add(khachHang);

        map.addAttribute("khachhangs",khachHangs);
        return "khachhang";
    }

    @GetMapping("/delete/{id}")
    public String deleteCustomerById(@PathVariable int id){
        customerResClient.deleteCustomerById(id);
        return "redirect:/khachhang";
    }
}
