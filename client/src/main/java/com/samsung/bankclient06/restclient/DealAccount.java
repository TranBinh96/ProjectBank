package com.samsung.bankclient06.restclient;

import com.samsung.bankclient06.entity.GiaoDichThe;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
public class DealAccount {
    private RestTemplate rest = new RestTemplate();

    private static final String USER_REST_URL = "http://localhost:8082/dealaccount/";
    public GiaoDichThe getDealAccountById(int id) {

        GiaoDichThe giaoDichThe = rest.getForObject(USER_REST_URL + id, GiaoDichThe.class);

        return giaoDichThe;
    }

    public List<GiaoDichThe> getAllDealAccount(){
        List<GiaoDichThe>  giaoDichThes= Arrays.asList(rest.getForObject(USER_REST_URL, GiaoDichThe[].class));
        return  giaoDichThes;
    }
    public void save(GiaoDichThe taiKhoan){

        rest.postForObject(USER_REST_URL, taiKhoan, GiaoDichThe.class);
    }

}
