package com.samsung.bankclient06.controller;

import com.samsung.bankclient06.entity.KhachHang;
import com.samsung.bankclient06.entity.NhanVien;
import com.samsung.bankclient06.entity.TaiKhoan;
import com.samsung.bankclient06.entity.TaiKhoanTietKiem;
import com.samsung.bankclient06.restclient.AccountClient;
import com.samsung.bankclient06.restclient.AccountSavingResClient;
import com.samsung.bankclient06.restclient.CustomerResClient;
import com.samsung.bankclient06.restclient.PerssionnalResClient;
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
@RequestMapping("/thetietkiem")
public class AccountSavingClientController {
    @Autowired
    AccountSavingResClient savingResClient;
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
        }
        List<NhanVien> nhanViens = perssionnalResClient.getAllPersionnal();
        List<TaiKhoan> taiKhoans = accountClient.getAllAccount();
        List<KhachHang> khachHangs = customerResClient.getAllCustomer();
        map.addAttribute("nhanvien", nhanViens.size());
        map.addAttribute("khachhang", khachHangs.size());
        map.addAttribute("taikhoan", taiKhoans.size());
        List<TaiKhoanTietKiem> savings= savingResClient.getAllAccountSaving();
        map.addAttribute("savings",savings);
        System.out.println(savings.size());
        return "taikhoantietkiem";
    }

    @GetMapping("/delete/{id}")
    public String deleteAccountSavingById(@PathVariable int id){
        savingResClient.deleteAccountSavingById(id);
        return "redirect:/thetietkiem";
    }

    @PostMapping
    public String saveAccountSaving(@RequestParam String tenloaitaikhoan,
                                    @RequestParam String laisuathangthang,
                                    @RequestParam String sodutoithieu,
                                    @RequestParam String sotienguilandau){

        List<TaiKhoanTietKiem> taiKhoanTietKiems= savingResClient.getAllAccountSaving();
        int mataikhoantietkiem=taiKhoanTietKiems.size()+1;

        TaiKhoanTietKiem taiKhoanTietKiem=new TaiKhoanTietKiem();
        taiKhoanTietKiem.setMataikhoantietkiem(mataikhoantietkiem);
        taiKhoanTietKiem.setTenloaitaikhoan(tenloaitaikhoan);
        taiKhoanTietKiem.setSodutoithieu(sodutoithieu);
        taiKhoanTietKiem.setLaisuathangthang(laisuathangthang);
        taiKhoanTietKiem.setSotienguilandau(sotienguilandau);
        savingResClient.saveAccountSaving(taiKhoanTietKiem);
        return "redirect:/thetietkiem";
    }
    @GetMapping("/update")
    public String updateAccountCustomer(@RequestParam int mataikhoantietkiem,
                                        @RequestParam String tenloaitaikhoan,
                                        @RequestParam String laisuathangthang,
                                        @RequestParam String sodutoithieu,
                                        @RequestParam String sotienguilandau){
        TaiKhoanTietKiem taiKhoanTietKiem=new TaiKhoanTietKiem(mataikhoantietkiem,tenloaitaikhoan,laisuathangthang,sodutoithieu,sotienguilandau);
        savingResClient.updateAccountSaving(mataikhoantietkiem,taiKhoanTietKiem);

        return "redirect:/thetietkiem";
    }
    @GetMapping("/find")
    public String findAccountSavingById(ModelMap map ,@RequestParam int mataikhoantietkiem){

        TaiKhoanTietKiem taiKhoanTietKiem= savingResClient.findAllAccountSaving(mataikhoantietkiem);
        List<TaiKhoanTietKiem> taiKhoanTietKiems= new ArrayList<>();
        taiKhoanTietKiems.add(taiKhoanTietKiem);
        map.addAttribute("savings",taiKhoanTietKiems);
        return "taikhoantietkiem";
    }
}
