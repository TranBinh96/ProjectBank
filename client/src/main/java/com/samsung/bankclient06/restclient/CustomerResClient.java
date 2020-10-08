package com.samsung.bankclient06.restclient;

import com.samsung.bankclient06.entity.KhachHang;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
public class CustomerResClient {

    private RestTemplate rest = new RestTemplate();
    private static final String USER_REST_URL = "http://localhost:8082/customer/";
    public KhachHang findCustomer(int id) {

        KhachHang khachHang = rest.getForObject(USER_REST_URL + id, KhachHang.class);

        return khachHang;
    }
    public List<KhachHang> getAllCustomer (){
        List<KhachHang> khachHangs= Arrays.asList(rest.getForObject(USER_REST_URL, KhachHang[].class));
        return  khachHangs;
    }

    public void saveCustomer(KhachHang khachHang){
        rest.postForObject(USER_REST_URL, khachHang, KhachHang.class);

    }
    public void deleteCustomerById (int id){
        rest.delete(  "http://localhost:8082/customer/"+id,KhachHang.class);
    }

    public void updateCustomer(int makhahhang, KhachHang khachHang){
        rest.put("http://localhost:8082/customer/"+makhahhang, khachHang,KhachHang.class);

    }
}
