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
@RequestMapping("/giaodichkhachhang")
public class DealCustomController {
    @Autowired
    DealCustomerResClient giaodichres;
    @Autowired
    AccountClient taikhoanres;
    @Autowired
    PerssionnalResClient nhanvienres;
    @Autowired
    CustomerResClient khachhangres;
    @Autowired
    AccountCostomerResClient taikhoantindung;

    @GetMapping
    public  String Defaualt(ModelMap map, HttpSession httpSession){
        if (httpSession.getAttribute("nhanvien") != null) {
            String ten = (String) httpSession.getAttribute("nhanvien");
            String dau=ten.substring(0,1).toUpperCase();
            String cuoi=ten.substring(1);
            String name=dau+cuoi;
            map.addAttribute("username", name);
        }
        List<GiaoDichKhachHang> giaoDichKhachHangs= giaodichres.getAllDealCustom();
        List<KhachHang> khachHangs= khachhangres.getAllCustomer();
        List<NhanVien> nhanViens= nhanvienres.getAllPersionnal();
        map.addAttribute("khachhangs",khachHangs);
        map.addAttribute("nhanviens",nhanViens);
        map.addAttribute("dealCustoms",giaoDichKhachHangs);
        return "giaodichkhachhang";
    }

    @PostMapping
    public String saveDealAccount(@RequestParam int loaigiaodich, @RequestParam String sotiengiaodich,
                                  @RequestParam int manhanvien,
                                  @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date ngaygiaodich,
                                  @RequestParam int mataikhoan,
                                  @RequestParam int makhachhang){

        String giaodich="";
        if (loaigiaodich==1)
            giaodich="thanhtoan";
        else
            giaodich="chuyenkhoan";


        List<GiaoDichKhachHang> giaoDichKhachHangs= giaodichres.getAllDealCustom();
        int magiaodich=giaoDichKhachHangs.size()+1;
        NhanVien nhanVien=nhanvienres.getPersionnalById(manhanvien);
        TaiKhoan taiKhoan=taikhoanres.findAccountById(mataikhoan);
        KhachHang khachHang=khachhangres.findCustomer(makhachhang);

        GiaoDichKhachHang giaoDichKhachHang=new GiaoDichKhachHang();
        giaoDichKhachHang.setMagiaodich(magiaodich);
        giaoDichKhachHang.setLoagiaodich(giaodich);
        giaoDichKhachHang.setSotiengiaodich(sotiengiaodich);
        giaoDichKhachHang.setNgaygiaodich(ngaygiaodich);
        giaoDichKhachHang.setTaiKhoan(taiKhoan);
        giaoDichKhachHang.setKhachHang(khachHang);
        giaoDichKhachHang.setNhanVien(nhanVien);
        try {
//            double sotiennhan=taiKhoan.getSodu();
//           double tongsodu=sotiennhan+sotiengiaodich;
//           System.out.println(tongsodu);
//           taiKhoan.setSodu(tongsodu);
//           taikhoanres.updateAccount(mataikhoan,taiKhoan);
//           if (taiKhoan.getTenloaitaikhoan().equals("Credit")){
//               TaiKhoanTinDung taiKhoanTinDung =taikhoantindung.findAllAccountCostomer(mataikhoan);
//               taiKhoanTinDung.setSoduhientai(tongsodu);
//               taikhoantindung.updateAccountCostomer(mataikhoan,taiKhoanTinDung);
//               giaodichres.save(giaoDichKhachHang);
//           }
            giaodichres.save(giaoDichKhachHang);

            return "redirect:/giaodichkhachhang";
        }catch (Exception  e){
            return "redirect:/giaodichkhachhang";
        }


    }




}
