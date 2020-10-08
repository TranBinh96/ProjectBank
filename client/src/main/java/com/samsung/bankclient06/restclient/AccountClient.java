package com.samsung.bankclient06.restclient;

import com.samsung.bankclient06.entity.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
public class AccountClient {
    private RestTemplate rest = new RestTemplate();
    private static final String USER_REST_URL = "http://localhost:8082/account/";

    public TaiKhoan findAccountById(int id) {
        TaiKhoan account = rest.getForObject(USER_REST_URL + id, TaiKhoan.class);
        return account;
    }
    public List<TaiKhoan> getAllAccount (){
        List<TaiKhoan>account= Arrays.asList(rest.getForObject(USER_REST_URL, TaiKhoan[].class));
        return  account;
    }
    public void saveAccount(TaiKhoan taiKhoan){

        rest.postForObject(USER_REST_URL, taiKhoan, TaiKhoan.class);
    }

    public void deleteAccountlById (int id){
        rest.delete(  "http://localhost:8082/account/"+id,TaiKhoan.class);
    }


    public void updateAccount(int mataikhoan, TaiKhoan taiKhoan){
        rest.put("http://localhost:8082/account/"+mataikhoan, taiKhoan,TaiKhoan.class);

    }
}
