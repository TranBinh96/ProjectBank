package com.samsung.bankclient06.controller;

import com.samsung.bankclient06.entity.TaiKhoanTinDung;
import com.samsung.bankclient06.restclient.AccountCostomerResClient;
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
@RequestMapping("/thetieudung")
public class accountCustomerController {
    @Autowired
    AccountCostomerResClient accountcustomer;
    @GetMapping
    public  String Defaualt(ModelMap map, HttpSession httpSession){
        List<TaiKhoanTinDung> customers= accountcustomer.getAllAccountCustomer();
        map.addAttribute("customers",customers);
        if (httpSession.getAttribute("nhanvien") != null) {
            String ten = (String) httpSession.getAttribute("nhanvien");
            String dau=ten.substring(0,1).toUpperCase();
            String cuoi=ten.substring(1);
            String name=dau+cuoi;
            map.addAttribute("username", name);
        }
        return "taikhoantindung";
    }

    @PostMapping
    public String saveAccountCustomer(@RequestParam String tenloaitaikhoan,
                                      @RequestParam String soduhientai,
                                      @RequestParam String hanmuctoida){

        List<TaiKhoanTinDung> taiKhoanTinDungs= accountcustomer.getAllAccountCustomer();
        int mataikhoan=taiKhoanTinDungs.size()+1;

        TaiKhoanTinDung taiKhoanTinDung=new TaiKhoanTinDung();
        taiKhoanTinDung.setMataikhoantindung(mataikhoan);
        taiKhoanTinDung.setTenloaitaikhoan(tenloaitaikhoan);
        taiKhoanTinDung.setSoduhientai(soduhientai);
        taiKhoanTinDung.setHanmuctoida(hanmuctoida);
        accountcustomer.saveAccountCostomer(taiKhoanTinDung);
        return "redirect:/thetieudung";
    }

    @GetMapping("/delete/{id}")
    public String deleteAccountCustomerById(@PathVariable int id){
        accountcustomer.deleteAccountCostomerById(id);
        return "redirect:/thetieudung";
    }
    @GetMapping("/update")
    public String updateAccountCustomer(@RequestParam int mataikhoantindung,
                                        @RequestParam String tenloaitaikhoan,
                                        @RequestParam String soduhientai,
                                        @RequestParam String hanmuctoida){
        TaiKhoanTinDung taiKhoanTinDung=new TaiKhoanTinDung(mataikhoantindung,tenloaitaikhoan,soduhientai,hanmuctoida);
        accountcustomer.updateAccountCostomer(mataikhoantindung,taiKhoanTinDung);

        return "redirect:/thetieudung";
    }
    @GetMapping("/find")
    public String findAccountCustomerById(ModelMap map ,@RequestParam int mataikhoantindung){

        TaiKhoanTinDung taiKhoanTinDung= accountcustomer.findAllAccountCostomer(mataikhoantindung);
        List<TaiKhoanTinDung> taiKhoanTinDungs= new ArrayList<>();
        taiKhoanTinDungs.add(taiKhoanTinDung);
        map.addAttribute("customers",taiKhoanTinDungs);
        return "taikhoantindung";
    }
}
