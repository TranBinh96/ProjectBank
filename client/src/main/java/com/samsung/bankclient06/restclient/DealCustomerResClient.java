package com.samsung.bankclient06.restclient;

import com.samsung.bankclient06.entity.GiaoDichKhachHang;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
public class DealCustomerResClient {
    private RestTemplate rest = new RestTemplate();

    private static final String USER_REST_URL = "http://localhost:8082/dealcustom/";
    public GiaoDichKhachHang getDealCustomById(int id) {

        GiaoDichKhachHang giaoDichKhachHang = rest.getForObject(USER_REST_URL + id, GiaoDichKhachHang.class);

        return giaoDichKhachHang;
    }

    public List<GiaoDichKhachHang> getAllDealCustom(){
        List<GiaoDichKhachHang>  giaoDichKhachHangs= Arrays.asList(rest.getForObject(USER_REST_URL, GiaoDichKhachHang[].class));
        return  giaoDichKhachHangs;
    }
    public void save(GiaoDichKhachHang taiKhoan){

        rest.postForObject(USER_REST_URL, taiKhoan, GiaoDichKhachHang.class);
    }

}
