package com.samsung.bankclient06.controller;

import com.samsung.bankclient06.entity.KhachHang;
import com.samsung.bankclient06.entity.NhanVien;
import com.samsung.bankclient06.entity.TaiKhoan;
import com.samsung.bankclient06.restclient.AccountClient;
import com.samsung.bankclient06.restclient.CustomerResClient;
import com.samsung.bankclient06.restclient.PerssionnalResClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/")
public class HomeController {
    @Autowired
    CustomerResClient customerResClient;
    @Autowired
    PerssionnalResClient perssionnalResClient;
    @Autowired
    AccountClient accountClient;


    @GetMapping
    public String Defaualt(ModelMap map, HttpSession httpSession) {
        if (httpSession.getAttribute("nhanvien") != null) {
            String ten = (String) httpSession.getAttribute("nhanvien");
            String dau = ten.substring(0, 1).toUpperCase();
            String cuoi = ten.substring(1);
            String name = dau + cuoi;
            map.addAttribute("username", name);

            List<NhanVien> nhanViens = perssionnalResClient.getAllPersionnal();
            List<TaiKhoan> taiKhoans = accountClient.getAllAccount();
            List<KhachHang> khachHangs = customerResClient.getAllCustomer();
            map.addAttribute("nhanvien", nhanViens.size());
            map.addAttribute("khachhang", khachHangs.size());
            map.addAttribute("taikhoan", taiKhoans.size());
            map.addAttribute("nhanviens", nhanViens);
            map.addAttribute("khachhangs", khachHangs);
            map.addAttribute("taiKhoans", taiKhoans);

            return "home";
        }
        else
            return "homeuser";
    }

    @GetMapping("/login")
    public  String login(HttpSession  httpSession){
        httpSession.removeAttribute("nhanvien");
        return "/homeuser";
    }

}
