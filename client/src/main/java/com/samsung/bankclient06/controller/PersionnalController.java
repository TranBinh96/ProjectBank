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
@RequestMapping("/nhanvien")
public class PersionnalController {
    @Autowired
    PerssionnalResClient perssionnalResClient;
    @Autowired
    PositionRestClient positionRestClient;
    @Autowired
    CustomerResClient customerResClient;
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
            List<NhanVien> nhanViens= perssionnalResClient.getAllPersionnal();
            List<ChucVu> chucVus= positionRestClient.getAllPositon();
            map.addAttribute("nhanviens",nhanViens);
            map.addAttribute("chucvus",chucVus);
            List<TaiKhoan> taiKhoans = accountClient.getAllAccount();
            List<KhachHang> khachHangs = customerResClient.getAllCustomer();
            map.addAttribute("nhanvien", nhanViens.size());
            map.addAttribute("khachhang", khachHangs.size());
            map.addAttribute("taikhoan", taiKhoans.size());
            return "nhanvien";
        }


        return  "homeuser";
    }

    @GetMapping("/delete/{id}")
    public String deletePertionalById(@PathVariable int id){
        perssionnalResClient.deletePersionalById(id);
        return "redirect:/nhanvien";
    }
    @PostMapping
    public String savePertional(@RequestParam String tennhanvien,@RequestParam String username,@RequestParam String password, @RequestParam String diachi, @RequestParam int machucvu, @RequestParam("ngaysinh") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date ngaysinh, @RequestParam String chungminhthu){
        System.out.println(ngaysinh);
        List<NhanVien> nhanViens= perssionnalResClient.getAllPersionnal();
        int manhanvien=nhanViens.size()+1;
        ChucVu chucVu=positionRestClient.findAllPositionById(machucvu);
        username=username.toLowerCase();
        try {
            for (NhanVien nhanVien1:nhanViens){
                if (username.equals(nhanVien1.getUsername())!=true){
                    NhanVien nhanVien=new NhanVien();
                    nhanVien.setUsername(username.trim());
                    nhanVien.setPassword(password.trim());
                    nhanVien.setManhanvien(manhanvien);
                    nhanVien.setTennhanvien(tennhanvien);
                    nhanVien.setNgaysinh(ngaysinh);
                    nhanVien.setChungminhthu(chungminhthu);
                    nhanVien.setDiachi(diachi);
                    nhanVien.setChucVu(chucVu);
                    perssionnalResClient.savePersional(nhanVien);
                }
            }
        }catch (Exception e){
            return "redirect:/nhanvien";
        }

        return "redirect:/nhanvien";
    }

    @GetMapping("/update")
    public String updatePertional(@RequestParam String tennhanvien,@RequestParam String username,@RequestParam String password,@RequestParam int manhanvien, @RequestParam String diachi,@RequestParam int machucvu
            ,@RequestParam String chungminhthu ,@RequestParam("ngaysinh") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date ngaysinh){
        ChucVu chucVu=positionRestClient.findAllPositionById(machucvu);
        NhanVien nhanVien=new NhanVien(manhanvien, chungminhthu,tennhanvien, diachi,ngaysinh,chucVu,username,password);
        perssionnalResClient.updatePersionnal(manhanvien,nhanVien);

        return "redirect:/nhanvien";
    }

    @GetMapping("/find")
    public String findPertionalById(ModelMap map ,@RequestParam int manhanvien){

        try {
            NhanVien nhanVien= perssionnalResClient.getPersionnalById(manhanvien);
            List<NhanVien> nhanViens= new ArrayList<>();
            nhanViens.add(nhanVien);
            List<ChucVu> chucVus= positionRestClient.getAllPositon();
            map.addAttribute("chucvus",chucVus);
            map.addAttribute("nhanviens",nhanViens);

        }catch (Exception e){
            String error="Mã "+manhanvien +" Không Tìm Thấy";
            map.addAttribute("error",error);

            return "redirect:/nhanvien";
        }

        return "nhanvien";
    }
}
