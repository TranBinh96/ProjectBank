package com.samsung.bankclient06.restclient;

import com.samsung.bankclient06.entity.TaiKhoanTinDung;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
public class AccountCostomerResClient {
    private RestTemplate rest = new RestTemplate();
    private static final String USER_REST_URL = "http://localhost:8082/accountcostomer/";

    public TaiKhoanTinDung getAccountById(int id) {
        TaiKhoanTinDung taiKhoanTinDung = rest.getForObject(USER_REST_URL + id, TaiKhoanTinDung.class);
        return taiKhoanTinDung;
    }

    public List<TaiKhoanTinDung> getAllAccountCustomer() {
        List<TaiKhoanTinDung> taiKhoanTinDungs = Arrays.asList(rest.getForObject(USER_REST_URL, TaiKhoanTinDung[].class));
        return taiKhoanTinDungs;
    }

    public void updateAccountCostomer(int mataikhoan, TaiKhoanTinDung taiKhoanTinDung) {
        rest.put("http://localhost:8082/accountcostomer/" + mataikhoan, taiKhoanTinDung, TaiKhoanTinDung.class);

    }

    public void deleteAccountCostomerById(int id) {
        rest.delete("http://localhost:8082/accountcostomer/" + id, TaiKhoanTinDung.class);
    }

    public void saveAccountCostomer(TaiKhoanTinDung taiKhoanTinDung) {

        rest.postForObject(USER_REST_URL, taiKhoanTinDung, TaiKhoanTinDung.class);
    }
    public TaiKhoanTinDung findAllAccountCostomer(int id) {
        TaiKhoanTinDung taiKhoanTinDung = rest.getForObject("http://localhost:8082/accountcostomer/find/" + id, TaiKhoanTinDung.class);
        return taiKhoanTinDung;
    }
}



