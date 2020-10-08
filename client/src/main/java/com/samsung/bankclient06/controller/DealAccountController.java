package com.samsung.bankclient06.controller;

import com.samsung.bankclient06.entity.*;
import com.samsung.bankclient06.restclient.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/giaodichthe")
public class DealAccountController {
    @Autowired
    DealAccount giaodichtaikhoanres;
    @Autowired
    PerssionnalResClient nhanvienres;
    @Autowired
    AccountClient taikhoan;
    @Autowired
    AccountCostomerResClient taikhoantindungres;

    @Autowired
    AccountSavingResClient taikhoantietkiemres;
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


        List<GiaoDichThe> giaoDichThes= giaodichtaikhoanres.getAllDealAccount();
        map.addAttribute("giaodichthes",giaoDichThes);

        List<NhanVien> nhanViens=nhanvienres.getAllPersionnal();
        map.addAttribute("nhanviens",nhanViens);
        List<TaiKhoanTinDung> customers= taikhoantindungres.getAllAccountCustomer();
        map.addAttribute("customers",customers);

        List<TaiKhoanTietKiem> savings= taikhoantietkiemres.getAllAccountSaving();
        map.addAttribute("savings",savings);


        List<TaiKhoan> taiKhoans = accountClient.getAllAccount();
        List<KhachHang> khachHangs = customerResClient.getAllCustomer();
        map.addAttribute("nhanvien", nhanViens.size());
        map.addAttribute("khachhang", khachHangs.size());
        map.addAttribute("taikhoan", taiKhoans.size());

        return "giaodichthe";
    }


    @PostMapping
    public String saveDealAccount(@RequestParam int loaigiaodich, @RequestParam String sotiengiaodich,
      @RequestParam int manhanvien,@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date ngaygiaodich,
      @RequestParam int mataikhoantindung,   @RequestParam int mataikhoantietkiem){

        String giaodich="";
        if (loaigiaodich==1)
            giaodich="thanhtoan";
        else
            giaodich="chuyenkhoan";

        try {
            List<GiaoDichThe> giaoDichThes= giaodichtaikhoanres.getAllDealAccount();
            int magiaodich=giaoDichThes.size()+1;
            NhanVien nhanVien=nhanvienres.getPersionnalById(manhanvien);
            TaiKhoanTinDung taiKhoanTinDung=taikhoantindungres.findAllAccountCostomer(mataikhoantindung);
            TaiKhoanTietKiem taiKhoanTietKiem=taikhoantietkiemres.findAllAccountSaving(mataikhoantietkiem);
            GiaoDichThe giaoDichThe=new GiaoDichThe();
            giaoDichThe.setMagiaodich(magiaodich);
            giaoDichThe.setLoaigiaodich(giaodich);
            giaoDichThe.setSotiengiaodich(sotiengiaodich);
            giaoDichThe.setNgaygiaodich(ngaygiaodich);
            giaoDichThe.setTaiKhoanTietKiem(taiKhoanTietKiem);
            giaoDichThe.setTaiKhoanTinDung(taiKhoanTinDung);
            giaoDichThe.setNhanVien(nhanVien);

            /////////////////////////////////////////////
//            TaiKhoan taiKhoangui=taikhoan.findAccountById(mataikhoantietkiem);
//            TaiKhoan taiKhoannhann=taikhoan.findAccountById(mataikhoantindung);
//            Double sodu=taiKhoangui.getSodu() -sotiengiaodich;
//            taiKhoangui.setSodu(sodu);
//            taikhoan.updateAccount(mataikhoantietkiem,taiKhoangui);
//            Double sodunhan=taiKhoannhann.getSodu()+sotiengiaodich;
//            taiKhoannhann.setSodu(sodunhan);
//            taikhoan.updateAccount(mataikhoantindung,taiKhoannhann);
//            giaodichtaikhoanres.save(giaoDichThe);
            return "redirect:/giaodichthe";
        }catch (Exception  e){
            return "redirect:/giaodichthe";
        }



    }

}
