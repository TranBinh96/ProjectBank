package com.samsung.bankclient06.controller;

import com.samsung.bankclient06.entity.KhachHang;
import com.samsung.bankclient06.entity.NhanVien;
import com.samsung.bankclient06.entity.TaiKhoan;
import com.samsung.bankclient06.entity.TaiKhoanTinDung;
import com.samsung.bankclient06.restclient.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/taikhoan")
public class AccountController {
    @Autowired
    AccountClient account;
    @Autowired
    PerssionnalResClient perssionnalResClient;
    @Autowired
    CustomerResClient customerResClient;
    @Autowired
    AccountClient accountClient;
    @Autowired
    AccountSavingResClient accountSaving;
    @Autowired
    AccountCostomerResClient accountCreate;



    @GetMapping
    public  String Defaualt(ModelMap map, HttpSession httpSession){
        if (httpSession.getAttribute("nhanvien") != null) {
            String ten = (String) httpSession.getAttribute("nhanvien");
            String dau=ten.substring(0,1).toUpperCase();
            String cuoi=ten.substring(1);
            String name=dau+cuoi;
            map.addAttribute("username", name);
        }
        List<TaiKhoan> accounts= account.getAllAccount();
        for (TaiKhoan taiKhoan:accounts ) {
            String sodu1=taiKhoan.getSodu();
            Long sodu = Long.parseLong(sodu1);
            DecimalFormat df = new DecimalFormat("###,###.### VND");
            String so=df.format(sodu);
            taiKhoan.setSodu(so);
        }

        List<KhachHang> khachHangs= customerResClient.getAllCustomer();
        List<NhanVien> nhanViens= perssionnalResClient.getAllPersionnal();
        map.addAttribute("accounts",accounts);
        map.addAttribute("khachHangs",khachHangs);
        map.addAttribute("nhanViens",nhanViens);


        List<TaiKhoan> taiKhoans = accountClient.getAllAccount();
        map.addAttribute("nhanvien", nhanViens.size());
        map.addAttribute("khachhang", khachHangs.size());
        map.addAttribute("taikhoan", taiKhoans.size());
        return "taikhoan";
    }

    @PostMapping
    public String saveCustomer( @RequestParam int tenloaitaikhoan, @RequestParam@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date ngaytaotaikhoan,
           @RequestParam String sodu,@RequestParam int manhanvien,@RequestParam int makhachhang,ModelMap map){

        List<TaiKhoan> taiKhoans= account.getAllAccount();
        KhachHang khachHang=customerResClient.findCustomer(makhachhang);
        NhanVien nhanVien=perssionnalResClient.getPersionnalById(manhanvien);
        int mataikhoan=taiKhoans.size()+1;
        String loaitaikhoan="";
        if (tenloaitaikhoan==1)
            loaitaikhoan="Saving";
        else
            loaitaikhoan="Credit";
        TaiKhoan taiKhoan=new TaiKhoan(mataikhoan, ngaytaotaikhoan,loaitaikhoan, khachHang, nhanVien, sodu);
        if (nhanVien.getChucVu().getTenchucvu().equals("Kinh Doanh")){
           if (tenloaitaikhoan==1){
               TaiKhoanTinDung saving=new TaiKhoanTinDung();
               saving.setMataikhoantindung(mataikhoan);
               saving.setSoduhientai("50000");
           }


            account.saveAccount(taiKhoan);
        }


        return  "redirect:/taikhoan";

    }

    @GetMapping("/update")
    public String updateCustomer(@RequestParam  String tenloaitaikhoan,@RequestParam int mataikhoan, @RequestParam String sodu
            ,@RequestParam int makhachhang ,@RequestParam("ngaytaotaikhoan") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date ngaytaotaikhoan,
                                 @RequestParam int manhanvien){
        KhachHang khachHang=customerResClient.findCustomer(makhachhang);
        NhanVien nhanVien=perssionnalResClient.getPersionnalById(manhanvien);
        TaiKhoan taiKhoan=new TaiKhoan(mataikhoan, ngaytaotaikhoan,tenloaitaikhoan, khachHang, nhanVien, sodu);
        account.updateAccount(mataikhoan,taiKhoan);
        return "redirect:/taikhoan";
    }
    @GetMapping("/find")
    public String findCustomerById(ModelMap map ,@RequestParam int mataikhoan){
        TaiKhoan taiKhoan= account.findAccountById(mataikhoan);
        List<TaiKhoan> taiKhoans= new ArrayList<>();
        taiKhoans.add(taiKhoan);
        map.addAttribute("accounts",taiKhoans);;
        return "taikhoan";
    }

    @GetMapping("/delete/{id}")
    public String deleteTaiKhoanById(@PathVariable int id,ModelMap map){
        try {
            account.deleteAccountlById(id);
        }catch (Exception e){
            return "redirect:/taikhoan";
        }
        return "redirect:/taikhoan";
    }

}
