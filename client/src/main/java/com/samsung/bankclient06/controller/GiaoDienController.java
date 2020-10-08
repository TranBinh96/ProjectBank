package com.samsung.bankclient06.controller;


import com.samsung.bankclient06.entity.KhachHang;
import com.samsung.bankclient06.entity.NhanVien;
import com.samsung.bankclient06.restclient.CustomerResClient;
import com.samsung.bankclient06.restclient.PerssionnalResClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SessionAttributes({"nhanvien","khachhang"})


@Slf4j
@Controller
@RequestMapping("/home")
public class GiaoDienController {
    @Autowired
    CustomerResClient customerResClient;
    @Autowired
    PerssionnalResClient perssionnalResClient;

    @GetMapping
    public String Default() {
        return "homeuser";
    }

    @PostMapping
    public String trangchu(@RequestParam String username, @RequestParam String password, ModelMap modelMap, @RequestParam String chek) {
        List<KhachHang> khachHangs = customerResClient.getAllCustomer();
        List<NhanVien> nhanViens = perssionnalResClient.getAllPersionnal();
        if (chek.equals("khachhang")) {
            for (KhachHang kh : khachHangs) {
                if (username.equals(kh.getUsername()) && password.equals(kh.getPassword())) {
                    modelMap.addAttribute("khachhang", username);
                    return "redirect:/home";
                }
            }
        }else if (chek.equals("nhanvien")){
            for (NhanVien nv : nhanViens) {
                if (username.equals(nv.getUsername()) && password.equals(nv.getPassword())) {
                    modelMap.addAttribute("nhanvien", username);
                    return "redirect:/";
                }
            }
        }
        return "homeuser";
    }
}