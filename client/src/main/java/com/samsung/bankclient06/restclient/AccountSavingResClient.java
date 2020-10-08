package com.samsung.bankclient06.restclient;
import com.samsung.bankclient06.entity.TaiKhoanTietKiem;
import com.samsung.bankclient06.entity.TaiKhoanTinDung;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
public class AccountSavingResClient {
    private RestTemplate rest = new RestTemplate();
    private static final String USER_REST_URL = "http://localhost:8082/accountsaving/";
    public TaiKhoanTietKiem getAllAccountSavingById(int id) {
        TaiKhoanTietKiem accountSaving = rest.getForObject(USER_REST_URL + id, TaiKhoanTietKiem.class);
        return accountSaving;
    }
    public List<TaiKhoanTietKiem> getAllAccountSaving (){
        List<TaiKhoanTietKiem>accountSavings= Arrays.asList(rest.getForObject(USER_REST_URL, TaiKhoanTietKiem[].class));
        return  accountSavings;
    }

    public void updateAccountSaving(int mataikhoantietkiem, TaiKhoanTietKiem taiKhoanTietKiem) {
        rest.put("http://localhost:8082/accountsaving/" + mataikhoantietkiem, taiKhoanTietKiem, TaiKhoanTinDung.class);

    }

    public void deleteAccountSavingById(int id) {
        rest.delete("http://localhost:8082/accountsaving/" + id, TaiKhoanTinDung.class);
    }

    public void saveAccountSaving(TaiKhoanTietKiem taiKhoanTietKiem) {

        rest.postForObject(USER_REST_URL, taiKhoanTietKiem, TaiKhoanTinDung.class);
    }
    public TaiKhoanTietKiem findAllAccountSaving(int id) {
        TaiKhoanTietKiem taiKhoanTietKiem = rest.getForObject("http://localhost:8082/accountsaving/find/" + id, TaiKhoanTietKiem.class);
        return taiKhoanTietKiem;
    }


}
